
//Behold, he cometh with clouds; and every eye shall see him, and they [also] which pierced him: and all kindreds of the earth shall wail because of him. Even so, Amen. (Revelation 1:7)

package com.javarush.task.task25.task2515;

public class SpaceShip extends BaseObject {

    private double dx = 0;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    public void move() {
        x += dx;
        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);
    }

    public void draw(Canvas canvas) {}

    public void fire() {
        Space.game.getRockets().add(new Rocket(x - 2, y));
        Space.game.getRockets().add(new Rocket(x + 2, y));
    }


    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }
}

/*
Space (13)

Теперь перейдем к методам draw, move.

В методе move() надо:

а) увеличить x на dx;

б) проверить, не вылез ли корабль за границы космоса [0, Space.game.getWidth()]. Используй метод checkBorders.

Учти, что ширина корабля равна двум его радиусам.



Метод draw я напишу сам - просто объяви пустой метод.



Еще нам понадобится метод fire(), ведь корабль умеет стрелять.

Этот метод вызывается, когда надо произвести выстрел.



В этом методе надо:

а) создать две ракеты;

б) установить им координаты левого края корабля и правого края корабля (пушки находятся на расстоянии 2 от центра корабля);

в) добавить эти ракеты в список ракет объекта game.



Его можно получить так:

Space.game.getRockets()





Требования:

1. В классе SpaceShip напиши метод move(), который увеличивает поле x на значение dx и проверяет, не вылез ли корабль за границы космоса.

2. В классе SpaceShip добавь пустой метод draw(Canvas canvas).

3. В классе SpaceShip напиши метод fire(), который создает две ракеты с координатами левого и правого края корабля и добавляет их в поле rockets у объекта game.
*/
