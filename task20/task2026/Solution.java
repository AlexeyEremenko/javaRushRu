
//where they crucified him, and with him two others, on either side one, and Jesus in the middle. (John 19:18)

package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

   public static int getRectangleCount(byte[][] a) {
        Map<Byte, Integer> map = new TreeMap<>();

        for (int x = 0; x < a.length; x++)
            for (int y = 0; y < a[0].length; y++) {
                byte sum = 0;
                if (a[x][y] == 0) continue;
                sum += (x - 1 >= 0 && y - 1 >= 0) ? a[x - 1][y - 1] : 0;                  // a[x - 1][y - 1]
                sum += (y - 1 >= 0) ? a[x][y - 1] : 0;                                    // a[x][y - 1]
                sum += (x + 1 < a.length && y - 1 >= 0) ? a[x + 1][y - 1] : 0;            // a[x + 1][y - 1]
                sum += (x - 1 >= 0) ? a[x - 1][y] : 0;                                    // a[x - 1][y]
                sum += a[x][y];                                                           // a[x][y]
                sum += (x + 1 < a.length) ? a[x + 1][y] : 0;                              // a[x + 1][y]
                sum += (x - 1 >= 0 && y + 1 < a[0].length) ? a[x - 1][y + 1] : 0;         // a[x - 1][y + 1]
                sum += (y + 1 < a[0].length) ? a[x][y + 1] : 0;                           // a[x][y + 1]
                sum += (x + 1 < a.length && y + 1 < a[0].length) ? a[x + 1][y + 1] : 0;   // a[x + 1][y + 1]

                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }

        int rectangleCount = 0;
        rectangleCount += map.containsKey((byte) 4) ? map.get((byte) 4) / 4 : 0;
        rectangleCount += map.containsKey((byte) 2) ? map.get((byte) 2) / 2 : 0;
        rectangleCount += map.containsKey((byte) 1) ? map.get((byte) 1) : 0;

        return rectangleCount;
    }
}
/*
Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании


Требования:
1. В классе Solution должен существовать метод getRectangleCount с одним параметром типа byte[][].
2. Метод getRectangleCount должен быть публичным.
3. Метод getRectangleCount должен быть статическим.
4. Метод getRectangleCount должен возвращать количество прямоугольников (в соответствии с заданием) найденное в полученном массиве.

package com.javarush.task.task20.task2026;

* 
Алгоритмы-прямоугольники
*
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        return 0;
    }
}
*/
