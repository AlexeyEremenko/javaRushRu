
//After this, Jesus, seeing that all things were now finished, that the Scripture might be fulfilled, said, "I am thirsty." (John 19:28)

package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;
    
    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    
    public void move() {
        double rnd = Math.random();
        distance += speed*rnd;
    }
    public void print() {
        String string = "";
        int t = (int)distance;
        for (int i = 0; i< t; i++) {
            string +=".";
        }
        System.out.println(string + name);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }    
    
}
/*
Ипподром(16)
Теперь уже точно все.

Добавь вызов метода printWinner в конец метода main.

Запускай и любуйся своей первой компьютерной игрой :)


Требования:
1. Метод printWinner должен быть вызван в методе main после метода run.
Ипподром(15)
Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!

Пример:
Winner is Lucky!

Ипподром(14)
Запускаем и любуемся.
У нас каждые полсекунды отображается новый кадр с ситуацией на ипподроме.
Мышкой уменьши размер консоли так, чтобы был виден только один «кадр» и на том же самом месте.

Тогда можно наблюдать забег в живую и даже покомментировать:
— Старт.
— Гомер неожиданно обходит Лаки.
— Слевин вырывается вперед.
— Вперед Лаки!
— 10 баксов на Слевина.
— Похоже Лаки сбросил жокея и расслабился.
— Гомер уверенно вырывается вперед.
— Неожиданно для всех побеждает Гомер. Вот это номер!

Ипподром(13)
Теперь вернемся к методу print класса Horse.

Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
........Sleven <- лошадь Слевин
....Lucky <- лошадь Лаки
..........Gomer <- лошадь Гомер

Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
Количество точек равно distance, округленному (в меньшую сторону) до целого числа.

Ипподром(12)
Осталось совсем немного — дописать класс Horse.
Каждый ход у лошади будет вызываться метод move.
Когда у лошади вызывают метод move, лошадь должна пробежать некоторую дистанцию.
Дистанция зависит от скорости лошади (speed). В самом простом варианте, выглядеть этот метод должен примерно так:
distance += speed;

Но, чтобы было интереснее, давай сделаем так, чтобы скорость все время немного менялась.
Для этого умножь speed на случайное число.
Случайное число можно получить с помощью метода Math.random().

Ипподром(11)
С классом Hippodrome почти закончили.
Добавь в конец метода main вызов run().

Подсказка:
run() — это нестатический метод, поэтому вызвать его можно только у объекта.
А где взять объект?

Подсказка 2:
game.run();
*/
