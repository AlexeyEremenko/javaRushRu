package com.javarush.task.task12.task1213;

//Verily, verily, I say unto you, He that receiveth whomsoever I send receiveth me; 
//and he that receiveth me receiveth him that sent me.(John 13:20)

/* 
«Исправь код», часть 2
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }

}



/*
«Исправь код», часть 2
Исправь код, чтобы программа компилировалась.


Требования:
1. Класс Pet должен быть статическим.
2. Класс Pet должен иметь два метода.
3. Метод getChild() должен быть абстрактным.
4. Класс Pet должен быть объявлен с модификатором, который запрещает создавать конкретные объекты этого класса.

package com.javarush.task.task12.task1213;

public class Solution {
    public static void main(String[] args) {

    }

    public static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public Pet getChild();
    }

}
*/
