
//And the city lieth foursquare, and the length is as large as the breadth: and he measured the city with the reed, twelve thousand furlongs. The length and the breadth and the height of it are equal. (Revelation 21:16)

package com.javarush.task.task22.task2213;

public class Field {

    private int width, height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}

/*
Тетрис(6)

Теперь перейдем к классу Field.

Он будет отвечать за хранение данных о текущих занятых и свободных клетках на поле игры.

Добавь в класс Field два поля поля: width (ширина) типа int, height(высота) типа int.

Так же нам понадобится матрица - двумерный массив: matrix(матрица) типа int[][];

Там же добавь getter'ы для созданных переменных.

Добавь конструктор с двумя параметрами width и height. И не забудь про матрицу.



ВАЖНО!

Двумерный массив можно представить как массив массивов или как прямоугольную матрицу.

При этом первой координатой в массиве у нас будет номер строки, а второй - столбца.

Другими словами ячейка с координатами x, y - это matrix[y][x].





Требования:

1. В классе Field должно быть создано приватное поле width типа int.

2. В классе Field должно быть создано приватное поле height типа int.

3. В классе Field должно быть создано приватное поле matrix типа int[][](целочисленный двумерный массив).

4. В классе Field должен быть создан корректный геттер для поля height.

5. В классе Field должен быть создан корректный геттер для поля width.

6. В классе Field должен быть создан корректный геттер для поля matrix.

7. В классе Field должен быть создан корректно работающий конструктор с параметрами int, int. Поле Matrix должно быть инициализировано новым массивом размерностью [y][x] (height и width).
*/
