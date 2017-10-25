
//Therefore also I was hindered these many times from coming to you (Romans 15:22)


package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int min = Integer.MAX_VALUE;
        
        while(fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (min > data) {min = data;}
        }
        System.out.println(min);
        fileInputStream.close();
        br.close();
    }catch(IOException e) {e.printStackTrace();}
    }
}




/*
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.

*/
