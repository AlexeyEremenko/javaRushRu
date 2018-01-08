
//He first findeth his own brother Simon, and saith unto him, We have found the Messias, which is, being interpreted, the Christ. (John 1:41)

package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {

    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;

    Stack<Tile[][]> previousStates = new Stack<>();
    Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    int maxTile = 2;
    int score = 0;


    public Model() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        resetGameTiles();
    }

    private void addTile() {
        List<Tile> listForChanges = getEmptyTiles();
        if (listForChanges != null && listForChanges.size() != 0) {
            listForChanges.get((int) (listForChanges.size() * Math.random())).value =
                    (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTileList = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTileList.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTileList;
    }

    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value != 0 && (tiles[i].value == tiles[i + 1].value)) {
                if (tiles[i].value + tiles[i + 1].value > maxTile) {
                    maxTile = tiles[i].value + tiles[i + 1].value;
                }
                tiles[i].value = tiles[i].value + tiles[i + 1].value;
                score += tiles[i].value;
                tiles[i + 1].value = 0;
                changes = true;
                compressTiles(tiles);
            }
        }
        return changes;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value == 0 && i < tiles.length - 1 && tiles[i + 1].value != 0) {
                Tile temp = tiles[i];
                tiles[i] = tiles[i + 1];
                tiles[i + 1] = temp;
                i = -1;
                changes = true;
            }
        }
        return changes;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(this.gameTiles);
        }
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        isSaveNeeded = true;
        if (isChanged) addTile();
    }

    public void rotate() {
        for (int k = 0; k < 2; k++) {
            for (int j = k; j < 3 - k; j++) {
                Tile alternative = gameTiles[k][j];
                gameTiles[k][j] = gameTiles[j][3 - k];
                gameTiles[j][3 - k] = gameTiles[3 - k][3 - j];
                gameTiles[3 - k][3 - j] = gameTiles[3 - j][k];
                gameTiles[3 - j][k] = alternative;
            }
        }
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 0; i < gameTiles.length - 1; i++) {
                if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tileForStack = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tileForStack[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tileForStack);
        int scoreForStack = score;
        previousScores.push(scoreForStack);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty()) {
            gameTiles = (Tile[][]) previousStates.pop();
        }
        if (!previousScores.isEmpty()) {
            score = (int)previousScores.pop();
        }
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0 : left();
            case 1 : right();
            case 2 : up();
            case 3 : down();
        }
    }
}

/*
2048 (13)

Твой прогресс впечатляет! Для разнообразия, предлагаю дать игре возможность самостоятельно

выбирать следующий ход.



Начнем с простого, реализуем метод randomMove в классе Model, который будет вызывать один из методов движения случайным образом. Можешь реализовать это вычислив целочисленное n = ((int) (Math.random() * 100)) % 4.

Это число будет содержать целое псевдослучайное число в диапазоне [0..3], по каждому из которых можешь вызывать один из методов left, right, up, down.



Не забудь добавить в метод keyPressed класса Controller вызов метода randomMove по нажатию на клавишу R (код - KeyEvent.VK_R).



P.S. Проверку корректности работы метода randomMove оставляю полностью под твою ответственность, проверю только наличие вызова метода Math.random().





Требования:

1. Метод keyPressed класса Controller должен вызывать метод randomMove у модели в случае, если была нажата клавиша с кодом KeyEvent.VK_R.

2. Метод randomMove должен использовать статический метод random класса Math.
*/
