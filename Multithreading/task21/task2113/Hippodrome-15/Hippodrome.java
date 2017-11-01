
//Grace be unto you, and peace, from God our Father, and from the Lord Jesus Christ. (1Cor 1:3)

package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    
    private List<Horse> horses;
    public static Hippodrome game;
    
    public Hippodrome(List<Horse> list) {
        this.horses = list;
    }
    
    public List<Horse> getHorses() {
        return this.horses;
    }
    
    public void run() {
        for (int i = 0; i < 100; i++) {
            game.move();
            game.print();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e) {}
        }
    }
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    Horse winner = new Horse("", 0.0, 0.0);
    public Horse getWinner() {
        
        double winnerDistance = 0.0;
        for (Horse horse : horses) {if (horse.getDistance() > winnerDistance) {winnerDistance = horse.getDistance(); winner = horse;};}
        return winner;
    }
    
    public void printWinner() {
        System.out.print("Winner is " +  getWinner().getName() + "!");
    }
    
    public static void main(String[] args) {
        
        List<Horse> horses = new ArrayList<Horse>();
        
        Horse horseRed = new Horse("red", 3, 0);
        Horse horseBlack = new Horse("black", 3, 0);
        Horse horseWhite = new Horse("White", 3, 0);
        horses.add(horseRed);
        horses.add(horseBlack);
        horses.add(horseWhite);
        game = new Hippodrome(horses);
        game.run();
    }
}
/*
Ипподром(15)
Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!

Пример:
Winner is Lucky!


Требования:
1. В классе Hippodrome должен быть создан метод getWinner без параметров.
2. В классе Hippodrome должен быть создан метод printWinner без параметров.
3. Метод getWinner должен возвращать лошадь пробежавшую наибольшую дистанцию.
4. Метод printWinner должен выводить на экран имя победителя на экран в формате заданном в условии задачи.

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

Ипподром(10)
Еще нужно написать метод print класса Hippodrome.
В нем тоже все просто: в цикле для каждой лошади вызываем ее метод print.
Ну, и еще выведи после цикла 10 пустых строк: System.out.println() — чтобы было красивее.

package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    
    private List<Horse> horses;
    public static Hippodrome game;
    
    public Hippodrome(List<Horse> list) {
        this.horses = list;
    }
    
    public List<Horse> getHorses() {
        return this.horses;
    }
    
    public void run() {
        for (int i = 0; i < 100; i++) {
            game.move();
            game.print();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e) {}
        }
    }
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        List<Horse> horses = new ArrayList<Horse>();
        
        Horse horseRed = new Horse("red", 3, 0);
        Horse horseBlack = new Horse("black", 3, 0);
        Horse horseWhite = new Horse("White", 3, 0);
        horses.add(horseRed);
        horses.add(horseBlack);
        horses.add(horseWhite);
        game = new Hippodrome(horses);
        game.run();
    }
}
*/
