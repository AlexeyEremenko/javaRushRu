
//Now Thomas, one of the twelve, who is called Didymus, was not with them when Jesus came. (John 20:24)

-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;

import java.util.*;

public class Arkanoid {
    private int width, height;
    
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    
    public static Arkanoid game;
    
    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void move() {}
    public void run() {}
    
    public Ball getBall() {
        return ball;
    }
    public Stand getStand() {
        return stand;
    }
    public List<Brick> getBricks() {
        return bricks;
    }
    
    public void setBall(Ball newBall) {
        this.ball = newBall;
    }
    public void setStand(Stand newStand) {
        this.stand = newStand;
    }
    public void setBricks(List<Brick> newBricks) {
        this.bricks = newBricks;
    }
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public static void main(String[] args) {}
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand {
}
------------------------------------------------------------------------------------------------------------------------------

/*
Арканоид(5)
Чего еще не хватает классу Arkanoid?
Во-первых ему нужен метод run(), в котором будет описана основная логика программы.
Еще нужен метод move() — который будет двигать на один шаг все объекты требующие движения.
Создай методы run() и move().

Еще нам понадобится НЕ приватная статическая переменная game типа Arkanoid, которая будет хранить ссылку на созданный экземпляр класса Arkanoid.

Выглядеть это должно примерно так:
static Arkanoid game;


Требования:
1. В класса Arkanoid должен быть создан метод void run() без параметров.
2. В класса Arkanoid должен быть создан метод void move() без параметров.
3. Метод run должен быть доступен извне класса Arkanoid.
4. Метод move должен быть доступен извне класса Arkanoid.
5. В классе Arkanoid должно быть создано не приватное статическое поле game типа Arkanoid.

Арканоид(4)
Также классу Arkanoid нужно будет хранить ссылку на шарик (Ball), «подставку» Stand и список «кирпичей«.

Надо:
а) создать в классе Arkanoid два private поля: ball типа Ball и stand типа Stand
б) добавить private поле bricks типа List<Brick>
в) добавь для них публичные геттеры и сеттеры

Арканоид(3)
Пожалуй, пора добавить конструктор в класс Arkanoid.
Конструктор должен принимать два параметра типа int (width и height) и корректно устанавливать значения соответствующих полей класса.

Арканоид(2)
Главному классу (Arkanoid) нужно будет хранить информацию о размерах поля, где будут происходить все действия.

Поэтому:
а) добавь в класс Arkanoid два приватных поля width(ширина) и height(высота) типа int
б) создай для них публичные геттеры и сеттеры

Арканоид(1)
Давай сегодня напишем игру Арканоид.

В оригинале это выглядит примерно так http://www.youtube.com/watch?v=Th-Z6QQ5AOQ
Для начала мы напишем упрощенную версию этой игры.
У нас будут кубики, шарик и летающая «подставка«, которая не дает шарику упасть.

Поэтому нам понадобятся классы:
а) Arkanoid — класс в котором происходят основные действия. Также в нем будет наша точка входа в программу, метод main.
б) Ball — шарик.
в) Brick — «кирпичи«, которые мы сбиваем шариком.
г) Stand — летающая подставка.

Создай их, и не забудь о методе public static void main (String[] args) в класе Arkanoid.
-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;

import java.util.*;

public class Arkanoid {
    private int width, height;
    
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    
    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public Ball getBall() {
        return ball;
    }
    public Stand getStand() {
        return stand;
    }
    public List<Brick> getBricks() {
        return bricks;
    }
    
    public void setBall(Ball newBall) {
        this.ball = newBall;
    }
    public void setStand(Stand newStand) {
        this.stand = newStand;
    }
    public void setBricks(List<Brick> newBricks) {
        this.bricks = newBricks;
    }
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public static void main(String[] args) {}
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand {
}
------------------------------------------------------------------------------------------------------------------------------

*/
