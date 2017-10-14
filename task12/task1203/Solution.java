package com.javarush.task.task12.task1203;

//Jesus said to him, "Someone who has bathed only needs to have his feet washed, 
//but is completely clean. You are clean, but not all of you." (John 13:10)

/* 
Кесарю — кесарево
*/

public class Solution {
    public static void main(String[] args) {
        Pet pet1 = new Cat();
        Pet cat = pet1.getChild();

        Pet pet2 = new Dog();
        Pet dog = pet2.getChild();
    }

    public static class Pet {
        public Pet getChild() {
            return new Pet();
        }
    }

    public static class Cat extends Pet {
        public Cat getChild() {
            return new Cat();
        }
    }

    public static class Dog extends Pet {
        public Dog getChild() {
            return new Dog();
        }
    }
}
