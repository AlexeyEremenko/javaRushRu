
//And I went unto the angel, and said unto him, Give me the little book. And he said unto me, Take it, and eat it up; and it shall make thy belly bitter, but it shall be in thy mouth sweet as honey. (Revelation 10:9)

package com.javarush.task.task36.task3609;

public class SpeedometerView {
    public void printCarDetails(String brand, String model, int speed) {
        System.out.println("Car: \nBrand: " + brand + "\nModel: " + model + "\nCurrent Speed: " + speed + "\n");
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
