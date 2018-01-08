
//And looking upon Jesus as he walked, he saith, Behold the Lamb of God! (John 1:36)

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
}

/*
2048 (8)

Итак, модель почти готова, добавим еще пару простых методов и начнем реализацию контроллера.



В модели нам не хватает способа получить игровое поле, чтобы передать его представлению на отрисовку, а также метода, выполнив который, можно было бы определить возможен ли ход в текущей позиции, или нет.



Контроллер, в свою очередь, будет в основном использоваться для обработки пользовательского ввода с клавиатуры, поэтому сделаем его наследником класса KeyAdapter.



Нам понадобятся приватные поля model и view соответствующих типов и методы getGameTiles и getScore, возвращающие подходящие свойства модели.



По пунктам:

1. Добавь в класс Model геттер для поля gameTiles.

2. Добавь в класс Model метод canMove возвращающий true в случае, если в текущей позиции возможно сделать ход так, чтобы состояние игрового поля изменилось. Иначе - false.

3. Сделай класс Controller потомком класса KeyAdapter.

4. Добавь в класс Controller метод getGameTiles вызывающий такой же метод у модели.

5. Добавь в класс Controller метод getScore возвращающий текущий счет (model.score).





Требования:

1. В классе Model должен быть реализован корректный геттер для поля gameTiles.

2. Метод canMove в классе Model должен быть реализован в соответствии с условием задачи.

3. Класс Controller должен быть потомком класса KeyAdapter.

4. Метод getGameTiles в классе Controller должен возвращать результат вызова метода getGameTiles у модели.

5. Метод getScore в классе Controller должен возвращать значение поля score модели.
*/
