
//And the God of peace will quickly crush Satan under your feet. The grace of our Lord Jesus Christ be with you. (Romans 16:20)

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
    
    public void run() {}
    public void move() {}
    public void print() {}
    public static void main(String[] args) {
        
        List<Horse> horses = new ArrayList<Horse>();
        
        Horse horseRed = new Horse("red", 3, 0);
        Horse horseBlack = new Horse("black", 3, 0);
        Horse horseWhite = new Horse("White", 3, 0);
        horses.add(horseRed);
        horses.add(horseBlack);
        horses.add(horseWhite);
        game = new Hippodrome(horses);
    }
}
/*
Ипподром(7)
Но и это еще не все — надо чтобы лошади бежали.
Добавь в класс Hippodrome методы run, move и print. Без параметров.
Метод move будет управлять движением всех лошадей.
Метод print отрисовывать их на экран.
А метод run — управлять всем этим.


Требования:
1. В классе Hippodrome должен быть создан метод run без параметров.
2. В классе Hippodrome должен быть создан метод move без параметров.
3. В классе Hippodrome должен быть создан метод print без параметров.

Ипподром(6)
Теперь перейдем к классу Hippodrome и методу main.
Нам нужно создать объект типа Hippodrome и добавить ему несколько лошадей.

Для начала, в классе Hippodrome:
Создай статическое поле game типа Hippodrome.

В методе main требуется:
а) Создать объект типа Hippodrome и сохранить его в поле game.
б) Создать три объекта «лошадь«. Имена придумай сам. Начальные скорость у всех лошадей — 3, дистанция — 0.
в) Добавить созданных лошадей в список лошадей ипподрома (horses). Получить список лошадей ипподрома можно с помощью метода getHorses.

Ипподром(5)
Закончим написание класса лошадь (Horse).
Добавь конструктор с параметрами (name, speed, distance).
Добавь getter’ы и setter’ы для всех полей класса Horse.
Делай все методы public, если явно не указано обратное.

Ипподром(4)
Теперь вернемся к лошадям. У каждой лошади на скачках должны быть известны имя (name) и скорость (speed).
Наши лошади будут бежать просто определенное время (100 секунд/»шагов»).
Будем определять победителя, как лошадь, пробежавшую наибольшую дистанцию.
Поэтому нам понадобится хранить еще и расстояние (distance), которое лошадь уже пробежала.
Добавь в класс Horse переменные name (String), speed (double), distance (double).

Ипподром(3)
Несмотря на то что мы объявили переменную horses, сам список еще не создан (если ты конечно не успел опередить нас).
Создай конструктор класса Hippodrome с одним параметром типа List.
Сохрани в поле horses полученный в качестве параметра список (инициализируй поле horses).

Ипподром(2)
Раз это ипподром, то на нем должны быть лошади.
Значит наш ипподром должен хранить список всех его лошадей.
Добавь поле horses типа List<Horse> в класс Hippodrome.
А чтобы лошадей не украли — сделай это поле приватным.
Добавь getter для этого поля.

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
    public static void main(String[] args) {
        
        List<Horse> horses = new ArrayList<Horse>();
        
        Horse horseRed = new Horse("red", 3, 0);
        Horse horseBlack = new Horse("black", 3, 0);
        Horse horseWhite = new Horse("White", 3, 0);
        horses.add(horseRed);
        horses.add(horseBlack);
        horses.add(horseWhite);
        game = new Hippodrome(horses);
    }
}
*/
