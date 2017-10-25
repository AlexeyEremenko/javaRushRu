
//But, as it is written, "They will see, to whom no news of him came. They who haven't heard will understand." (Romans 15:21)

package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int max = Integer.MIN_VALUE;
        
        while(fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (max < data) {max = data;}
        }
        System.out.println(max);
        fileInputStream.close();
        br.close();
    }catch(IOException e) {e.printStackTrace();}
    }
}





/*
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.


package com.javarush.task.task18.task1801;

import java.io.FileInputStream;

* 
Максимальный байт
*

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/
