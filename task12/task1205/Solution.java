package com.javarush.task.task12.task1205;

//So when he had washed their feet, put his outer garment back on, 
//and sat down again, he said to them, "Do you know what I have done to you? (John 13:12)

/* 
Определимся с животным
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        if (o instanceof Cow) {return "Корова";}//Напишите тут ваше решение
        else if (o instanceof Whale) {return "Кит";}
        else if (o instanceof Dog) {return "Собака";}
        else return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
