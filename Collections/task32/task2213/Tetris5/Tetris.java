
//And he that talked with me had a golden reed to measure the city, and the gates thereof, and the wall thereof. (Revelation 21:15)

package com.javarush.task.task22.task2213;

public class Tetris {

    private Field field;
    private Figure figure;

    public static Tetris game;

    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }

    public void step() {}
    public void run() {}

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }
}

/*
Тетрис(5)

Теперь нужно создать объект самого Тетриса.

Добавь в класс Tetris статическое поле game типа Tetris.

Поле game НЕ должно быть приватным.



Затем в методе main создай объект типа Тетрис и сохрани его в эту переменную.

Затем добавь вызов метода run.





Требования:

1. В классе Tetris должно быть создано поле game.

2. Поле game НЕ должно быть приватным.

3. Поле game должно быть статическим.

4. Поле game должно быть типа Tetris.

5. В методе main поле game должно быть инициализировано новым объектом типа Tetris.

6. В методе main должен быть вызван метод run на объекте сохраненном в поле game.
*/
