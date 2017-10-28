
//Pilate therefore went out to them, and said, "What accusation do you bring against this man?" (John 18:29)

package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        StringBuffer outTxt = new StringBuffer("");
        while (fileReader.ready()) {
            String string = fileReader.readLine();
            String[] words = string.split(" ");
            for (String word : words)
                if (word.length() > 6)
                    outTxt.append(word).append(",");
        }

        outTxt.delete(outTxt.length()-1,outTxt.length());
        fileWriter.write(outTxt.toString());
        fileWriter.close();
        fileReader.close();

    }
}
/*
Длинные слова
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.

package com.javarush.task.task19.task1925;

* 
Длинные слова
*

public class Solution {
    public static void main(String[] args) {

    }
}
*/
