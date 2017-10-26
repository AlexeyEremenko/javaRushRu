
//Simon Peter therefore, having a sword, drew it, and struck the high priest's servant, and cut off his right ear. The servant's name was Malchus. (John 18:10)

package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Byte, Integer> map = new TreeMap<Byte, Integer>();
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            for (int i = 0; i < buffer.length; i++) {
                if (map.containsKey(buffer[i]))
                    map.put(buffer[i], map.get(buffer[i]) + 1);
                else
                    map.put(buffer[i], 1);
            }
        }
        fileInputStream.close();

        for (Map.Entry pair : map.entrySet()) {
            System.out.println((char)((byte) pair.getKey()) + " " + pair.getValue());
        }
    }
}

/*
Встречаемость символов
Программа запускается с одним параметром — именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
‘,’=44, ‘s’=115, ‘t’=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.

package com.javarush.task.task18.task1821;

* 
Встречаемость символов
*

public class Solution {
    public static void main(String[] args) {

    }
}

*/
