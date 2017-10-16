package com.javarush.task.task13.task1318;

//Let us walk properly, as in the day; not in reveling and drunkenness, not in sexual promiscuity and lustful acts, 
//and not in strife and jealousy. (Romans 13:13)
//Let us walk honestly, as in the day; not in rioting and drunkenness, not in chambering and wantonness, not in strife and envying.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// напишите тут ваш код
        String fileName = br.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        try{
            while (fileInputStream.available()>0) {
                System.out.print((char)fileInputStream.read());
            }
        }catch (Exception e) {System.out.println(e);}
        fileInputStream.close();
        br.close();
    }
}



/*
Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.

package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

* 
Чтение файла
*

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
    }
}
*/
