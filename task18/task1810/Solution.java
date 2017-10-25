
//Righteous Father, the world hasn't known you, but I knew you; and these knew that you sent me (John 17:25)


package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(br.readLine());

        while (fileInputStream.available() > 999) {
            fileInputStream.close();
            fileInputStream = new FileInputStream(br.readLine());
        }

        br.close();
        fileInputStream.close();

        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}







/*
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Требования:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.

package com.javarush.task.task18.task1810;

* 
DownloadException
*

public class Solution {
    public static void main(String[] args) throws DownloadException {

    }

    public static class DownloadException extends Exception {

    }
}

*/
