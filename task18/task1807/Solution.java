
//The glory which you have given me, I have given to them; that they may be one, even as we are one; (John 17:22)


package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String fileName = scanner.nextLine();
        int counter = 0;
        
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            
            while (fileInputStream.available() > 0) {
                char chr = (char)fileInputStream.read();
                if (chr == ',') {counter ++;}
            }
            fileInputStream.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found1");
        } catch (IOException e) {
            System.out.println("File " + fileName + " can't read");
        }

        System.out.println(counter);
    }
}





/*
Подсчет запятых
С консоли считать имя файла.
Посчитать в файле количество символов ‘,‘, количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ‘,‘.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.


package com.javarush.task.task18.task1807;

* 
Подсчет запятых
*

public class Solution {
    public static void main(String[] args) {
    }
}


*/
