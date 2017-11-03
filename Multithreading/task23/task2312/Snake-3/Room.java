
//He who has seen has testified, and his testimony is true. He knows that he tells the truth, that you may believe. (John 19:35)

------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;


public class Room {
    public static void main(String[] args) {}
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Snake.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;


public class Snake {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Mouse.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;


public class Mouse {
    private int x, y;
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------SnakeSection.java-------------------------------------------------------
package com.javarush.task.task23.task2312;


public class SnakeSection {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------SnakeDirection.java-----------------------------------------------------
package com.javarush.task.task23.task2312;


public enum SnakeDirection {
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


public class Snake {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Mouse.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;


public class Mouse {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------SnakeSection.java-------------------------------------------------------
package com.javarush.task.task23.task2312;


public class SnakeSection {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------SnakeDirection.java-----------------------------------------------------
package com.javarush.task.task23.task2312;


public enum SnakeDirection {
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
