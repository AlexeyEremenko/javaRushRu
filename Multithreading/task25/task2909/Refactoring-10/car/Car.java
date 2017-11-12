
//I didn't know him, but for this reason I came baptizing in water: that he would be revealed to Israel." (John 1:31)

package com.javarush.task.task29.task2909.car;

import java.util.Date;

public class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    public static Car create(int type, int numberOfPassengers) {
        Car instance;
        if (type == TRUCK) {
            instance = new Truck(numberOfPassengers);
        } else if (type == CABRIOLET) {
            instance = new Cabriolet(numberOfPassengers);
        } else {
            instance = new Sedan(numberOfPassengers);
        }
        return instance;
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public int fill(double numberOfLiters) {
        if (numberOfLiters < 0)
            return -1;
        fuel += numberOfLiters;
        return 0;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (date.before(SummerStart) || date.after(SummerEnd)) {
            consumption = length * winterFuelConsumption + winterWarmingUp;
        } else {
            consumption = length * summerFuelConsumption;
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!isDriverAvailable())
            return 0;
        if (fuel <= 0)
            return 0;

        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
            fastenDriverBelt();
        } else {
            fastenDriverBelt();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public int getMaxSpeed() {
        if (type == TRUCK)
            return 80;
        if (type == SEDAN)
            return 120;
        return 90;
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
