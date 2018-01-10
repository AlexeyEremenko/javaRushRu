
//And he saith unto them, Draw out now, and bear unto the governor of the feast. And they bare it. (John 2:8)

package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}

/*
Decorator

Создай класс RedShapeDecorator в пакете Decorators. Он должен расширять функциональность объектов типа Shape не меняя их структуру.



Я уже создал абстрактный класс ShapeDecorator, поэтому:

1) Класс RedShapeDecorator сделай наследником класса ShapeDecorator.

2) Реализуй приватный метод setBorderColor с одним параметром типа Shape.

Он должен выводить на экран фразу "Setting border color for XXX to red.", где XXX - имя конкретного декорируемого класса (можешь воспользоваться методами getClass().getSimpleName() вызванными на объекте полученном в качестве параметра).

3) Переопредели метод draw, в нем сначала измени цвет отображаемого объекта с помощью метода setBorderColor, а потом нарисуй его.





Требования:

1. Класс RedShapeDecorator должен быть потомком класса ShapeDecorator.

2. Метод setBorderColor должен выводить на экран фразу соответствующую условию задачи.

3. Метод setBorderColor должен быть приватным.

4. В методе draw класса RedShapeDecorator должен быть изменен цвет декорируемого объекта и вызван его метод draw.

5. Публичный конструктор класса RedShapeDecorator должен принимать один параметр типа Shape.
*/
