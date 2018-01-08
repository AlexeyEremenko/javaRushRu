
//And I went unto the angel, and said unto him, Give me the little book. And he said unto me, Take it, and eat it up; and it shall make thy belly bitter, but it shall be in thy mouth sweet as honey. (Revelation 10:9)

package com.javarush.task.task36.task3609;

public class CarModel {
    private String brand;
    private String model;
    private int speed;
    private int maxSpeed;



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

/*
Рефакторинг MVC

Перемести некоторые методы в нужные классы, что бы получить паттерн MVC. Если необходимо - внеси изменения в метод main, которые отражают внесенные тобой изменения. Поведение программы при этом не должно измениться.

НЕ изменяй названия классов, методов и полей.





Требования:

1. Вывод программы должен остаться без изменений.

2. Необходимо переместить метод void speedUp(int) из класса CarModel в класс CarController.

3. Необходимо переместить метод void speedDown(int) из класса CarModel в класс CarController.

4. В методе main класса Solution метод speedUp необходимо вызывать у контроллера, а не у модели.

5. В методе main класса Solution метод speedDown необходимо вызывать у контроллера, а не у модели.
*/
