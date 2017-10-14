package com.javarush.task.task12.task1201;

//Peter said to him, "You will never wash my feet!" Jesus answered him, "If I don't wash you, you have no part with me." (John 13:8)

/* 
Киты и коровы
*/

public class Solution {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
        public String getName() {
            return "Я не корова, Я - кит.";
        }

    }
}
