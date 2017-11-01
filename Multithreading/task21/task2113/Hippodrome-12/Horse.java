
//To God the only wise, through Jesus Christ, to whom be honour and glory for ever and ever. Amen. (Romans 16:27)

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
    public void print() {}
    
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
Ипподром(12)
Осталось совсем немного — дописать класс Horse.
Каждый ход у лошади будет вызываться метод move.
Когда у лошади вызывают метод move, лошадь должна пробежать некоторую дистанцию.
Дистанция зависит от скорости лошади (speed). В самом простом варианте, выглядеть этот метод должен примерно так:
distance += speed;

Но, чтобы было интереснее, давай сделаем так, чтобы скорость все время немного менялась.
Для этого умножь speed на случайное число.
Случайное число можно получить с помощью метода Math.random().


Требования:
1. В методе move класса Horse значение поля distance должно увеличиваться на расстояние пройденное за один "ход"(значение поля speed) умноженное на случайное число от нуля до единицы полученное с помощью вызова метод Math.random().
Ипподром(11)
С классом Hippodrome почти закончили.
Добавь в конец метода main вызов run().

Подсказка:
run() — это нестатический метод, поэтому вызвать его можно только у объекта.
А где взять объект?

Подсказка 2:
game.run();

Ипподром(10)
Еще нужно написать метод print класса Hippodrome.
В нем тоже все просто: в цикле для каждой лошади вызываем ее метод print.
Ну, и еще выведи после цикла 10 пустых строк: System.out.println() — чтобы было красивее.

Ипподром(9)
Теперь вернемся к методам move и print. Начнем с move.

В методе move класса Hippodrome в цикле у каждой лошади мы вызываем метод move.

Да ты прав, его еще нет у класса Horse.

Поэтому в класс Horse надо добавить свой метод move :)

И метод print, кстати тоже.

Если я не говорю ничего насчет параметров метода, значит метод без параметров.

Делай все методы public, если явно не указано обратное.

Ипподром(8)
В методе run сделай цикл от 1 до 100. Это и будет наш забег.
В теле цикла вызываем сначала move, затем print.
Чтобы весь цикл не отработал за долю секунды — добавь в него еще Thread.sleep(200);

Ипподром(7)
Но и это еще не все — надо чтобы лошади бежали.
Добавь в класс Hippodrome методы run, move и print. Без параметров.
Метод move будет управлять движением всех лошадей.
Метод print отрисовывать их на экран.
А метод run — управлять всем этим.

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
    
    public void move() {}
    public void print() {}
    
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
*/
