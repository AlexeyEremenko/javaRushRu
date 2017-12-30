
//And they shall bring the glory and honour of the nations into it. (Revelation 21:26)

package com.javarush.task.task22.task2213;

public class Figure {

    private int x,y;
    private int[][] matrix = new int[3][3];

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public void left() {
        x--;
        if (!isCurrentPositionAvailable())
            x++;
    }

    /**
     * Двигаем фигурку вправо.
     * Проверяем не вылезла ли она за границу поля и/или не залезла ли на занятые клетки.
     */
    public void right() {
        x++;
        if (!isCurrentPositionAvailable())
            x--;
    }

    /**
     * Двигаем фигурку вверх.
     * Используется, если фигурка залезла на занятые клетки.
     */
    public void up() {
        y--;
    }

    /**
     * Двигаем фигурку вниз.
     */
    public void down() {
        y++;
    }

    public void rotate() {}
    public void downMaximum() {}
    public void landed() {}
    public boolean isCurrentPositionAvailable() {return true;}


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
Тетрис(16)

Напиши свою реализацию методов left(), right(), up(), down() в классе Figure.

Подумай, что должны делать эти методы?





Требования:

1. Метод left должен уменьшать значение поля x на единицу, если это возможно(не нарушены границы игрового поля).

2. Метод right должен увеличивать значение поля x на единицу, если это возможно(не нарушены границы игрового поля).

3. Метод up должен уменьшать значение поля y на единицу.

4. Метод down должен увеличивать значение поля y на единицу.


*/
