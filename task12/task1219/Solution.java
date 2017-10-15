package com.javarush.task.task12.task1219;

//Jesus therefore answered, "It is he to whom I will give this piece of bread when I have dipped it." 
//So when he had dipped the piece of bread, he gave it to Judas, the son of Simon Iscariot. (John 13:26)

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }


    public class Human implements Run, Swim {
        @Override
        public void run() {}
        @Override
        public void swim() {}
    }

    public class Duck implements Fly, Swim, Run {
        @Override
        public void fly() {}
        @Override
        public void swim() {}
        @Override
        public void run() {}
    }

    public class Penguin implements Swim, Run {
        @Override
        public void swim() {}
        @Override
        public void run() {}
    }

    public class Airplane implements Fly, Run {
        @Override
        public void fly() {}
        @Override
        public void run() {}
    }
}



/*
Создаем человека
Есть public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавь эти интерфейсы классам Human(человек), Duck(утка), Penguin(пингвин), Airplane(самолет).


Требования:
1. Класс Solution должен содержать интерфейс Fly с одним методом fly().
2. Класс Solution должен содержать интерфейс Run с одним методом run().
3. Класс Solution должен содержать интерфейс Swim с одним методом swim().
4. Человек должен уметь бегать и плавать.
5. Утка должна уметь летать, плавать и бегать.
6. Пингвин должен уметь плавать и бегать.
7. Самолет должен уметь летать и ездить.

package com.javarush.task.task12.task1219;
 
Создаем человека

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }


    public class Human {

    }

    public class Duck {

    }

    public class Penguin {

    }

    public class Airplane {

    }
}
*/
