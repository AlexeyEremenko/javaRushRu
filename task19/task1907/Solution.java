
//Now the God of peace be with you all. Amen. (Romans 15:33)

package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileReader stream = new FileReader(file);

        String line = "";
        while (stream.ready()){
            line += (char)stream.read();
        }

        line = line.replaceAll("[\\p{Punct}+|\\s]"," ");
        String[] lineArr = line.split(" ");
        int counter = 0;
        for (int i = 0; i < lineArr.length; i++) {
            if (lineArr[i].equals("world")){
                counter = counter + 1;
            }
        }

        System.out.println(counter);

        reader.close();
        stream.close();
    }
}
/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.

package com.javarush.task.task19.task1907;

* 
Считаем слово
*

public class Solution {
    public static void main(String[] args) {
    }
}
*/
