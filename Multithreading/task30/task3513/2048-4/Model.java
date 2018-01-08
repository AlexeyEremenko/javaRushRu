
//And John bare record, saying, I saw the Spirit descending from heaven like a dove, and it abode upon him. (John 1:32)

package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;

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
}

/*
2048 (4)

Игра 2048 начинается на поле, где две плитки уже имеют какие-то начальные значения. А наше поле пока пусто :(.



Прежде чем бросаться писать код, давай подумаем как это можно было бы реализовать.



Предлагаю создать приватный метод addTile, который будет смотреть какие плитки пустуют и менять вес одной из них,



выбранной случайным образом, на 2 или 4 (на 9 двоек должна приходиться 1 четверка). Получить случайный объект из списка



можешь использовав следующее выражение: (размерСписка * случайноеЧислоОтНуляДоЕдиницы).



Также получение свободных плиток можно вынести в отдельный приватный метод getEmptyTiles, возвращающий список



свободных плиток в массиве gameTiles.



После реализации функционала добавления новых плиток, добавим в конструктор два вызова метода addTile,



выполняя начальное условие задачи.



P.S. Пожалуй стоит весь код из конструктора переместить в метод resetGameTiles, для того, чтобы при необходимости



начать новую игру, не приходилось создавать новую модель, а можно было бы просто вернуться в начальное состояние



вызвав его. Уровень доступа должен быть шире приватного.



P.P.S. Для вычисления веса новой плитки используй выражение (Math.random() < 0.9 ? 2 : 4).





Требования:

1. Метод getEmptyTiles должен возвращать список пустых плиток в массиве gameTiles.

2. Метод addTile должен изменять значение случайной пустой плитки в массиве gameTiles на 2 или 4 с вероятностью 0.9 и 0.1 соответственно.

3. Метод resetGameTiles должен заполнять массив gameTiles новыми плитками и менять значение двух из них с помощью двух вызовов метода addTile.

4. В конструкторе класса Model должен содержаться вызов метода resetGameTiles.
*/
