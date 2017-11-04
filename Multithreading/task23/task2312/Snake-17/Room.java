
//Stooping and looking in, he saw the linen cloths lying, yet he didn't enter in. (John 20:5)

------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;


import java.awt.event.KeyEvent;

/**
 * Основной класс программы.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Выводим на экран текущее состояние игры
     */
    public void print() {
        int [][] frame = new int[height][width]; //Создаем массив, куда будем "рисовать" текущее состояние игры
        
        int headX = snake.getSections().get(0).getX();
        int headY = snake.getSections().get(0).getY();
        int mouseX = mouse.getX();
        int mouseY = mouse.getY();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i==(headY) && j==(headX)){ //HEAD
                    frame[i][j]=2;
                }

                for (int k = 1; k < snake.getSections().size(); k++) {
                    int elemX = snake.getSections().get(k).getX();
                    int elemY = snake.getSections().get(k).getY();

                    if (i==(elemY) && j==(elemX)){ //ELEM
                        frame[i][j]=1;
                    }
                }

                if (i==(mouseY) && j==(mouseX)){ //MOUSE
                    frame[i][j]=3;
                }

            }

        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (frame[i][j]==1){
                    System.out.print('x');
                } else if (frame[i][j]==2){
                    System.out.print('X');
                } else if (frame[i][j]==3){
                    System.out.print('^');
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }
    /**
     * Метод вызывается, когда мышь съели
     */
    public void eatMouse() {
        createMouse();
    }

    /**
     * Создает новую мышь
     */
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public static Room game;

    public static void main(String[] args) {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }


    /**
     * Программа делает паузу, длинна которой зависит от длинны змеи.
     */
    public void sleep() {
        int pause = 500;
        if (game.snake.getSections().size() >= 11) {pause = 300;}
        if (game.snake.getSections().size() >= 15) {pause = 200;}
        try{
            Thread.sleep(pause);
        }catch(InterruptedException e) {e.printStackTrace();}
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
    
    public void move() {
        if (isAlive == false) {return;}
        if (direction == SnakeDirection.UP) {move(0, -1);}
        if (direction == SnakeDirection.RIGHT) {move(1, 0);}
        if (direction == SnakeDirection.DOWN) {move(0, 1);}
        if (direction == SnakeDirection.LEFT) {move(-1, 0);}
    }
    
    public void move(int x, int y) {
        SnakeSection newHead = new SnakeSection(sections.get(0).getX() + x, sections.get(0).getY() + y);
        checkBorders(newHead);
        if (!isAlive()) return;
        checkBody(newHead);
        if (!isAlive()) return;
        if (newHead.getX() == Room.game.getMouse().getX() && newHead.getY() == Room.game.getMouse().getY()){
            Room.game.eatMouse();
            sections.add(0, newHead);
        }else {
            sections.add(0, newHead);
            sections.remove(sections.size() - 1);
        }
    }
    
     public void checkBorders (SnakeSection head){
        int headX = head.getX();
        int headY = head.getY();
        int widthRoom = Room.game.getWidth();
        int heightRoom = Room.game.getHeight();

        if (headX<0 || headX>=widthRoom || headY<0 || headY>=heightRoom){
            isAlive = false;
        }
        System.out.println(isAlive);
    }
    public void checkBody(SnakeSection head){
        if (sections.contains(head)){
            isAlive=false;
        }
    }
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
    private int x;
    private int y;


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
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        SnakeSection that = (SnakeSection) o;
        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
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
Змейка(17)
Теперь закончим класс Snake.

Змея состоит из кусочков. Давай каждый ход просто добавлять один кусочек со стороны головы,
а самый последний — удалять. Тогда получится, что змея ползет.
Добавлять кусочек нужно рядом с текущей головой (кусочком номер 0).
С какой стороны добавлять зависит от direction (UP, DOWN, LEFT, RIGHT).

Подсказка:
а) Как добавить кусочек змеи в начало списка sections?
sections.add(0, new_section);
б) А как удалить последний?
sections.remove(sections.size()-1);

Необходимо реализовать метод move(int dx, int dy):
а) проверить, не вылезла ли она за границу комнаты (если да, то змея умирает)
б) проверить, не совпадает ли она с уже существующими кусочками змеи (если да, то змея умирает)
в) добавить голову к змее (со стороны головы) и удалить последний кусочек из хвоста.
г) вызвать метод eatMouse у статического объекта game класса Room, если координаты мыши совпадают с координатами головы змеи.
д) если змея поймала мышь (координаты головы совпадают с координатами мыши), то удалять кусок из хвоста не надо.


Требования:
1. В методе move(int dx, int dy) должен быть вызван метод checkBorders.
2. В методе move(int dx, int dy) должен быть вызван метод checkBody.
3. В случае если змея осталась жива, необходимо добавить голову и удалить последний элемент из хвоста змеи.
4. В случае, если змея поймала мышь, необходимо добавить голову, но последний элемент удалять не нужно.
5. Необходимо вызвать метод eatMouse у статического объекта game класса Room, если координаты мыши совпадают с координатами головы змеи.
Змейка(16)
Ничто не вечно. Так и змея должна умирать, если она врезается в стену или саму себя.

Для определения, не пересекается ли змея сама с собой, можно сделать очень простую проверку:
содержит ли список sections «новую голову змеи«.

Код для этого будет выглядеть примерно так:
if (sections.contains(head))

При этом head должен быть еще не добавлен в список sections, иначе будет всегда true.
Но чтобы этот код работал, надо реализовать методы сравнения объектов (equals и hashCode) в классе SnakeSection.

