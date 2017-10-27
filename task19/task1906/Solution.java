
//that I may come to you in joy through the will of God, and together with you, find rest. (Romans 15:32)

package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(reader.readLine());
             FileWriter fileWriter = new FileWriter(reader.readLine())) {
            int rByte;
            int count = 0;
            while ((rByte = fileReader.read()) != -1) {
                if (++count % 2 == 0) {
                    fileWriter.write(rByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным индексом.

Пример:
второй символ, четвертый символ, шестой символ и т.д.

Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным индексом (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.

package com.javarush.task.task19.task1906;

* 
Четные символы
*

public class Solution {
    public static void main(String[] args) {
    }
}
*/
