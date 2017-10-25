
//whenever I journey to Spain, I will come to you. For I hope to see you on my journey, and to be helped on my way there by you, if first I may enjoy your company for a while. (Romans 15:24)


package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(br.readLine());
         try {
             
           Map<Integer, Integer> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            while (fileInputStream.available() > 0) {
                int newValue = map.merge(fileInputStream.read(), 1, (o, n) -> o + n);
                if (newValue < min) {
                    min = newValue;
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == min) {
                    System.out.print(entry.getKey() + " ");
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
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.

package com.javarush.task.task18.task1804;

import java.io.FileInputStream;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/
