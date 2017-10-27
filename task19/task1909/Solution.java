
//that you receive her in the Lord, in a way worthy of the saints, and that you assist her in whatever matter she may need from you, for she herself also has been a helper of many, and of my own self (Romans 16:2)

package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                fileWriter.write(line.replaceAll("\\.", "!"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки «.» на знак «!«.
Результат вывести во второй файл.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.

package com.javarush.task.task19.task1909;

* 
Замена знаков
*

public class Solution {
    public static void main(String[] args) {
    }
}
*/
