
//The soldiers twisted thorns into a crown, and put it on his head, and dressed him in a purple garment. (John 19:2)

package com.javarush.task.task20.task2010;

/* 
Как сериализовать что-то свое?
*/

import java.io.*;

public class Solution {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(String[] args) {

    }
}
/*
Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной.


Требования:
1. Класс Object должен существовать внутри класса Solution.
2. Класс Solution.Object должен быть статическим.
3. Класс Solution.Object должен быть публичным.
4. Класс Solution.Object должен поддерживать интерфейс Serializable.
5. Класс Solution.String должен поддерживать интерфейс Serializable.

package com.javarush.task.task20.task2010;

* 
Как сериализовать что-то свое?
*
public class Solution {
    public static class Object {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(String[] args) {

    }
}
*/
