
//Jesus answered and said unto him, Because I said unto thee, I saw thee under the fig tree, believest thou?
//thou shalt see greater things than these. (John 1:50)

package com.javarush.task.task36.task3607;


import java.util.concurrent.DelayQueue;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return DelayQueue.class;
    }
}

/*
Найти класс по описанию

Описание класса:

1. Реализует интерфейс Queue.

2. Используется при работе с трэдами.

3. Из этой очереди элементы могут быть взяты только тогда, когда они заэкспарятся, их время задержки истекло.

4. Головой очереди является элемент, который заэкспарился раньше всех.





Требования:

1. Метод getExpectedClass не должен использовать метод getDeclaredClasses.

2. Метод getExpectedClass должен вернуть правильный тип.

3. Метод main должен вызывать метод getExpectedClass.

4. Метод main должен вывести полученный класс на экран.
*/
