
//I didn't recognize him, but he who sent me to baptize in water, he said to me, 'On whomever you will see the Spirit descending, and remaining on him, the same is he who baptizes in the Holy Spirit.' (John 1:33)

package com.javarush.task.task29.task2909.car;


public class Truck extends Car {
    
    public Truck(int numberOfPassangers) {super(TRUCK, numberOfPassangers);}
}

/*
Рефакторинг (10)
Разберись с кодом в пакете car (машина).
10.1. Замена конструктора фабричным методом.
10.1.1. Объяви классы Truck (грузовик), Sedan (седан) и Cabriolet (кабриолет), унаследованные от Car.
10.1.2. Добавь в них конструкторы, принимающие int numberOfPassengers.
10.1.3. Добавь фабричный статический метод Car create(int type, int numberOfPassengers) в класс Car и реализуй его.
10.1.4. Измени область видимости конструктора класса Car.


Требования:
1. Нужно создать классы Truck (грузовик), Sedan (седан) и Cabriolet (кабриолет), унаследованные от Car.
2. Необходимо в созданные классы добавить конструкторы, принимающие int numberOfPassengers.
3. Необходимо создать фабричный статический метод Car create(int type, int numberOfPassengers) в классе Car и реализовать его.
4. Необходимо изменить область видимости конструктора класса Car с public на protected.

*/
