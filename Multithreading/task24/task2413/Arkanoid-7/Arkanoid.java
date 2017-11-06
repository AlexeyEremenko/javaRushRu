
//After eight days again his disciples were inside, and Thomas was with them. Jesus came,
//the doors being locked, and stood in the midst, and said, "Peace be to you." (John 20:26)

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


-----------------------------------------------BaseObject.java----------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class BaseObject {
    
    private double x;
    private double y;
    
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;   
    }
    
    public void setX(double newX) {
        this.x = newX;
    }
    public void setY(double newY) {
        this.y = newY;
    }
    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Canvas.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Canvas {
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball extends BaseObject {
    
    
    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick extends BaseObject {
    
    public Brick(double x, double y, double radius) {
        super(x, y, radius);
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand extends BaseObject {
    
    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }
}
------------------------------------------------------------------------------------------------------------------------------

/*
Арканоид(7)
Теперь перейдем к классу BaseObject.
Я хочу сделать несколько предложений.

Во-первых для простоты считать все объекты у нас будут круглыми.
Нет, отрисовывать их мы будем фигурными, как и раньше.
А вот при расчетах из взаимодействия исходить из того, что они круглые.
Так — гораздо проще.

Во-вторых. Пусть координаты объектов и радиус будут вещественными числами.
Это придаст плавность движениям и точность всем вычислениям.
А при отрисовке мы будем их округлять.

Итак:
а) Добавь в класс BaseObject приватные поля x (double), y (double), radius (double).
б) Добавь геттеры и сеттеры.
в) Добавь конструктор BaseObject(double x, double y, double radius).
г) Пройдись по все классам-наследникам и поправь у них конструкторы.

Если вы пользуйтесь Intellij IDEA — Alt+Insert вам в помощь.


Требования:
1. В классе BaseObject должно быть создано приватное поле x типа double.
2. В классе BaseObject должно быть создано приватное поле y типа double.
3. В классе BaseObject должно быть создано приватное поле radius типа double.
4. В классе BaseObject должен быть создан корректно работающий конструктор с тремя параметрами типа double (x, y, radius).
5. В классе Ball должен быть создан корректно работающий конструктор с тремя параметрами типа double (x, y, radius).
6. В классе Brick должен быть создан корректно работающий конструктор с тремя параметрами типа double (x, y, radius).
7. В классе Stand должен быть создан корректно работающий конструктор с тремя параметрами типа double (x, y, radius).
8. В классе BaseObject должен быть создан публичный геттер для поля x.
9. В классе BaseObject должен быть создан публичный геттер для поля y.
10. В классе BaseObject должен быть создан публичный геттер для поля radius.
11. В классе BaseObject должен быть создан публичный сеттер для поля x.
12. В классе BaseObject должен быть создан публичный сеттер для поля y.
13. В классе BaseObject должен быть создан публичный сеттер для поля radius.

Арканоид(6)
У нас будут «кирпичи«, «шарик» и «подставка» и у них будет много общего.
Они будут перемещаться по полю и отрисовываться.
Значит у них у всех будут координаты и размер.
А еще методы move() — для перемещения и draw() для отрисовки.

Есть интересное предложение: давай введем один базовый класс для все объектов.
Пусть это будет класс BaseObject.
А классы Ball, Stand, Brick от него наследуются.

Создай класс BaseObject и добавь его родителем к классам Ball, Stand, Brick

Еще нам понадобится класс Canvas
Он будет ответственным за «отрисовку» объектов.
С помощью его они будут отрисовывать себя.
Вернее даже на нем, но детали я сообщу позднее.

Создай и этот класс.


Требования:
1. Класс BaseObject должен быть создан в отдельном файле.
2. Класс Canvas должен быть создан в отдельном файле.
3. Класс Ball должен быть потомком класса BaseObject.
4. Класс Brick должен быть потомком класса BaseObject.
5. Класс Stand должен быть потомком класса BaseObject.

Арканоид(5)
Чего еще не хватает классу Arkanoid?
Во-первых ему нужен метод run(), в котором будет описана основная логика программы.
Еще нужен метод move() — который будет двигать на один шаг все объекты требующие движения.
Создай методы run() и move().

Еще нам понадобится НЕ приватная статическая переменная game типа Arkanoid, которая будет хранить ссылку на созданный экземпляр класса Arkanoid.

Выглядеть это должно примерно так:
static Arkanoid game;

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


-----------------------------------------------BaseObject.java----------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class BaseObject {
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Canvas.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Canvas {
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball extends BaseObject {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick extends BaseObject {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand extends BaseObject {
}
------------------------------------------------------------------------------------------------------------------------------
*/
