
//He who doesn't love me doesn't keep my words. The word which you hear isn't mine, but the Father's who sent me. (John 14:24)


package com.javarush.task.task14.task1414;

import java.io.*;
import java.util.*;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//ввести с консоли несколько ключей (строк), пункт 7
        
        while (true) {
            String key = br.readLine();
            if ("soapOpera".equals(key)) {
            Movie movie = MovieFactory.getMovie(key);
            System.out.println(movie.getClass().getSimpleName());
            continue;}
            
            else if ("cartoon".equals(key)) {
            Movie movie = MovieFactory.getMovie(key);
            System.out.println(movie.getClass().getSimpleName());
            continue;}
            
            else if ("thriller".equals(key)) {
            Movie movie = MovieFactory.getMovie(key);
            System.out.println(movie.getClass().getSimpleName());
            continue;}
            
            else {Movie movie = MovieFactory.getMovie(key); break;}
        }
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }else if ("thriller".equals(key)) {
                movie = new Thriller();
            }else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {//Напишите тут ваши классы, пункт 3
    }
    
    static class Thriller extends Movie {
    }
}





/*
MovieFactory
Расширение функционала по аналогии, чтение с консоли:
1. Разобраться, что программа умеет делать.
2. Все классы должны быть внутри класса Solution.
3. Добавить классы Cartoon, Thriller.
4. Разобраться, как мы получаем объект класса SoapOpera по ключу «soapOpera«.

Аналогично получению объекта SoapOpera сделать:
5. Добавить в MovieFactory.getMovie получение объекта Cartoon для ключа «cartoon«.
6. Добавить в MovieFactory.getMovie получение объекта Thriller для ключа «thriller«.
7. Считать с консоли несколько ключей (строк).
7.1. Ввод заканчивается, как только вводится строка не совпадающая с одной из: «cartoon«, «thriller«, «soapOpera«.
8. Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1. Получить объект используя MovieFactory.getMovie и присвоить его переменной movie.
8.2. Вывести на экран movie.getClass().getSimpleName().


Требования:
1. Классы Cartoon и Thriller должны быть статическими и существовать внутри класса Solution.
2. Метод MovieFactory.getMovie должен возвращать объект типа Cartoon в случае передачи ему строки "cartoon" в качестве параметра.
3. Метод MovieFactory.getMovie должен возвращать объект типа Thriller в случае передачи ему строки "thriller" в качестве параметра.
4. Метод main должен считывать строки с клавиатуры.
5. Метод main должен прекращать считывать строки с клавиатуры в случае, если была введена некорректная строка(не "cartoon", не "thriller" или не "soapOpera").
6. Для каждой введенной строки необходимо вызвать метод MovieFactory.getMovie.
7. Для всех введенных корректных строк необходимо вывести на экран простые имена(movie.getClass().getSimpleName()) типов объектов возвращаемых методом MovieFactory.getMovie.


package com.javarush.task.task14.task1414;

// * 
// MovieFactory
// *

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7

  
// 8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
// 8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
// 8.2 вывести на экран movie.getClass().getSimpleName()
        

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3
}
*/
