
//Now when he was in Jerusalem at the passover, in the feast day, many believed in his name,
//when they saw the miracles which he did. (John 2:23)

package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object veryComplexClass = new VeryComplexClass[1][1];
        System.out.println((Integer)veryComplexClass);
    }

    public void methodThrowsNullPointerException() {
        VeryComplexClass[][] veryComplexClass = null;
        System.out.println(veryComplexClass[2][2]);
    }

    public static void main(String[] args) {

    }
}

/*
Runtime исключения (unchecked exception)

Напиши реализацию метода methodThrowsClassCastException(). Он должен всегда кидать Runtime исключение ClassCastException.



Напиши реализацию метода methodThrowsNullPointerException(). Он должен всегда кидать Runtime исключение NullPointerException.



Кинуть исключение (throw) явно нельзя.





Требования:

1. Метод methodThrowsClassCastException класса veryComplexClass не должен использовать ключевое слово throw.

2. Метод methodThrowsNullPointerException класса veryComplexClass не должен использовать ключевое слово throw.

3. Метод methodThrowsClassCastException класса veryComplexClass должен бросать исключение ClassCastException.

4. Метод methodThrowsNullPointerException класса veryComplexClass должен бросать исключение NullPointerException.
*/
