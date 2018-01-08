
//And I went unto the angel, and said unto him, Give me the little book. And he said unto me, Take it, and eat it up; and it shall make thy belly bitter, but it shall be in thy mouth sweet as honey. (Revelation 10:9)

package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public void speedUp(int seconds) {
        if (model.getSpeed() < model.getMaxSpeed()) {
            model.setSpeed((int) (model.getSpeed() + (3.5 * seconds)));
        }
        if (model.getSpeed() > model.getMaxSpeed()) {
            model.setSpeed(model.getMaxSpeed());
        }
    }

    public void speedDown(int seconds) {
        if (model.getSpeed() > 0) {
            model.setSpeed(model.getSpeed() - (12 * seconds));
        }
        if (model.getSpeed() < 0) {
            model.setSpeed(0);
        }
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
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
