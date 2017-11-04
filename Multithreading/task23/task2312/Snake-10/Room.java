
//So they took Jesus' body, and bound it in linen cloths with the spices, as the custom of the Jews is to bury. (John 19:40)

------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;

public class Room {
    private int width, height;
    private Snake snake;
    private Mouse mouse;
    
    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }
    
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public Snake getSnake() {return snake;}
    public Mouse getMouse() {return mouse;}
    public void setWidth(int width) {this.width = width;}
    public void setHeight(int height) {this.height = height;}
    public void setSnake(Snake snake) {this.snake = snake;}
    public void setMouse(Mouse mouse) {this.mouse = mouse;}
    
    public static Room game;
    
    public void run() {}
    public void print() {}
    
    public static void main(String[] args) {
        game = new Room(33, 33, new Snake(15, 15));
        game.snake.setDirection(SnakeDirection.DOWN);
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Snake.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;

import java.util.*;

public class Snake {
    private List<SnakeSection> sections = new ArrayList<SnakeSection>();
    private boolean isAlive;
    private SnakeDirection direction;
    
    public Snake(int x, int y) {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }
    
    public boolean isAlive() {return isAlive;}
    public List<SnakeSection> getSections() {return sections;}
    public SnakeDirection getDirection() {return direction;}
    public void setDirection(SnakeDirection newDirection) {this.direction = newDirection;}
    
    public int getX() {return sections.get(0).getX();}
    public int getY() {return sections.get(0).getY();}
    public void move() {}
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Mouse.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;


public class Mouse {
    private int x, y;
    
    public Mouse(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------SnakeSection.java-------------------------------------------------------
package com.javarush.task.task23.task2312;


public class SnakeSection {
    private int x, y;
    
    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------SnakeDirection.java-----------------------------------------------------
package com.javarush.task.task23.task2312;


public enum SnakeDirection 
    {
     UP,
     RIGHT,
     DOWN,
     LEFT
    }

------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------KeyboardObserver.java---------------------------------------------------
package com.javarush.task.task23.task2312;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class KeyboardObserver extends Thread
{
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);

    private JFrame frame;

    @Override
    public void run()
    {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Transparent JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setSize(400, 400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());

        frame.setOpacity(0.0f);
        frame.setVisible(true);

        frame.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                //do nothing
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                System.exit(0);
            }
        });


        frame.addKeyListener(new KeyListener()
        {

            public void keyTyped(KeyEvent e)
            {
                //do nothing
            }

            public void keyReleased(KeyEvent e)
            {
                //do nothing
            }

            public void keyPressed(KeyEvent e)
            {
                keyEvents.add(e);
            }
        });
    }


    public boolean hasKeyEvents()
    {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop()
    {
        return keyEvents.poll();
    }
}
------------------------------------------------------------------------------------------------------------------------------

/*
Змейка(10)
Займемся методом main.

Для начала надо создать в классе Room статическое поле game типа Room. Доступ к переменной должен быть из всех классов.

Затем в методе main:
а) Создать змею — объект типа Snake.
б) Создать комнату — объект типа Room и передать в него ширину, высоту и змею.
в) Установить змее direction равным SnakeDirection.DOWN

Чего еще не хватает? Собственно метода, в котором будет идти вся игровая логика.
И еще нужен метод, который бы отрисовывал все это на экране:
а) создать метод void run()
б) создать метод void print()


Требования:
1. В методе main класса Room должна быть создана новая змея(объект типа Snake).
2. В методе main класса Room должно быть инициализировано поле game.
3. В методе main класса Room направление движения змеи должно быть установлено равным SnakeDirection.DOWN.
4. В классе Room должен быть создан метод run(), тип возвращаемого значения void.
5. В классе Room должен быть создан метод print(), тип возвращаемого значения void.
6. В классе Room должно быть создано статическое неприватное поле game типа Room.

Змейка(9)
Еще остался самый главный класс — Room.
Что нам нужно для его описания?
Размеры комнаты (width и height) — раз.
Змея — два
Мышь — три.

Надо:
а) создать в классе Room переменные width и height типа int.
б) создать в классе Room переменную snake типа Snake.
в) создать в классе Room переменную mouse типа Snake. Шучу. Типа Mouse, конечно же :).
г) создать для них всех геттеры и сеттеры.
д) создать конструктор. Конструктор должен принимать три параметра: width, height и … snake!


Требования:
1. В классе Room должна быть создана приватная переменная width типа int.
2. В классе Room должна быть создана приватная переменная height типа int.
3. В классе Room должна быть создана приватная переменная snake типа Snake.
4. В классе Room должна быть создана приватная переменная mouse типа Mouse.
5. В классе Room должен быть создан корректный публичный геттер для поля width.
6. В классе Room должен быть создан корректный публичный геттер для поля height.
7. В классе Room должен быть создан корректный публичный геттер для поля snake.
8. В классе Room должен быть создан корректный публичный геттер для поля mouse.
9. В классе Room должен быть создан корректный публичный сеттер для поля width.
10. В классе Room должен быть создан корректный публичный сеттер для поля height.
11. В классе Room должен быть создан корректный публичный сеттер для поля snake.
12. В классе Room должен быть создан корректный публичный сеттер для поля mouse.
13. В классе Room должен быть создан корректный публичный конструктор с параметрами int, int и Snake(width, height и snake).
Змейка(8)
Настала очередь конструктора класса Snake.

Змея у нас будет поначалу состоять из одного кусочка — головы.
А что для него требуется?
Что необходимо передать в конструктор?
Координаты змеи, конечно же.

Надо:
а) Передать в конструктор координаты головы змеи (x и y)
б) создать в нем первый «кусочек змеи» (голову) и добавить его в коллекцию sections.
в) isAlive выставить в true
г) не забудь в конструкторе инициализировать переменную sections. В null не много-то и добавишь!
д) создать и реализовать метод int getX(). Метод должен вернуть координату Х головы змеи.
е) создать и реализовать метод int getY(). Метод должен вернуть координату Y головы змеи.
ж) еще добавить классу метод move()— он нам пригодится попозже.
з) созданный конструктор должен быть публичным.

Змейка(7)
«Кусочки змеи» мы описали, теперь займемся самой змеей.

У змеи должен быть список кусочков(SnakeSection) и голова.
Пусть головой будет просто самый первый кусочек (с номером 0).

У змеи также есть направление движения — сторона, куда она движется по умолчанию.
А еще есть состояние — жива змея или мертва.
Игра заканчивается тогда, когда змея мертва.

Надо:
а) Добавить в класс Snake поле sections типа List<SnakeSection>.
б) Добавить поле isAlive типа boolean.
в) Добавить поле direction типа SnakeDirection.
г) Для всех полей добавить getter’ы, а для direction еще и setter.

Примечание:
Для полей логического типа геттер принято писать не как getValue(), а как isValue() — это улучшает читабельность кода.
Только не пиши isIsAlive(). Одного is будет вполне достаточно.

Примечание 2:
Все поля создаваемые в этом задании должны быть приватными, а методы — публичными.

Змейка(6)
Теперь займемся классом SnakeSection.
Он будет описывать один кусочек змеи.

А у каждого кусочка что есть?
Правильно! Координаты.

Добавь два поля в класс SnakeSection: x и y типа int.
Добавь для них getter’ы и конструктор с двумя параметрами типа int.

Змейка(5)
Теперь доделаем enum SnakeDirection так, чтобы он содержал возможные направления движения змейки.

Добавь 4 значения UP, DOWN, LEFT, RIGHT.

Должно получиться примерно так:
public enum SnakeDirection
{
 UP,
 RIGHT,
 DOWN,
 LEFT
}

Змейка(4)
Координаты x и y ты уже создал в классе Mouse, а как получить к ним доступ?
Создай корректные геттеры для этих полей и конструктор с двумя параметрами типа int (x и y соответственно).
------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;


public class Room {
    private int width, height;
    private Snake snake;
    private Mouse mouse;
    
    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }
    
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public Snake getSnake() {return snake;}
    public Mouse getMouse() {return mouse;}
    public void setWidth(int width) {this.width = width;}
    public void setHeight(int height) {this.height = height;}
    public void setSnake(Snake snake) {this.snake = snake;}
    public void setMouse(Mouse mouse) {this.mouse = mouse;}
    
    public static void main(String[] args) {}
}
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------Snake.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;

import java.util.*;

public class Snake {
    private List<SnakeSection> sections = new ArrayList<SnakeSection>();
    private boolean isAlive;
    private SnakeDirection direction;
    
    public Snake(int x, int y) {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }
    
    public boolean isAlive() {return isAlive;}
    public List<SnakeSection> getSections() {return sections;}
    public SnakeDirection getDirection() {return direction;}
    public void setDirection(SnakeDirection newDirection) {this.direction = newDirection;}
    
    public int getX() {return sections.get(0).getX();}
    public int getY() {return sections.get(0).getY();}
    public void move() {}
}
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------Mouse.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;
public class Mouse {
    private int x, y;
    
    public Mouse(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------SnakeSection.java-------------------------------------------------------
package com.javarush.task.task23.task2312;


public class SnakeSection {
    private int x, y;
    
    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------SnakeDirection.java-----------------------------------------------------
package com.javarush.task.task23.task2312;


public enum SnakeDirection 
    {
     UP,
     RIGHT,
     DOWN,
     LEFT
    }
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------KeyboardObserver.java---------------------------------------------------
package com.javarush.task.task23.task2312;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
public class KeyboardObserver extends Thread
{
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);
    private JFrame frame;
    @Override
    public void run()
    {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Transparent JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setSize(400, 400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());
        frame.setOpacity(0.0f);
        frame.setVisible(true);
        frame.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                //do nothing
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                System.exit(0);
            }
        });
        frame.addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e)
            {
                //do nothing
            }
            public void keyReleased(KeyEvent e)
            {
                //do nothing
            }
            public void keyPressed(KeyEvent e)
            {
                keyEvents.add(e);
            }
        });
    }
    public boolean hasKeyEvents()
    {
        return !keyEvents.isEmpty();
    }
    public KeyEvent getEventFromTop()
    {
        return keyEvents.poll();
    }
}
------------------------------------------------------------------------------------------------------------------------------
*/
