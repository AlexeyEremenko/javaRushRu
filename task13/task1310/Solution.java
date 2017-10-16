package com.javarush.task.task13.task1310;

//Verily, verily, I say unto you, He that believeth on me, the works that I do shall he do also;
//and greater works than these shall he do; because I go unto my Father. (John 14:12)

/* 
Это кто там такой умный?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Person {
        void use(Person person);

        void startToWork();
    }

    interface Workable {
        boolean wantsToGetExtraWork();
    }

    interface Secretary extends Person {
    }

    interface Boss extends Workable, Person {
    }

    class CleverMan implements Boss {
        public void use(Person person) {
            person.startToWork();
        }

        public void startToWork() {
        }

        public boolean wantsToGetExtraWork() {
            return true;
        }
    }

    class SmartGirl implements Secretary {
        public void use(Person person) {
        }

        public void startToWork() {
        }
    }
}




/*
Это кто там такой умный?
1. Добавь интерфейсы Secretary и Boss к классам CleverMan и SmartGirl. По одному на каждый. Подумай, кому какой.
2. Унаследуй интерфейсы Secretary и Boss от интерфейсов Person и Workable так,
чтобы все методы у классов CleverMan и SmartGirl оказались объявленными в каком-то интерфейсе.


Требования:
1. Класс CleverMan должен реализовывать подходящий ему интерфейс(Secretary или Boss).
2. Класс SmartGirl должен реализовывать подходящий ему интерфейс(Secretary или Boss).
3. Секретарь(Secretary) является человеком(Person).
4. Начальник(Boss) является человеком(Person), а также любит много работать(Workable).

package com.javarush.task.task13.task1310;

/* 
Это кто там такой умный?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Person {
        void use(Person person);

        void startToWork();
    }

    interface Workable {
        boolean wantsToGetExtraWork();
    }

    interface Secretary {
    }

    interface Boss {
    }

    class CleverMan {
        public void use(Person person) {
            person.startToWork();
        }

        public void startToWork() {
        }

        public boolean wantsToGetExtraWork() {
            return true;
        }
    }

    class SmartGirl {
        public void use(Person person) {
        }

        public void startToWork() {
        }
    }
}
*/
