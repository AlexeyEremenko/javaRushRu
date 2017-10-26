
//Now it was Caiaphas who advised the Jews that it was expedient that one man should perish for the people (John 18:14)

package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> parts = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        String nextFileName = null;
        
        while (true) {
            if ("end".equals(nextFileName = scanner.nextLine())) break;
            else parts.add(nextFileName);
        }
        scanner.close();
        
        Collections.sort(parts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        
        String outputFileName = parts.get(0).split(".part")[0];
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        
        for (String partsFileNames : parts) {
            fileInputStream = new FileInputStream(partsFileNames);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }
        fileOutputStream.close();
        System.out.println("Объединение файлов выполнено!");
    }
}





/*
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.

package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

* 
Собираем файл
*

public class Solution {
    public static void main(String[] args) {
    }
}




*/
