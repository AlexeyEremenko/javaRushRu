
//Nathanael said to him, "Can any good thing come out of Nazareth?" Philip said to him, "Come and see." (John 1:46)

package com.javarush.task.task26.task2601;

/* 
Почитать в инете про медиану выборки
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
       
        final double mediana;            //implement logic here
        int mid = array.length / 2;
        Arrays.sort(array);

        if (array.length % 2 != 0) {
            mediana = array[mid];
        } else {
            mediana = (array[mid - 1] + array[mid]) / 2.0;
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double result = Math.abs(o1 - mediana) - Math.abs(o2 - mediana);

                return result == 0 ? o1 - o2 : (int) Math.round(result);
            }
        });
        return array;
    }
}
/*
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5


Требования:
1. Программа не должна выводить текст в консоль.
2. Программа не должна считывать данные с консоли.
3. Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
4. Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности от его медианы.
*/
