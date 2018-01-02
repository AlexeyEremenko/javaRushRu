
//Behold, the hour cometh, yea, is now come, that ye shall be scattered, every man to his own, 
//and shall leave me alone: and yet I am not alone, because the Father is with me. (John 16:32)

package com.javarush.task.task25.task2515;

import java.util.ArrayList;

public class Space {


    private int width, height;

    private SpaceShip ship;

    private ArrayList<Ufo> ufos = new ArrayList<>();
    private ArrayList<Rocket> rockets = new ArrayList<>();
    private ArrayList<Bomb> bombs = new ArrayList<>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void run() {}
    public void draw() {}
    public void sleep(int ms) {}

    public static void main(String[] args) {
        
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public ArrayList<Ufo> getUfos() {
        return ufos;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }
}

/*
Space (4)

Чего не хватает классу Space?

Правильно - методов run() и draw().

run управляет всей логикой игры, если ты помнишь.

А draw отвечает за отрисовку очередного "кадра".



А еще нам пригодится метод sleep(int ms).

Создай их.





Требования:

1. В классе Space создай метод run().

2. В классе Space создай метод draw().

3. В классе Space создай метод sleep(int ms).
*/
