package com.javarush.task.task12.task1214;

//When Jesus had said this, he was troubled in spirit, and testified, 
//"Most certainly I tell you that one of you will betray me." (John 13:21)

/* 
Корова — тоже животное
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow extends Animal {
        public String getName() {
            return "God is Love";
        }
    }

}




/*
Корова — тоже животное
Унаследуй класс Cow от Animal.
Реализуй все недостающие методы в классе Cow.


Требования:
1. Класс Animal должен быть абстрактным.
2. Класс Cow не должен быть абстрактным.
3. Класс Cow должен наследоваться от класса Animal.
4. Класс Cow должен реализовать абстрактный метод из класса Animal.
5. Метод getName() класса Cow должен возвращать любое имя коровы.


package com.javarush.task.task12.task1214;

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow {
    }

}

*/
