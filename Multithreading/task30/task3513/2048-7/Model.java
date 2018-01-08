
//Again the next day after John stood, and two of his disciples (John 1:35)

package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;

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

        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
            }
        }
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
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void down() {
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }
}

/*
2048 (7)

Движение влево мы реализовали, теперь необходимо реализовать методы right, up, down. Уверен, что ты с этим справишься и без моей помощи, так что дам только одну подсказку.



Что будет, если повернуть двумерный массив на 90 градусов по часовой стрелке, сдвинуть влево, а потом еще трижды выполнить поворот?





Требования:

1. Метод up должен перемещать элементы массива gameTiles вверх в соответствии с правилами игры и добавлять плитку с помощью метода addTile, если это необходимо.

2. Метод up НЕ должен изменять массив gameTiles если перемещение вверх невозможно.

3. Метод down должен перемещать элементы массива gameTiles вниз в соответствии с правилами игры и добавлять плитку с помощью метода addTile, если это необходимо.

4. Метод down НЕ должен изменять массив gameTiles если перемещение вниз невозможно.

5. Метод right должен перемещать элементы массива gameTiles вправо в соответствии с правилами игры и добавлять плитку с помощью метода addTile, если это необходимо.

6. Метод right НЕ должен изменять массив gameTiles если перемещение вправо невозможно.
*/
