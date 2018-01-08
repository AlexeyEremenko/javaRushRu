
//On the next day, he was determined to go out into Galilee, and he found Philip. Jesus said to him, "Follow me." (John 1:43)

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

    public boolean hasBoardChanged(){
        int sum1 = 0;
        int sum2 = 0;
        if(!previousStates.isEmpty()) {
            Tile[][] prevGameTiles = previousStates.peek();
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    sum1 += gameTiles[i][j].value;
                    sum2 += prevGameTiles[i][j].value;
                }
            }
        }
        return sum1 != sum2;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();

        return moveEfficiency;
    }
}

/*
2048 (15)

Для того, чтобы эффективности различных ходов можно было сравнивать, необходимо реализовать в классе MoveEfficiency поддержку интерфейса Comparable.



В методе compareTo первым делом сравни количество пустых плиток (numberOfEmptyTiles), потом счет (score), если количество пустых плиток равное. Если и счет окажется равным, будем считать эффективность ходов равной и вернем ноль.



Далее перейдем в класс Model и реализуем два метода:

1) boolean hasBoardChanged - будет возвращать true, в случае, если вес плиток в массиве gameTiles отличается от веса плиток в верхнем массиве стека previousStates. Обрати внимание на то, что мы не должны удалять из стека верхний элемент, используй метод peek.

2) MoveEfficiency getMoveEfficiency(Move move) - принимает один параметр типа move, и возвращает объект типа MoveEfficiency описывающий эффективность переданного хода. Несколько советов:

а) не забудь вызывать метод rollback, чтобы восстановить корректное игровое состояние;

б) в случае, если ход не меняет состояние игрового поля, количество пустых плиток и счет у объекта MoveEfficiency сделай равными -1 и 0 соответственно;

в) выполнить ход можно вызвав метод move на объекте полученном в качестве параметра.





Требования:

1. Класс MoveEfficiency должен поддерживать интерфейс Comparable.

2. Метод compareTo должен корректно сравнивать два объекта типа MoveEfficiency.

3. Метод hasBoardChanged должен быть реализован в соответствии с условием задачи.

4. Метод getMoveEfficiency должен возвращать эффективность хода полученного в качестве параметра.

5. Если ход, переданный в метод getMoveEfficiency не меняет игровое поле, должен быть возвращен объект с количеством пустых клеток равным -1.

6. Метод getMoveEfficiency не должен менять вес плиток в массиве gameTiles и счет.


*/
