
//But the Counselor, the Holy Spirit, whom the Father will send in my name, 
//he will teach you all things, and will remind you of all that I said to you. (John 14:26)

package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.File;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {                                //java.lang.ArithmeticException: / by zero
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try{ //напишите тут ваш код
            int[] array = new int[7];
            System.out.println(array[7]);     //java.lang.ArrayIndexOutOfBoundsException: 7
        } catch (Exception f) {
            exceptions.add(f);
        }
        
        try{
            String string = "string";
            Integer.parseInt(string);         //java.lang.NumberFormatException: For input string: "string"
        } catch (Exception g) {
            exceptions.add(g);   
        }
        
        try{
            ArrayList list = new ArrayList();
            list.get(7);                      //java.lang.IndexOutOfBoundsException: Index: 7, Size: 0
        } catch (Exception h) {
            exceptions.add(h);   
        }
        
        try{
            Object object = new Character('#');
            System.out.println((Byte)object); //java.lang.ClassCastException: java.lang.Character cannot be cast to java.lang.Byte
        } catch (Exception i) {
            exceptions.add(i);   
        }
        
        try{
            char[] array = new char[-7];      //java.lang.NegativeArraySizeException
        } catch (Exception j) {
            exceptions.add(j);   
        }
        
        try{
            String string = "string";
            char c = string.charAt(7);        //java.lang.StringIndexOutOfBoundsException: String index out of range: 7
        } catch (Exception k) {
            exceptions.add(k);   
        }
        
        try{
            String fileName = "";             //java.io.FileNotFoundException:  (No such file or directory)
            FileInputStream fis = new FileInputStream(fileName);
        } catch (Exception l) {
            exceptions.add(l);   
        }
        
        try{
            Class<?> cls = Class.forName(""); //java.lang.ClassNotFoundException:
        } catch (Exception m) {
            exceptions.add(m);   
        }
        
        try{
            File.createTempFile("prefix", "");//java.lang.SecurityException: Unable to create temporary file
        } catch (Exception n) {
            exceptions.add(n);   
        }
    }
}






/*
java.lang.ArithmeticException: / by zero
java.lang.ArrayIndexOutOfBoundsException: 7
java.lang.NumberFormatException: For input string: "string"
java.lang.IndexOutOfBoundsException: Index: 7, Size: 0
java.lang.ClassCastException: java.lang.Character cannot be cast to java.lang.Byte
java.lang.NegativeArraySizeException
java.lang.StringIndexOutOfBoundsException: String index out of range: 7
java.io.FileNotFoundException:  (No such file or directory)
java.lang.ClassNotFoundException: 
java.lang.SecurityException: Unable to create temporary file


Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.


*/
