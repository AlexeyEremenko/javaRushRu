
//And I saw, and bare record that this is the Son of God (John 1:34)

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
}

/*
2048 (6)

Итак, ты реализовал сжатие и слияние плиток, что в комбинации дает нам возможность осуществить движение влево.

Отлично! Но нам нужно еще и добавлять новую плитку в случае, если после передвижения игровое поле изменилось.



Давай сделаем так:

1. Изменим метод compressTiles, чтобы он возвращал true в случае, если он вносил изменения во входящий массив, иначе - false.

2. То же самое сделаем и для метода mergeTiles.

3. Реализуем метод left, который будет для каждой строки массива gameTiles вызывать методы compressTiles и mergeTiles и добавлять одну плитку с помощью метода addTile в том случае, если это необходимо.

4. Метод left не должен быть приватным, т.к. вызваться он будет, помимо прочего, из класса Controller.





Требования:

1. Метод compressTiles должен возвращать true в случае, если им были внесены изменения во входящий массив.

2. Метод compressTiles должен возвращать false в случае, если им НЕ были внесены изменения во входящий массив.

3. Метод mergeTiles должен возвращать true в случае, если им были внесены изменения во входящий массив.

4. Метод mergeTiles должен возвращать false в случае, если им НЕ были внесены изменения во входящий массив.

5. Метод left должен перемещать элементы массива gameTiles влево в соответствии с правилами игры и добавлять плитку с помощью метода addTile, если это необходимо.

6. Метод left НЕ должен изменять массив gameTiles, если перемещение влево невозможно.
*/
