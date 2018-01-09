
//These are the two olive trees, and the two candlesticks standing before the God of the earth. (Revelation 11:4)

package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}

/*
Shortener (4)

Нам потребуется несколько вспомогательных классов:

4.1. Создай класс Helper.

4.1.1. Добавь в него статический метод String generateRandomString(), который будет генерировать случайную строку. Воспользуйся для этого классами SecureRandom и BigInteger. Подсказка: гугли запрос "random string java".

4.1.2. Добавь в класс статический метод printMessage(String message). Он должен выводить переданный текст в консоль. Весь дальнейший вывод в программе должен быть реализован через этот метод!

4.2. Создай класс ExceptionHandler.

4.2.1. Добавь в него статический метод log(Exception e), который будет выводить краткое описание исключения.





Требования:

1. Метод generateRandomString класса Helper должен генерировать случайную строку используя способ описанный в условии задачи.

2. Метод printMessage класса Helper должен выводить переданный текст на экран.

3. Метод log класса ExceptionHandler должен выводить на экран краткое описание исключения.
*/
