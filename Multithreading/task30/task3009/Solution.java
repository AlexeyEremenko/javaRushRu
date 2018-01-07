
//For their power is in their mouth, and in their tails: for their tails were like unto serpents, and had heads, and with them they do hurt. (Revelation 9:19)

package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("465"));
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();
        StringBuilder temp;
        try {
            int numberInDex = Integer.parseInt(number);
            for (int i = 2; i < 37; i++) {
                temp = new StringBuilder(Integer.toString(numberInDex, i));
                if (temp.toString().equals(temp.reverse().toString())) result.add(i);
            }

        } catch (NumberFormatException e) {
        }

        return result;
    }
}

/*
Палиндром?

Объяви и реализуй логику приватного статического метода Set<Integer> getRadix(String number), в котором нужно определить, в каких системах счисления (от 2 до 36 включительно) представление числа number (передается в десятичной системе счисления) является палиндромом и добавить индекс таких систем в результат.

Если переданное число некорректно - возвращай пустой HashSet.

В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы. К примеру, числу 35 в десятичной системе соответствует число "Z" в системе с основанием 36.



Метод main не принимает участие в тестировании.



P.S.: В методе getRadix перехватывай NumberFormatException. Стек-трейс выводить не нужно.





Требования:

1. Необходимо объявить приватный статический метод Set getRadix(String number).

2. Метод getRadix в случае некорректных входных данных должен возвращать пустой HashSet.

3. Методе getRadix не должен бросать NumberFormatException.

4. Метод getRadix не должен ничего выводить в консоль.

5. Метод getRadix должен возвращать множество согласно условию задачи.
*/
