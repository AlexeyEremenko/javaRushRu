
//And he measured the wall thereof, an hundred and forty and four cubits, according to the measure of a man, that is, of the angel. (Revelation 21:17)

package com.javarush.task.task22.task2213;

public class Field {

    private int width, height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public void print() {}
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
Тетрис(7)

Нам понадобится еще 4 метода в классе Field:

а) print() - объект будет отрисовывать на экран свое текущее состояние;

б) removeFullLines() - будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз;

в) Integer getValue(int x, int y) - возвращает значение которое находится в матрице с координатами x и y;

г) void setValue(int x, int y, int value) - устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y.





Требования:

1. В классе Field должен быть создан метод print без параметров.

2. В классе Field должен быть создан метод removeFullLines без параметров.

3. В классе Field должен быть создан метод getValue с двумя параметрами типа int.

4. В классе Field должен быть создан метод setValue c тремя параметрами типа int.

5. Метод print не должен возвращать значение.

6. Метод removeFullLines не должен возвращать значение.

7. Метод getValue должен возвращать значение типа Integer.

8. Метод setValue не должен возвращать значение.
*/
