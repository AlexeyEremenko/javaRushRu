
//but now, no longer having any place in these regions, and having these many years a longing to come to you (Romans 15:23)


package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(br.readLine());
         try {
             
            int[] count = new int[256];
            int max = Integer.MIN_VALUE;

            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                if (max < ++count[data]) {
                    max = count[data];
                }
            }

            for (int i = count.length - 1; i >= 0; i--) {
                if (count[i] == max) {
                    System.out.print(i + " ");
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            fileInputStream.close();
            br.close();
        }catch(IOException e) {e.printStackTrace();}
        
    }
}









/*
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.


package com.javarush.task.task18.task1803;

import java.io.FileInputStream;

* 
Самые частые байты
*

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}

*/
