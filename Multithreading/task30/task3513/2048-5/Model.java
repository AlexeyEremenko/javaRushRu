
//I didn't recognize him, but he who sent me to baptize in water, he said to me, 
//'On whomever you will see the Spirit descending, and remaining on him, the same is he who baptizes in the Holy Spirit.' (John 1:33)

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
}

/*
2048 (5)

Основными возможностями, которые мы должны реализовать, являются перемещения влево, вправо, вверх и вниз.

Если ты раньше уже играл в 2048, то знаешь, что при перемещении в одну из сторон, происходит перемещение плиток со значениями на место пустых, а также объединение плиток одного номинала.



В качестве базового сценария рассмотрим движение влево и подумаем что же происходит, когда мы хотим выполнить это действие.



Для каждого ряда или столбца, происходят на самом деле две вещи:

а) Сжатие плиток, таким образом, чтобы все пустые плитки были справа, т.е. ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}

б) Слияние плиток одного номинала, т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.

Обрати внимание, что ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0}, а {4, 4, 4, 0} в {8, 4, 0, 0}.



Создай методы compressTiles(Tile[] tiles) и mergeTiles(Tile[] tiles), которые будут реализовывать пункты а) и б) соответственно. Использовать мы их будем только внутри класса Model, поэтому уровень доступа сделай максимально узким.



Также добавь поля score и maxTile типа int, которые должны хранить текущий счет и максимальный вес плитки на игровом поле. Счет увеличивается после каждого слияния, например если текущий счет 20 и было выполнено слияние ряда {4, 4, 4, 0}, счет должен увеличиться на 8. Уровень доступа к полям должен быть шире приватного.

Проще всего организовать обновление значений этих полей в методе mergeTiles, например так:

1. Если выполняется условие слияния плиток, проверяем является ли новое значения больше максимального и при необходимости меняем значение поля maxTile.

2. Увеличиваем значение поля score на величину веса плитки образовавшейся в результате слияния.



P.S. Когда мы будем реализовывать методы движения, сжатие будет всегда выполнено перед слиянием, таким образом можешь считать, что в метод mergeTiles всегда передается массив плиток без пустых в середине.





Требования:

1. Метод mergeTiles должен быть реализован в соответствии с условием задачи.

2. Метод compressTiles должен быть реализован в соответствии с условием задачи.

3. Метод compressTiles должен быть приватным.

4. Метод mergeTiles должен быть приватным.

5. Метод mergeTiles должен корректно обновлять значение поля score.

6. Метод mergeTiles должен корректно обновлять значение поля maxTile.

7. Поля score и maxTile должны быть инициализированы как 0 и 2 при создании новой модели.
*/
