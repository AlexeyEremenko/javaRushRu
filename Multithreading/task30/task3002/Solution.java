
//By these three was the third part of men killed, by the fire, and by the smoke, and by the brimstone, which issued out of their mouths (Revelation 9:18)

package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int result = 0;          //напишите тут ваш код
        if (!s.startsWith("0")) return s;
        else {
            if (s.startsWith("0x")) result = Integer.parseInt(s.substring(2), 16);
            else {
                if (s.startsWith("0b")) result = Integer.parseInt(s.substring(2), 2);
                else {
                    if (s.startsWith("0")) result = Integer.parseInt(s, 8);
                }
            }
        }
        return String.valueOf(result);
    }
}

/*
Осваиваем методы класса Integer

Используя метод Integer.parseInt(String, int) реализуй логику метода convertToDecimalSystem, который должен переводить переданную строку в десятичное число и возвращать его в виде строки.





Требования:

1. В классе Solution должен существовать метод convertToDecimalSystem(String), возвращающий String.

2. Метод convertToDecimalSystem(String) должен иметь модификаторы доступа: public, static.

3. Метод convertToDecimalSystem(String) должен вызывать метод Integer.parseInt(String, int).

4. Метод convertToDecimalSystem(String) должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
