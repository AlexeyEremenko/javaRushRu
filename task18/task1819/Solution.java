
//Jesus answered, "I told you that I am he. If therefore you seek me, let these go their way," (John 18:8)


package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    static final int BUF_SIZE = 1024; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        fileToMem (mem, fileName2);
        fileToMem (mem, fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        mem.writeTo(fileOutputStream);
        fileOutputStream.close();
    }

    public static void fileToMem(ByteArrayOutputStream mem, String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int readedByte = 0;
        while (fileInputStream.available() > 0) {
            byte[] buf = new byte[Solution.BUF_SIZE];
            readedByte = fileInputStream.read(buf);
            mem.write(buf, 0, readedByte);
        }
        fileInputStream.close();
    }
}




/*
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.

package com.javarush.task.task18.task1819;

* 
Объединение файлов
*

public class Solution {
    public static void main(String[] args) {

    }
}
*/
