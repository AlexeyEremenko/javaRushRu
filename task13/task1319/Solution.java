package com.javarush.task.task13.task1319;

//But put ye on the Lord Jesus Christ, and make not provision for the flesh, to fulfil the lusts thereof. (Romans 13:14)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        String line;
        List<String> list = new LinkedList<>();
        while (!(line = reader.readLine()).equals("exit")) {
            list.add(line);
        }
        list.add(line);

        for (String s : list) {
            writer.write(String.format("%s%n",s));
        }

        reader.close();
        writer.close();
    }
}


/*
Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего читать из файловой системы.
4. Программа должна читывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.

package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
    }
}

*/
