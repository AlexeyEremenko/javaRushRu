package com.javarush.task.task11.task1106;

//that the word of Isaiah the prophet might be fulfilled, which he spoke, "Lord, who has believed our report?
//To whom has the arm of the Lord been revealed?" (John 12:38)

/* 
Скрытный инкапсулированный кот
*/

public class Solution {
    public static void main(String[] args) {
    }

    public class Cat {
        private String name;
        private int age;
        private int weight;

        public Cat() {
        }

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }
}
