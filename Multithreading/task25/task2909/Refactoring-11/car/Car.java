
//Again, the next day, John was standing with two of his disciples (John 1:35)

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

    public void fill(double numberOfLiters) {
        if (numberOfLiters < 0)
            throw new RuntimeException();
        fuel += numberOfLiters;
    }
    
    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.before(summerStart) || date.after(summerEnd)) {return false;}
        return true;
    }
    
    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
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
Рефакторинг (11)
11.1. Замена кода ошибки исключением. Перепиши метод заправиться fill(double
numberOfLiters), чтобы он в случае ошибки кидал исключение Exception.
11.2. Разбиение условного оператора.
11.2.1. Добавь и реализуй метод в классе Car, определяющий относится ли переданная дата к
лету: boolean isSummer(Date date , Date summerStart, Date summerEnd).
11.2.2. Добавь и реализуй метод, рассчитывающий расход топлива зимой: double
getWinterConsumption(int length).
11.2.3. Добавь и реализуй метод, рассчитывающий расход топлива летом: double
getSummerConsumption(int length).
11.2.4. Перепиши метод getTripConsumption(), используя новые методы.


Требования:
1. Необходимо изменить метод fill(double numberOfLiters) класса Car, чтобы он в случае ошибки бросал исключение Exception.
2. Необходимо добавить в класс Car и реализовать публичный метод boolean isSummer(Date date , Date summerStart, Date summerEnd).
3. Необходимо добавить в класс Car и реализовать публичный метод double getWinterConsumption(int length).
4. Необходимо добавить в класс Car и реализовать публичный метод double getSummerConsumption(int length).
5. Необходимо изменить метод getTripConsumption(), используя методы: isSummer, getWinterConsumption, getSummerConsumption.
*/
