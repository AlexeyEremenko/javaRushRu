
//And the city had no need of the sun, neither of the moon, to shine in it: 
//for the glory of God did lighten it, and the Lamb is the light thereof. (Revelation 21:23)

package com.javarush.task.task22.task2213;

public class Field {

    private int width, height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = matrix[i][j];
                if (index == 0)
                    System.out.print(".");
                else if (index == 1)
                    System.out.print("X");
            }
            System.out.println();
        }
    }

    public void removeFullLines() {}

    public Integer getValue(int x, int y) {
        return matrix[x][y];
    }

    public void setValue(int x, int y, int value) {
        matrix[x][y] = value;
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
Тетрис(13)

Теперь приступим к реализации созданных методов.

Напиши реализацию метода print в классе Field

а) Метод должен выводить на экран прямоугольник состоящий из символов '.' и 'X'.

б) Высота прямоугольника равна height, ширина - width

в) Если данная клетка пустая - вывести точку, если не пустая - английский X



Подсказка:

if (matrix[y][x]==0) ...





Требования:

1. Метод print должен выводить данные на экран.

2. Метод print должен выводить на экран количество строк равное height.

3. Количество символов в каждой строке выведенной на экран должно быть равно width.

4. В случае, если элемент массива равен 0 - на экран должна быть выведена точка, иначе - английский X.


*/
