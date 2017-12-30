
//His disciples said unto him, Lo, now speakest thou plainly, and speakest no proverb. (John 16:29)

package com.javarush.task.task28.task2813;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() {

        try {
            return factorial(number);
        } catch (InterruptedException e) {e. printStackTrace();}
        return 0L;
    }

    public long factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        long result = 1;
        while (number > 1) {
            Thread.sleep(1);
            result = result * number;
            number--;
        }
        return result;
    }
}


/*
FutureTask

Класс FactorialCalculator предназначен для вычисления факториала числа переданного в его конструктор в качестве параметра. К сожалению, он реализован некорректно и тебе необходимо это исправить.



Внимательно разбери метод main класса Solution.





Требования:

1. Класс FactorialCalculator должен поддерживать интерфейс Callable.

2. Метод call класса FactorialCalculator должен возвращать результат выполнения метода factorial.

3. Метод call класса FactorialCalculator должен быть публичным.

4. Поле number класса FactorialCalculator должно быть приватным.
*/
