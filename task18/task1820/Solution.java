
//that the word might be fulfilled which he spoke, "Of those whom you have given me, I have lost none." (John 18:9)


package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = br.readLine();
        String fileName2 = br.readLine();

        //read file
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        while (fileReader.ready())
            list.add(fileReader.readLine());
        fileReader.close();

        //parse and round
        ArrayList<Long> values = new ArrayList<Long>();
        for (String s : list) {
            for (String part : s.split(" ")) {
                double a = Double.parseDouble(part);
                values.add(Math.round(a));
            }
        }
        fileReader.close();

        //write to file
        FileWriter fileWriter = new FileWriter(fileName2);
        for (Long value : values)
            fileWriter.write( value.toString()+" ");

        fileWriter.close();
    }
}




/*
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 — 3
3.50 — 4
3.51 — 4
-3.49 — -3
-3.50 — -3
-3.51 — -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.

package com.javarush.task.task18.task1820;

* 
Округление чисел
*

public class Solution {
    public static void main(String[] args) {

    }
}
*/
