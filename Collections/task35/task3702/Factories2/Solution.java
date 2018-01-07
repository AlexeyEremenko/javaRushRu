
//Saying to the sixth angel which had the trumpet, Loose the four angels which are bound in the great river Euphrates. (Revelation 9:14)

package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.male.MaleFactory;

public class Solution {
    public static void main(String[] args) {
        MaleFactory maleFactory = new MaleFactory();

        System.out.println(maleFactory.getPerson(99));
        System.out.println(maleFactory.getPerson(4));
        System.out.println(maleFactory.getPerson(15));
    }
}

/*
Фабрики (2)

1. Создай публичный класс MaleFactory в пакете male с публичным методом getPerson, который принимает один параметр int age (возраст) и возвращает нужный объект одного из классов, реализующих интерфейс Human.



2. Логика метода getPerson: используя константу MAX_AGE определи, какой класс соответствует переданному возрасту.

Например, age=4 соответствует мальчику (KidBoy), age=15 - подростку (TeenBoy), остальной возраст - взрослому мужчине.



3. В методе main класса Solution создай фабрику и вызови у нее метод getPerson три раза с такими параметрами: 99, 4, 15.



Выведи результат в консоль.

Вывод должен быть следующий:

Man{}

KidBoy{}

TeenBoy{}



Молодец, Фабрика готова! Это паттерн Factory Method.





Требования:

1. Вывод на экран должен соответствовать условию задачи.

2. В методе main класса Solution у MaleFactory должен быть вызван трижды метод getPerson с параметрами 99, 4, 15.

3. Для возрастов больше 19 лет метод getPerson должен возвращать объект типа Man.

4. Для возрастов больше 12 лет, но меньше 20, метод getPerson должен возвращать объект типа TeenBoy.

5. Для возрастов меньше 13 лет, метод getPerson должен возвращать объект типа KidBoy.
*/
