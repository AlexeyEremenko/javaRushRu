
//And the woman fled into the wilderness, where she hath a place prepared of God, that they should feed her there a thousand two hundred and threescore days. (Revelation 12:6)

package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");
        boolean[] isOdd = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            isOdd[s.charAt(i)] = !isOdd[s.charAt(i)];
        }

        int numberOdds = 0;

        for (int i = 0; i < isOdd.length; i++) {
            if (isOdd[i]) {
                numberOdds++;
            }
            if (numberOdds > 1) {
                return false;
            }
        }
        return true;
    }
}

/*
Возможен ли палиндром?

Реализуй метод isPalindromePermutation(String s) который будет возвращать true, если из всех символов строки s можно составить палиндром. Иначе - false.



Символы в анализируемой строке ограничены кодировкой ASCII.

Регистр букв не учитывается.





Требования:

1. Метод isPalindromePermutation должен возвращать true, если выполнив перестановку символов входящей строки можно получить палиндром.

2. Метод isPalindromePermutation должен возвращать false, если выполнив перестановку символов входящей строки получить палиндром невозможно.

3. Метод isPalindromePermutation должен быть публичным.

4. Метод isPalindromePermutation должен быть статическим.
*/
