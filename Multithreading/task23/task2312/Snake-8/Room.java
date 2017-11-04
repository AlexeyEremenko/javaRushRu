
//After these things, Joseph of Arimathaea, being a disciple of Jesus, but secretly for fear of the Jews, asked of Pilate that he might take away Jesus' body. Pilate gave him permission. He came therefore and took away his body. (John 19:38)

------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;


public class Room {
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

/*
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


Требования:
1. В классе Snake должен быть создан корректно работающий public конструктор (согласно условию задачи) с двумя параметрами типа int.
2. В классе Snake должен быть создан метод getX() без параметров, возвращающий координату x нулевого элемента списка sections.
3. В классе Snake должен быть создан метод getY() без параметров, возвращающий координату y нулевого элемента списка sections.
4. В классе Snake должен быть создан метод move.

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


Требования:
1. В классе Snake должно быть объявлено поле sections типа List.
2. В классе Snake должно быть объявлено поле isAlive типа boolean.
3. В классе Snake должно быть объявлено поле direction типа SnakeDirection.
4. В классе Snake должен быть создан корректный геттер для поля sections.
5. В классе Snake должен быть создан корректный геттер для поля isAlive.
6. В классе Snake должен быть создан корректный геттер для поля direction.
7. В классе Snake должен быть создан корректный сеттер для поля direction.
8. Все поля класса Snake должны быть объявлены с модификатором доступа private.
9. Все методы класса Snake должны быть объявлены с модификатором доступа public.

Змейка(6)
Теперь займемся классом SnakeSection.
Он будет описывать один кусочек змеи.

А у каждого кусочка что есть?
Правильно! Координаты.

Добавь два поля в класс SnakeSection: x и y типа int.
Добавь для них getter’ы и конструктор с двумя параметрами типа int.


Требования:
1. В классе SnakeSection должно существовать поле x типа int, доступ к которому разрешен только в пределах этого класса.
2. В классе SnakeSection должно существовать поле y типа int, доступ к которому разрешен только в пределах этого класса.
3. В классе SnakeSection должен быть создан корректный геттер для поля x.
4. В классе SnakeSection должен быть создан корректный геттер для поля y.
5. В классе SnakeSection должен быть создан корректно работающий публичный конструктор с двумя параметрами типа int.

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
Требования:
1. SnakeDirection должен содержать элемент UP.
2. SnakeDirection должен содержать элемент DOWN.
3. SnakeDirection должен содержать элемент RIGHT.
4. SnakeDirection должен содержать элемент LEFT.
Змейка(4)
Координаты x и y ты уже создал в классе Mouse, а как получить к ним доступ?
Создай корректные геттеры для этих полей и конструктор с двумя параметрами типа int (x и y соответственно).
Требования:
1. В классе Mouse должен быть создан корректный геттер для поля x.
2. В классе Mouse должен быть создан корректный геттер для поля y.
3. В классе Mouse должен быть создан корректно работающий публичный конструктор с двумя параметрами типа int.
Змейка(3)
Отлично. Я еще добавил класс KeyboardObserver на будущее.
Изучи его внимательно. Пригодится.
Начнем с самого простого — класса Mouse.
Мышь не будет двигаться и у нее будут только координаты и все.
Добавь два приватных поля в класс Mouse: x и y типа int.
Требования:
1. Внимательно изучи класс KeyboardObserver.
2. В классе Mouse должно существовать поле x типа int, доступ к которому разрешен только в пределах этого класса.
3. В классе Mouse должно существовать поле y типа int, доступ к которому разрешен только в пределах этого класса.
Змейка(2)
Теперь самое интересное — как будет устроена змея.
Что можно сказать о змее:
а) По сути — змея это набор кусочков — клеточек. Но точно известно, что один из них — голова.
б) У змеи есть направление движения.
Так что нам еще понадобятся классы:
SnakeSection — кусочек змеи.
SnakeDirection — класс (enum) будет описывать направление движения змеи.
Создай классы SnakeSection и SnakeDirection.
Требования:
1. Класс SnakeSection должен быть создан в отдельном файле.
2. Перечисление(enum) SnakeDirection должно быть создано в отдельном файле.
Змейка(1)
А теперь напишем игру "змейка".
Для этого нам понадобятся:
а) собственно сама змея (класс Snake)
б) комната, в которой она будет ползать (класс Room)
в) мыши, которых она будет есть (класс Mouse)
Создай классы Snake, Room, Mouse
Не забудь создать метод public static void main(String[] args) в классе Room.
------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;
public class Room {
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
    
    public boolean isAlive() {return isAlive;}
    public List<SnakeSection> getSections() {return sections;}
    public SnakeDirection getDirection() {return direction;}
    public void setDirection(SnakeDirection newDirection) {this.direction = newDirection;}
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
