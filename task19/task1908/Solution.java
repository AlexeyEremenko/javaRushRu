
//I commend to you Phoebe, our sister, who is a servant of the assembly that is at Cenchreae (Romans 16:1)

package com.javarush.task.task19.task1908;

/* 
Выделяем числа

d:\_JavaRush\_Test\19.05.03.txt
d:\_JavaRush\_Test\temp.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                for (String chunk : line.split(" ")) {
                    try {
                        fileWriter.write(Integer.parseInt(chunk) + " ");
                    } catch (NumberFormatException e) {
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }    }
}
/*
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.

package com.javarush.task.task19.task1908;

* 
Выделяем числа
*

public class Solution {
    public static void main(String[] args) {
    }
}
*/
