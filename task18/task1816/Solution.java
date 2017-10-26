
//They answered him, "Jesus of Nazareth." Jesus said to them, "I am he." Judas also, who betrayed him, was standing with them. (John 18:5)

http://wikijava.it-cache.net/index.php@title=Glava_16_Thinking_in_Java_4th_edition.html#.D0.92.D0.B2.D0.BE.D0.B4_.D0.B8_.D0.B2.D1.8B.D0.B2.D0.BE.D0.B4

package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String alphabetLow = "abcdefghijklmnopqrstuvwxyz";
        String alphabetHigh = alphabetLow.toUpperCase();

        FileReader fileReader = new FileReader(args[0]);

        int count = 0;
        while (fileReader.ready()) {
            char s = (char) fileReader.read();
            if ((alphabetLow.indexOf(s) > -1) || alphabetHigh.indexOf(s) > -1)
                count++;
        }
        fileReader.close();

        System.out.println(count);

    }
}




/*
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.

package com.javarush.task.task18.task1816;

* 
Английские буквы
*

public class Solution {
    public static void main(String[] args) {
    }
}



*/
