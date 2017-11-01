
//Paul, called to be an apostle of Jesus Christ through the will of God, and Sosthenes our brother (1Cor 1:1)

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
Ипподром(13)
Теперь вернемся к методу print класса Horse.

Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
........Sleven <- лошадь Слевин
....Lucky <- лошадь Лаки
..........Gomer <- лошадь Гомер

Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
Количество точек равно distance, округленному (в меньшую сторону) до целого числа.


Требования:
1. Метод print должен выводить на экран строку состоящую из точек и имени лошади. Количество точек равно целой части distance.
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
*/
