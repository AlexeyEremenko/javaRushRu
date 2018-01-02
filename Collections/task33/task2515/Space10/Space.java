
//John to the seven churches which are in Asia: Grace [be] unto you, and peace, from him which is, and which was,
//and which is to come; and from the seven Spirits which are before his throne (Revelation 1:4)

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

    public static Space game;

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
Space (10)

Теперь напишем класс Bomb. Тут все просто.

Bomb унаследован от BaseObject.



Надо:

а) изменить конструктор:

Конструктор Bomb должен выглядеть примерно так:

public Bomb(double x, double y)

{

super(x, y, 1);

}



x и y переданные в конструктор Bomb мы передаем дальше в конструктор BaseObject с помощью super, где так же указываем радиус "бомбы" равный 1.



б) написать метод move():

тут все просто - бомба падает вниз - просто увеличиваем y на 1.



в) метод draw(Canvas canvas):

тут тоже не очень сложная логика.

Давай просто ставить точку с координатами (x,y) и "цветом" B:

canvas.setPoint(x,y,'B').



г) Создай в классе Space нашу игру public static Space game.





Требования:

1. В классе Bomb конструктор должен принимать координаты, а радиус выставлять всегда равным 1.

2. В классе Bomb напиши метод move(), который увеличивает координату y на единицу.

3. В классе Bomb напиши метод draw(Canvas canvas), который для canvas будет ставить символ 'B' в координатах x, y.

4. В классе Space создай поле public static Space game.
*/
