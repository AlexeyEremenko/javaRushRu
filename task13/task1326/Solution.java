package com.javarush.task.task13.task1326;

//I will not leave you comfortless: I will come to you. (John 14:18)
//I will not leave you orphans. I will come to you.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
  public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        String line;
        List<Integer> list = new LinkedList<>();
        while ((line = fileReader.readLine()) != null) {
            list.add(Integer.valueOf(line));
        }

        list.stream().filter(v -> v % 2 == 0).sorted().forEach(System.out::println);

        reader.close();
        fileReader.close();
    }
}



/*
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
11
3
2
10

Пример вывода:
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
3. Программа должна выводить данные на экран.
4. Программа должна закрывать поток чтения из файла(FileInputStream).

package com.javarush.task.task13.task1326;

* 
Сортировка четных чисел из файла
*

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
    }
}

*/
