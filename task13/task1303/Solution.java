package com.javarush.task.task13.task1303;

//Thomas said to him, "Lord, we don't know where you are going. How can we know the way?" (John 14:5)

/* 
Пиво с колой не мешать
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        print(new Beer());
        print(new Cola());
    }

    private static void print(Drink drink) {
        System.out.println(drink.getClass().getSimpleName());
    }

    public interface Drink {
        boolean isAlcoholic();
    }

    public static class Beer implements Drink {
        public boolean isAlcoholic() {return true;}
    }

    public static class Cola implements Drink {
        public boolean isAlcoholic() {return false;}
    }
}




/*
Пиво с колой не мешать
Реализуй интерфейс Drink в классах Beer и Cola.


Требования:
1. Класс Beer должен реализовывать(implements) интерфейс Drink.
2. Класс Cola должен реализовывать(implements) интерфейс Drink.
3. В классе Beer должны быть реализованы все методы интерфейса Drink.
4. В классе Cola должны быть реализованы все методы интерфейса Drink.

package com.javarush.task.task13.task1303;

/* 
Пиво с колой не мешать
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        print(new Beer());
        print(new Cola());
    }

    private static void print(Drink drink) {
        System.out.println(drink.getClass().getSimpleName());
    }

    public interface Drink {
        boolean isAlcoholic();
    }

    public static class Beer {
    }

    public static class Cola {
    }
}
*/
