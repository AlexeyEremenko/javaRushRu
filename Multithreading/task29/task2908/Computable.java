
//But this happened so that the word may be fulfilled which was written in their law, 'They hated me without a cause.' (John 15:25)

package com.javarush.task.task29.task2908;

/* Argument and Value are generic types*/
public interface Computable<Argument, Value> {
    Value compute(Argument argument) throws InterruptedException;
}

/*
Кеширование

В CacheComputeManager реализуй логику пустого метода.

Догадайся, что он должен делать по названию метода и по логике класса.





Требования:

1. Метод createFutureTaskForNewArgumentThatHaveToComputeValue должен создавать и возвращать объект типа FutureTask.

2. В методе createFutureTaskForNewArgumentThatHaveToComputeValue должен создаваться объект анонимного класса, реализующего интерфейс Callable.

3. Внутри метода createFutureTaskForNewArgumentThatHaveToComputeValue должна встречаться строка "return computable.compute(arg);".

4. Программа должна выводить текст указанный в комментариях в классе Solution.
*/