Подсказка:
Используй Ctrl+O в Intellij IDEA для автоматической генерации методов equals и hashCode.

Задание:
а) реализуй методы equals и hashCode в классе SnakeSection.
б) реализуй метод checkBorders(SnakeSection head): если голова змеи за границами комнаты — змея умирает (isAlive = false)
в) реализуй метод checkBody(SnakeSection head): если голова змеи пересекается с ее телом — змея умирает (isAlive = false)

Змейка(15)
Теперь осталось допилить змею.

Вот что я предлагаю насчет движения змеи:
Змея состоит из кусочков. Давай каждый ход просто добавлять один кусочек со стороны головы,
а самый последний — удалять. Тогда получится, что змея ползет.

Давай добавим два метода move, один без параметров, а другой с двумя параметрами типа int.

В методе move без параметров необходимо:
а) прекратить движение если змея умерла(isAlive == false)
б) вызвать метод move(0, -1) если направление движения равно SnakeDirection.UP
в) вызвать метод move(1, 0) если направление движения равно SnakeDirection.RIGHT
г) вызвать метод move(0, 1) если направление движения равно SnakeDirection.DOWN
д) вызвать метод move(-1, 0) если направление движения равно SnakeDirection.LEFT

Метод move с параметрами int, int пока оставим пустым.

Змейка(14)
Теперь поработаем над методом print().

Надо:
а) вывести на экран прямоугольник из точек размером width x height.
б) тело змеи отметить символом «x«-английское
в) голову змеи нарисовать символом «X«-английское.

Подсказка:
а) удобно сначала создать матрицу типа int[][] с размером (height x width)
б) затем пройтись по всем объектам и отрисовать их в матрицу.
Например, тело змеи — 1, голова змеи — 2, мышь — 3.

Змейка(13)
Предлагаю тебе в этот раз написать специальный метод sleep(), который будет делать паузу в зависимости от длины змеи (количества элементов в sections).
Придумай какой-нибудь хитрый алгоритм. Чтобы на первом уровне пауза была 500 миллисекунд,
а к 10 уровню постепенно уменьшилась до 300. А к 15 до 200. И дальше оставалась постоянной.

Змейка(12)
Змея у нас есть, пусть и мышь будет.

Добавить в метод main:
a) вызов метода createMouse().
б) вызов метода run().
Без него ничего работать не будет. В нем вся основная логика.
Неплохо получилось, но я все-таки внесу пару правок.
Кстати, как насчет написать метод sleep?
Ты уже понял из предыдущих задач, что в методе run нужна пауза.
Но насколько я помню, скорость в змейке должна расти при росте ее длины.
Значит чем длиннее змея, тем выше скорость и меньше пауза.
------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;


import java.awt.event.KeyEvent;

/**
 * Основной класс программы.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Выводим на экран текущее состояние игры
     */
    public void print() {
        int [][] frame = new int[height][width]; //Создаем массив, куда будем "рисовать" текущее состояние игры
        
        int headX = snake.getSections().get(0).getX();
        int headY = snake.getSections().get(0).getY();
        int mouseX = mouse.getX();
        int mouseY = mouse.getY();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i==(headY) && j==(headX)){ //HEAD
                    frame[i][j]=2;
                }

                for (int k = 1; k < snake.getSections().size(); k++) {
                    int elemX = snake.getSections().get(k).getX();
                    int elemY = snake.getSections().get(k).getY();

                    if (i==(elemY) && j==(elemX)){ //ELEM
                        frame[i][j]=1;
                    }
                }

                if (i==(mouseY) && j==(mouseX)){ //MOUSE
                    frame[i][j]=3;
                }

            }

        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (frame[i][j]==1){
                    System.out.print('x');
                } else if (frame[i][j]==2){
                    System.out.print('X');
                } else if (frame[i][j]==3){
                    System.out.print('^');
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }
    /**
     * Метод вызывается, когда мышь съели
     */
    public void eatMouse() {
        createMouse();
    }

    /**
     * Создает новую мышь
     */
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public static Room game;

    public static void main(String[] args) {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }


    /**
     * Программа делает паузу, длинна которой зависит от длинны змеи.
     */
    public void sleep() {
        int pause = 500;
        if (game.snake.getSections().size() >= 11) {pause = 300;}
        if (game.snake.getSections().size() >= 15) {pause = 200;}
        try{
            Thread.sleep(pause);
        }catch(InterruptedException e) {e.printStackTrace();}
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
    public void move() {
        if (isAlive == false) {return;}
        if (direction == SnakeDirection.UP) {move(0, -1);}
        if (direction == SnakeDirection.RIGHT) {move(1, 0);}
        if (direction == SnakeDirection.DOWN) {move(0, 1);}
        if (direction == SnakeDirection.LEFT) {move(-1, 0);}
    }
    
     public void checkBorders (SnakeSection head){
        int headX = head.getX();
        int headY = head.getY();
        int widthRoom = Room.game.getWidth();
        int heightRoom = Room.game.getHeight();

        if (headX<0 || headX>=widthRoom || headY<0 || headY>=heightRoom){
            isAlive = false;
        }
        System.out.println(isAlive);
    }
    public void checkBody(SnakeSection head){
        if (sections.contains(head)){
            isAlive=false;
        }
    }
    public void move(int x, int y) {}
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
    private int x;
    private int y;


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
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        SnakeSection that = (SnakeSection) o;
        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
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
