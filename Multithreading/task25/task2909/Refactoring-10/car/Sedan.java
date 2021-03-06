
//John testified, saying, "I have seen the Spirit descending like a dove out of heaven, and it remained on him. (John 1:32)

package com.javarush.task.task29.task2909.car;


public class Sedan extends Car {
    
    public Sedan(int numberOfPassangers) {
        super(SEDAN, numberOfPassangers);
    }
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
