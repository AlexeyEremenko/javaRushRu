
//And the building of the wall of it was of jasper: and the city was pure gold, like unto clear glass. (Revelation 21:18)

package com.javarush.task.task22.task2213;

public class Figure {

    private int x,y;
    private int[][] matrix = new int[3][3];

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}

/*
Тетрис(8)

Теперь создадим костяк класса Figure.

Этот класс будет описывать падающую фигурку.



Нам понадобятся ее координаты и форма.

За координаты будут отвечать две переменные x и y.

За форму - матрица. Двумерный массив 3×3, состоящий из единиц и нулей.

Единицей мы обозначаем что клетка есть, нулем - что она пустая.



Добавь в класс Figure два поля поля: x типа int, y типа int.

Еще добавь двумерный массив: matrix(матрица) типа int[][].

Там же добавь getter'ы для созданных переменных.

Добавь конструктор с тремя параметрами x, y, matrix.





Требования:

1. В классе Figure должно быть создано приватное поле x типа int.

2. В классе Figure должно быть создано приватное поле y типа int.

3. В классе Figure должно быть создано приватное поле matrix типа int[][](целочисленный двумерный массив).

4. В классе Figure должен быть создан корректный геттер для поля х.

5. В классе Figure должен быть создан корректный геттер для поля y.

6. В классе Figure должен быть создан корректный геттер для поля matrix.

7. В классе Figure должен быть создан корректно работающий public конструктор с тремя параметрами int, int и int[][] (x, y и matrix).
*/
