
//I thank my God always on your behalf, for the grace of God which is given you by Jesus Christ (1Cor 1:4)

package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        int firstSpaceIndex = string.indexOf(" ") + 1;
        char[] chars = string.toCharArray();
        int countSpace = 0;
        int lastSpaceIndex = 0; 
        for (int i = 0; i < string.length(); i++)
        {
            if (chars[i] == ' ')
            {
                countSpace++;
                if (countSpace == 4)
                {
                    lastSpaceIndex = string.length();
                } else if (countSpace == 5)
                {
                    lastSpaceIndex = i;
                    break;
                }
            }
        }
        if (countSpace < 4)
        {
            throw new TooShortStringException();
        }
        return string.substring(firstSpaceIndex, lastSpaceIndex);
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
/*
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
«JavaRush — лучший сервис обучения Java.»

Результат:
«— лучший сервис обучения»

На некорректные данные бросить исключение TooShortStringException (сделать исключением).


Требования:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 4 пробелов должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.

package com.javarush.task.task22.task2202;

* 
Найти подстроку
*
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        return null;
    }

    public static class TooShortStringException {
    }
}
*/
