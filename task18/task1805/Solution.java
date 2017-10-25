
//Not for these only do I pray, but for those also who believe in me through their word (John 17:20)

package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String filename = reader.nextLine();

        FileInputStream fileInputStream = new FileInputStream(filename);
        TreeSet<Integer> set = new TreeSet<>();

        //read from file
        while (fileInputStream.available() > 0) {
            set.add(fileInputStream.read());
        }

        fileInputStream.close();

        //Выводим
        for (int element : set)
            System.out.print(element + " ");
    }
}


/*
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений — отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.


package com.javarush.task.task18.task1805;

import java.io.FileInputStream;

* 
Сортировка байт
*

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}

*/
