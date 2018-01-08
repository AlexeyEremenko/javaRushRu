
//And I knew him not: but that he should be made manifest to Israel, therefore am I come baptizing with water. (John 1:31)

package com.javarush.task.task35.task3513;

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
    }
}

/*
2048 (3)

Займемся реализацией класса Model. Он будет ответственен за все манипуляции производимые с игровым полем.



Но чтобы как-то манипулировать игровым полем, неплохо было бы для начала его создать!



Нам понадобятся:

1. Приватная константа FIELD_WIDTH = 4, определяющая ширину игрового поля.

2. Приватный двумерный массив gameTiles состоящий из объектов класса Tile.

3. Конструктор без параметров инициализирующий игровое поле и заполняющий его пустыми плитками.





Требования:

1. В классе Model должно быть создано private static final поле FIELD_WIDTH со значением равным четырем.

2. В классе Model должно быть создано private поле gameTiles типа Tile[][].

3. Конструктор без параметров класса Model должен заполнять массив gameTiles новыми объектами типа Tile.

4. Массив gameTiles должен иметь размерность FIELD_WIDTH x FIELD_WIDTH.
*/
