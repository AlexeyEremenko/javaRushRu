
//And the great dragon was cast out, that old serpent, called the Devil, and Satan,
//which deceiveth the whole world: he was cast out into the earth, and his angels were cast out with him. (Revelation 12:9)

package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int side = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i * j == 0)
                    continue;
                if (matrix[i][j] == 1)
                    matrix[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])) + 1;

                if (matrix[i][j] > side)
                    side = matrix[i][j];
            }
        }

        return side * side;
    }
}

/*
Максимальная площадь

Реализуй метод int maxSquare(int[][] matrix), возвращающий площадь самого большого квадрата состоящего из единиц в двумерном массиве matrix.

Массив matrix заполнен только нулями и единицами.





Требования:

1. Метод maxSquare должен быть реализован в соответствии с условием задачи.

2. Метод maxSquare должен эффективно работать с большими массивами.

3. Метод maxSquare должен быть публичным.

4. Метод maxSquare должен возвращать число типа int.

5. Метод maxSquare должен быть статическим.
*/
