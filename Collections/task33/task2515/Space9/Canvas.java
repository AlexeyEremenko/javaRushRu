
//Blessed [is] he that readeth, and they that hear the words of this prophecy, and keep those things which are written therein:
//for the time [is] at hand. (Revelation 1:2)

package com.javarush.task.task25.task2515;

public class Canvas {

    private int width, height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }

    public void clear() {
        //drawMatrix(0,0,new int[width][height],' ');
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width ; j++) {
                matrix[i][j] = ' ';
            }
            System.out.println();
        }
        System.out.println();
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setPoint(double x, double y, char c) {
        int xRnd = (int) Math.round(x);
        int yRnd = (int) Math.round(y);
        if (xRnd >= 0 && xRnd < matrix[0].length && yRnd >= 0 && yRnd < matrix.length) {
            matrix[yRnd][xRnd] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}

/*
Space (9)

Еще Canvas понадобится два метода, напиши их.

а) метод clear();

Этот метод будет очищать матрицу, чтобы на ней снова можно было рисовать.

Например заменить все символы матрицы на пробелы.



б) метод print();

Этот метод отрисовывает матрицу на экран.

Тут уже ты должен сам разобраться: вывести набор символов не так уж и сложно.

Не забудь добавить пару пустых строк в конце, чтобы матрицы выведенные в разное время не слипались.





Требования:

1. В классе Canvas создай метод clear().

2. Метод clear() должен очищать матрицу.

3. В классе Canvas создай метод print().

4. Метод print() должен отрисовыть матрицу в консоль.
*/
