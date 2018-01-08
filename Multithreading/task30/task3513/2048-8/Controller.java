
//And looking upon Jesus as he walked, he saith, Behold the Lamb of God! (John 1:36)

package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

public class Controller extends KeyAdapter {

    Model model = new Model();

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
       return model.score;
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
