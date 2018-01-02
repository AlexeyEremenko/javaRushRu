
//The Revelation of Jesus Christ, which God gave unto him, to shew unto his servants things which must shortly come to pass; and he sent and signified [it] by his angel unto his servant John (Revelation 1:1)

package com.javarush.task.task25.task2515;

public class Canvas {

    private int width, height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
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
Space (8)

Что мы будем делать с Canvas?

Мы будем рисовать на нем (в его матрице).



Поэтому нам понадобятся два метода:

public void setPoint(double x, double y, char c),

public void drawMatrix(double x, double y, int[][] matrix, char c).



Первый метод - setPoint будет "ставить точку в координатах x,y цветом c".

В методе надо:

а) округлить x и y до целых чисел,

б) занести в matrix[y][x] значение с,

в) ничего не делать, если x<0 или y<0 или y>matrix.length или x>matrix[0].length.



Второй метод - drawMatrix копирует переданную ему картинку (матрицу) в матрицу Canvas.

И не просто копирует, а начиная с координат x, y.



В методе надо:

а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки,

б) если значение ячейки matrix[i][j] не равно 0, то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:

setPoint(x+j, y+i, c)





Требования:

1. В классе Canvas создай метод public void setPoint(double x, double y, char c).

2. Метод setPoint должен заносить в матрицу по координатам x, y символ с.

3. В классе Canvas создай метод public void drawMatrix(double x, double y, int[][] matrix, char c).

4. Метод drawMatrix, начиная с координат x, y, должен заполнять полотно символами с, согласно переданной в метод матрицей matrix.
*/
