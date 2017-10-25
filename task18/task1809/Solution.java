
//Father, I desire that they also whom you have given me be with me where I am, that they may see my glory, which you have given me, for you loved me before the foundation of the world. (John 17:24)


package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileNameA = br.readLine();
        String fileNameB = br.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileNameA);
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameB);

        while (fileInputStream.available() > 0) {
            byte[] buff = new byte[fileInputStream.available()];
            byte[] reverseBuff = new byte[buff.length];

            fileInputStream.read(buff);

            for (int i = buff.length - 1; i >= 0; i--)
                reverseBuff[buff.length - i - 1] = buff[i];

            fileOutputStream.write(reverseBuff);
        }
        fileInputStream.close();
        fileOutputStream.close();
        br.close();
    }
}




/*
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.

package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {

    }
}
*/
