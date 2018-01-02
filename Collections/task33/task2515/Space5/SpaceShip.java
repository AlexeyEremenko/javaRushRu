
//These things I have spoken unto you, that in me ye might have peace. In the world ye shall have tribulation: 
//but be of good cheer; I have overcome the world. (John 16:33)

package com.javarush.task.task25.task2515;

public class SpaceShip extends BaseObject {
    public SpaceShip(double x, double y, double radius) {
        super(x, y, radius);
    }
}

/*
Space (5)

Теперь перейдем к классу BaseObject.

Я хочу сделать несколько предложений.



Во-первых. Для простоты, считать все объекты у нас в космосе круглыми.

Нет, отрисовывать их мы будем фигурными, как и раньше.

А вот при расчетах их взаимодействия исходить из того, что они круглые.

Так - гораздо проще.



Во-вторых. Пусть координаты объектов и радиус будут вещественными числами.

Это придаст плавность движениям и точность всем вычислениям.

А при отрисовке мы будем их округлять.



Надо:

а) Добавь в класс BaseObject переменные x (double), y (double), radius (double), геттеры и сеттеры для них.

б) Добавить логическую переменную isAlive (жив объект или уже нет).

в) Добавить геттер (isAlive()-метод для isAlive-переменной).

г) Добавить конструктор BaseObject(double x, double y, double radius).

д) Проследить, чтобы в конструкторе isAlive устанавливался в true (мертворожденные нам ни к чему).

е) Надо пройтись по всем классам-наследникам и поправить у них конструкторы.

Если вы пользуетесь Intellij IDEA - Alt+Insert вам в помощь.





Требования:

1. В классе BaseObject создай поле x (double). Добавь для него getter и setter.

2. В классе BaseObject создай поле y (double). Добавь для него getter и setter.

3. В классе BaseObject создай поле radius (double). Добавь для него getter и setter.

4. В классе BaseObject создай поле isAlive (boolean). Добавь для него getter.

5. В классе BaseObject создай конструктор BaseObject(double x, double y, double radius). Поле isAlive должно устанавливаться в true.

6. Создай аналогичные конструкторы во всех классах, которые наследуются от BaseObject.
*/
