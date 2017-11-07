
//Is Christ divided? was Paul crucified for you? or were you baptized in the name of Paul? (1Cor 1:13)

-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Главный класс игры
 */
public class Arkanoid {
    //ширина и высота
    private int width;
    private int height;

    //список кирпичей
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    //шарик
    private Ball ball;
    //подставка
    private Stand stand;

    //игра закончена?
    private boolean isGameOver = false;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    /**
     * Рисуем на холсте границы и все объекты.
     */
    void draw(Canvas canvas) {
        drawBorders(canvas);

        //draw bricks
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }

        //draw ball
        ball.draw(canvas);

        //draw stand
        stand.draw(canvas);

    }

    /**
     * Рисуем на холсте границы
     */
    private void drawBorders(Canvas canvas) {
        //draw game
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++) {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++) {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    void run() throws Exception {
        //Создаем холст для отрисовки.
        Canvas canvas = new Canvas(width, height);

        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //Исполняем цикл, пока игра не окончека
        while (!isGameOver) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    stand.moveLeft();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    stand.moveRight();
                    //Если "пробел" - запускаем шарик
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ball.start();
            }

            //двигаем все объекты
            move();

            //проверяем столкновения
            checkBricksBump();
            checkStandBump();

            //проверяем, что шарик мог улететь через дно.
            checkEndGame();

            //отрисовываем все объекты
            canvas.clear();
            draw(canvas);
            canvas.print();

            //пауза
            Thread.sleep(300);
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Двигаем шарик и подставку.
     */
    public void move() {
        ball.move();
        stand.move();
    }

    /**
     * Проверяем столкновение с кирпичами.
     * Если столкновение было - шарик отлетает в случайном направлении 0..360 градусов
     */
    void checkBricksBump() {
        for (Brick brick : new ArrayList<Brick>(bricks)) {
            if (ball.isIntersec(brick)) {
                double angle = Math.random() * 360;
                ball.setDirection(angle);

                bricks.remove(brick);
            }
        }
    }

    /**
     * Проверяем столкновение с подставкой.
     * Если столкновение было - шарик отлетает в случайном направлении  вверх 80..100 градусов.
     */
    void checkStandBump() {
        if (ball.isIntersec(stand)) {
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }

    /**
     * Проверяем - не улетел ли шарик через дно.
     * Если да - игра окончена (isGameOver = true)
     */
    void checkEndGame() {
        if (ball.getY() > height && ball.getDy() > 0)
            isGameOver = true;
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

    public static Arkanoid game;

    public static void main(String[] args) throws Exception {
        game = new Arkanoid(20, 30);

        Ball ball = new Ball(10, 29, 2, 95);
        game.setBall(ball);

        Stand stand = new Stand(10, 30);
        game.setStand(stand);

        game.getBricks().add(new Brick(3, 3));
        game.getBricks().add(new Brick(7, 5));
        game.getBricks().add(new Brick(12, 5));
        game.getBricks().add(new Brick(16, 3));

        game.run();
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------BaseObject.java----------------------------------------------------------------
package com.javarush.task.task24.task2413;

/**
 * Класс для шарика в игре
 */
public class Ball extends BaseObject {
    //скорость
    private double speed;
    //направление  (в градусах от 0 до 360)
    private double direction;

    //текущее значение вектора движения (dx,dy)
    private double dx;
    private double dy;

    //заморожен ли объект или может двигаться
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);

        this.direction = direction;
        this.speed = speed;

        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    /**
     * Устанавливаем новое направление движения.
     * Тут же вычисляем и новый вектор.
     * Такой подход удобно использовать при отскоках от стен.
     */
    void setDirection(double direction) {
        this.direction = direction;

        double angel = Math.toRadians(direction);
        dx = Math.cos(angel) * speed;
        dy = -Math.sin(angel) * speed;
    }

    /**
     * Рисуем себя на "канвасе".
     */
    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    /**
     * Двигаем себя на один шаг.
     */
    public void move() {
        if (isFrozen) return;

        x += dx;
        y += dy;

        checkRebound(1, Arkanoid.game.getWidth(), 1, Arkanoid.game.getHeight() + 5);
    }

    /**
     * Проверяем не улетел ли шарик за стенку.
     * Если да - отражаем его.
     */
    void checkRebound(int minx, int maxx, int miny, int maxy) {
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }

    /**
     * Запускам шарик.
     * isFrozen = false.
     * Пересчитываем вектор движения (dx,dy).
     */
    void start() {
        this.setDirection(direction);
        this.isFrozen = false;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Canvas.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;

/**
 * Класс-холст для отрисовки.
 */
public class Canvas {
    //ширина и высота
    private int width;
    private int height;
    //матрица, где рисуем. символ - это цвет.
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }

    /**
     * Очищаем холст
     */
    void clear() {
        this.matrix = new char[height + 2][width + 2];
    }

    /**
     * Печатаем переданную фигуру в указанных координатах цветом c.
     * Если переданный массив содержит единицы, то на холсте им будут соответствовать символы - с.
     */
    void drawMatrix(double x, double y, int[][] matrix, char c) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1)
                    setPoint(x + j, y + i, c);
            }
        }
    }

    /**
     * Ставим одну точку на холсте с координатами (x,y) и цветом - c.
     */
    void setPoint(double x, double y, char c) {
        int x0 = (int) Math.round(x);
        int y0 = (int) Math.round(y);
        if (y0 < 0 || y0 >= matrix.length) return;
        if (x0 < 0 || x0 >= matrix[y0].length) return;

        matrix[y0][x0] = c;
    }

    /**
     * Печатаем содержимое холста на экран.
     */
    void print() {
        System.out.println();

        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;

/**
 * Класс для шарика в игре
 */
public class Ball extends BaseObject {
    //скорость
    private double speed;
    //направление  (в градусах от 0 до 360)
    private double direction;

    //текущее значение вектора движения (dx,dy)
    private double dx;
    private double dy;

    //заморожен ли объект или может двигаться
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);

        this.direction = direction;
        this.speed = speed;

        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    /**
     * Устанавливаем новое направление движения.
     * Тут же вычисляем и новый вектор.
     * Такой подход удобно использовать при отскоках от стен.
     */
    void setDirection(double direction) {
        this.direction = direction;

        double angel = Math.toRadians(direction);
        dx = Math.cos(angel) * speed;
        dy = -Math.sin(angel) * speed;
    }

    /**
     * Рисуем себя на "канвасе".
     */
    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    /**
     * Двигаем себя на один шаг.
     */
    public void move() {
        if (isFrozen) return;

        x += dx;
        y += dy;

        checkRebound(1, Arkanoid.game.getWidth(), 1, Arkanoid.game.getHeight() + 5);
    }

    /**
     * Проверяем не улетел ли шарик за стенку.
     * Если да - отражаем его.
     */
    void checkRebound(int minx, int maxx, int miny, int maxy) {
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }

    /**
     * Запускам шарик.
     * isFrozen = false.
     * Пересчитываем вектор движения (dx,dy).
     */
    void start() {
        this.setDirection(direction);
        this.isFrozen = false;
    }
}

------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;

/**
 * Класс для объекта "кирпич".
 */
public class Brick extends BaseObject {
    //картинка для отрисовки
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };

    public Brick(double x, double y) {
        super(x, y, 3);
    }

    /**
     * Рисуем себя на холсте
     */
    @Override
    void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'H');
    }

    /**
     * Ничего не делаем - кирпич неподвижен
     */
    @Override
    void move() {
        //do nothing
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;

/**
 * Подставка, с помощью которой отражаем мячик.
 */
public class Stand extends BaseObject {
    //картинка для отрисовки
    private static int[][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };

    //скорость
    private double speed = 1;
    //направление (-1 влево, +1 вправо)
    private double direction = 0;

    public Stand(double x, double y) {
        super(x, y, 3);
    }

    /**
     * Метод передвигает подставку в соответствии с текущим значением direction.
     */
    void move() {
        double dx = speed * direction;
        x = x + dx;

        checkBorders(radius, Arkanoid.game.getWidth() - radius + 1, 1, Arkanoid.game.getHeight() + 1);
    }

    /**
     * direction устанавливается равным -1
     */
    void moveLeft() {
        direction = -1;
    }

    /**
     * direction устанавливается равным +1
     */
    void moveRight() {
        direction = 1;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    /**
     * Отрисовываем себя на холсте
     */
    @Override
    void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'M');
    }
}
------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------KeyboardObserver.java-----------------------------------------------------
package com.javarush.task.task24.task2413;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class KeyboardObserver extends Thread {
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Transparent JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setSize(400, 400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());

        frame.setOpacity(0.0f);
        frame.setVisible(true);

        frame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.exit(0);
            }
        });


        frame.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                //do nothing
            }

            public void keyReleased(KeyEvent e) {
                //do nothing
            }

            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
            }
        });
    }


    public boolean hasKeyEvents() {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() {
        return keyEvents.poll();
    }
}
------------------------------------------------------------------------------------------------------------------------------

/*
Арканоид(20)
Отличная работа! Я добавил пару методов, а также класс KeyboardObserver.

Немного отдохни перед новым уровнем и поиграй.

P.S. Только не забудь отрегулировать высоту консоли.


Требования:
1. получай удовольствие.

Арканоид(19)
Осталось совсем чуть-чуть.

В классе Arkanoid создай поле приватное isGameOver типа boolean.

Реализуй метод checkBricksBump.
В этом методе надо проверить — не столкнулся ли шарик с каким-нибудь из «кирпичей«.
Для проверки столкновения используй метод isIntersec.
Если шарик все-таки попал в кирпич, то:
а) шарик отлетает в случайном направлении:
double angle = Math.random() * 360;
ball.setDirection(angle);
б) кирпич умирает — надо удалить его из списка всех кирпичей.

Реализуй метод checkStandBump.
В этом методе надо проверить — не ударился ли шарик о подставку.
Для проверки столкновения используй метод isIntersec.
Если шарик все-таки ударился о подставку, то:
шарик отлетает в случайным направлении вверх:
double angle = 90 + 20 * (Math.random() — 0.5);
ball.setDirection(angel);

Реализуй метод checkEndGame.
Если координата y шарика больше чем высота поля игры (height), значит шарик улетел вниз за границу экрана.
В этом случае надо переменную isGameOver установить в true.


Требования:
1. В классе Arkanoid должен быть реализован метод checkBricksBump() в соответствии с условием задачи.
2. В классе Arkanoid должен быть реализован метод checkStandBump() в соответствии с условием задачи.
3. В классе Arkanoid должен быть реализован метод checkEndGame() в соответствии с условием задачи.
4. В классе Arkanoid должно быть создано приватное поле isGameOver типа boolean.

Арканоид(18)
Теперь вернемся к классу Arkanoid.

Реализуй методы:
а) move()
В этом методе нужно двигать все движимые объекты (stand, ball).
б) draw(Canvas canvas)
В этом методе надо вызвать метод draw всех существующих объектов, которые его имеют.


Требования:
1. В классе Arkanoid должен быть реализован метод move() без параметров, вызывающий методы move() у шарика и подставки.
2. В классе Arkanoid должен быть реализован метод draw(Canvas canvas) без параметров, вызывающий методы draw() у шарика, подставки и всех кирпичей.

Арканоид(17)
Еще подставке нужны методы:
а) move — см. move в BaseObject
Движение доски осуществляется горизонтально, поэтому мы меняем только координату х.
Подумай, как координата х зависит от направления (direction) и скорости (speed). Реализуй зависимость.
б) draw — см. draw в BaseObject
Его кодом я займусь сам.
в) moveLeft() — задает постоянное движение «подставки» влево
Просто присвой правильное значение переменной direction.
г) moveRight() — задает постоянное движение «подставки» вправо
Просто присвой правильное значение переменной direction.
Требования:
1. В классе Stand должен быть реализован метод move увеличивающий координату x на произведение значений полей speed и direction.
2. В классе Stand должен быть реализован метод moveLeft, устанавливающий значение поля direction равным -1.
3. В классе Stand должен быть реализован метод moveRight, устанавливающий значение поля direction равным 1.
Арканоид(16)
И наконец «подставка«!
Ей понадобятся такие приватные поля:
а) speed (скорость шарика) типа double;
б) direction (направление движения по оси x: 1 — вправо, -1 — влево, 0 — начальное значение, стоим на месте) типа double.
Также создай для них геттеры.
А еще с тебя конструктор, примерно вот такой:
public Stand(double x, double y) {
super(x, y, 3);
speed = 1;
direction = 0;
}
Требования:
1. В классе Stand должно быть создано приватное поле speed типа double.
2. В классе Stand должно быть создано приватное поле direction типа double.
3. В классе Stand должен быть реализован публичный геттер для поля speed.
4. В классе Stand должен быть реализован публичный геттер для поля direction.
5. В классе Stand должен быть реализован конструктор с двумя параметрами типа double в соответствии с условием задачи.
Арканоид(15)
Не поверишь, но и это еще не все.
Во-первых нужен метод setDirection,
который не только устанавливает значение переменной direction,
но и вычисляет новые значения переменных dx и dy.
Код должен выглядеть примерно так:
this.direction = direction;
double angel = Math.toRadians(direction);
dx = Math.cos(angle) * speed;
dy = -Math.sin(angle) * speed.
Во-вторых шарик может удариться о стенку.
При этом он должен от нее отскочить.
Для этого нам понадобится еще один метод:
void checkRebound(int minx, int maxx, int miny, int maxy)
Создай его, а кодом я займусь сам.
Требования:
1. В классе Ball должен быть создан метод setDirection() c одним параметром типа double (реализацию смотри в условии).
2. В классе Ball должен быть создан метод checkRebound c четырьмя параметрами типа int.
Арканоид(14)
Чего-то не хватает в классе Ball:
Во-первых надо реализовать метод move(), унаследованный от BaseObject:
а) x должен увеличиваться на dx каждый ход
б) y должен увеличиваться на dy каждый ход
если шарик «заморожен«, то x и y меняться не должны
Во-вторых надо реализовать метод draw(Canvas canvas):
на объекте canvas необходимо вызвать метод setPoint с параметрами (x, y, ‘O‘)
В-третьих надо реализовать метод start()
Именно его вызов «размораживает» шарик.
Что для этого надо сделать — это ты уже сам реши.
P.S. Чуть не забыл! Поля x, y и radius объявлены в классе BaseObject с модификатором доступа private,
что не очень-то удобно. Измени его на protected, чтобы все потомки класса BaseObject имели контроль над своими
координатами и размерами, без необходимости пользоваться «чужими» геттерами и сеттерами.
Требования:
1. Метод move() в классе Ball должен увеличивать значение x на dx, если значение поля isFrozen равно false.
2. Метод move() в классе Ball должен увеличивать значение y на dy, если значение поля isFrozen равно false.
3. Метод move() в классе Ball не должен менять значения полей x и y, если значение поля isFrozen равно true.
4. В классе Ball должен быть реализован метод draw(Canvas canvas) в соответствии с условием задачи.
5. В классе Ball должен быть реализован метод start() устанавливающий значение поля isFrozen в false.
6. Модификатор доступа поля x в классе BaseObject должен быть изменен на protected.
7. Модификатор доступа поля y в классе BaseObject должен быть изменен на protected.
8. Модификатор доступа поля radius в классе BaseObject должен быть изменен на protected.
Арканоид(13)
Класс Ball уже посложнее — шарик же двигается.
Нам понадобятся приватные поля:
а) speed (скорость шарика) типа double;
б) direction (направление движения в градусах: от 0 до 360) типа double;
в) dx (расстояние по x, которое проходит шарик за один шаг. вычисляется на основе speed и direction) типа double;
г) dy (расстояние по y, которое проходит шарик за один шаг. вычисляется на основе speed и direction) типа double;
д) isFrozen («истина» если шарик «заморожен» — не двигается) типа boolean.
Не забудь добавить геттеры для всех полей этого класса, кроме isFrozen (его мы будем использовать только внутри класса Ball).
А еще сделай-ка конструктор:
а) параметры — x, y, speed, direction;
б) радиус (для вызова родительского класса) всегда равен 1;
в) не забудь установить isFrozen в true — в начале игры шарик никуда не летит.
Требования:
1. Приватное поле speed типа double должно быть создано в классе Ball.
2. Приватное поле direction типа double должно быть создано в классе Ball.
3. Приватное поле dx должно типа double быть создано в классе Ball.
4. Приватное поле dy должно типа double быть создано в классе Ball.
5. Приватное поле isFrozen типа boolean должно быть создано в классе Ball.
6. В классе Ball должен существовать корректный публичный геттер для поля speed.
7. В классе Ball должен существовать корректный публичный геттер для поля direction.
8. В классе Ball должен существовать корректный публичный геттер для поля dx.
9. В классе Ball должен существовать корректный публичный геттер для поля dy.
10. В классе Ball должен быть создан публичный конструктор (поведение и параметры описаны в условии).
Арканоид(12)
Теперь напишем класс Brick.
Во-первых займемся конструктором и в нем точно зададим «радиус» всех кирпичей.
Пусть он выглядит так:
public Brick(double x, double y) {
  super(x, y, 3);
}
Еще нам нужно переопределить два метода move() и draw(Canvas canvas).
Метод move() не делает ничего (не содержит кода), т.к. кирпич никуда не двигается.
Напиши еще метод draw(Canvas canvas).
Его кодом я займусь сам.
Требования:
1. Конструктор класса Brick должен принимать два параметра типа double и вызывать конструктор класса родителя с фиксированным третьим параметром (радиусом) равным 3.
2. В классе Brick должен существовать метод move без параметров.
3. В классе Brick должен существовать метод draw с одним параметром типа Сanvas.
Арканоид(11)
Еще Canvas понадобится два метода, напиши их.
а) метод clear()
Этот метод будет очищать матрицу, чтобы на ней снова можно было рисовать.
Можешь просто заново инициализировать matrix пустым массивом правильной размерности.
б) метод print()
Этот метод рисует матрицу на экран.
Тут уже ты должен сам разобраться: вывести набор символов не так уж и сложно.
Требования:
1. В классе Canvas должен быть создан метод void clear() без параметров.
2. В классе Canvas должен быть создан метод void print() без параметров.
3. Метод clear должен очищать массив matrix.
4. Метод print должен выводить на экран содержимое массива matrix.
Арканоид(10)
Что мы будем делать с Canvas?
Мы будем рисовать на нем (в его матрице).
Поэтому нам понадобятся два метода
void setPoint(double x, double y, char c)
void drawMatrix(double x, double y, int[][] matrix, char c)
Первый метод — setPoint будет «ставить точку в координатах x,y цветом c«.
В методе надо:
а) округлить x и y до целых чисел
б) занести в matrix[y][x] значение с
в) ничего не делать, если x < 0 или y < 0 или y > matrix.length или x > matrix[0].length
Второй метод — drawMatrix копирует переданную ему картинку (матрицу) в матрицу Canvas.
И не просто копирует, а начиная с координат x, y
В методе надо:
а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки
б) если значение ячейки элемента [i][j] полученной матрицы не равно 0, то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:
setPoint(x+j, y+i, c)
Требования:
1. В классе Canvas должен быть создан метод void setPoint(double x, double y, char c).
2. В классе Canvas должен быть создан метод void drawMatrix(double x, double y, int[][] matrix, char c).
3. Поведение метода setPoint должно соответствовать условию задачи.
4. Поведение метода drawMatrix должно соответствовать условию задачи.
Арканоид(9)
Теперь займемся классом Canvas.
Он у нас будет содержать матрицу (двумерный массив), куда мы будем «рисовать«.
У матрицы есть ширина и высота.
А еще будем в ней хранить не числа (int), а символы (char).
Надо:
а) Добавить в класс два приватных поля width и height.
б) Добавить в класс приватное поле matrix (char[][]).
в) Добавить конструктор с двумя параметрами типа int (width и height), поле matrix должно быть инициализировано пустым массивом размерностью [height+2][width+2].
г) Добавить геттеры и сеттеры для всех приватных полей класса.
Требования:
1. В классе Canvas должно быть создано приватное поле width типа int.
2. В классе Canvas должно быть создано приватное поле height типа int.
3. В классе Canvas должно быть создано приватное поле matrix типа char[].
4. В классе Canvas должен быть создан публичный геттер для поля width.
5. В классе Canvas должен быть создан публичный геттер для поля height.
6. В классе Canvas должен быть создан публичный геттер для поля matrix.
7. В классе Canvas должен быть создан публичный сеттер для поля width.
8. В классе Canvas должен быть создан публичный сеттер для поля height.
9. В классе Canvas должен быть создан публичный сеттер для поля matrix.
10. В классе Canvas должен быть создан корректный публичный конструктор с двумя параметрами типа int (width и height).
Арканоид(8)
Но и это еще не все.
Классу BaseObject нужны еще методы.
Пока это будут пустые методы draw(Canvas canvas) и move().
Классы-наследники должны будут переопределить их у себя и реализовать необходимую функциональность (пока можешь оставить их пустыми, просто чтобы код компилировался).
Объяви эти методы, но сделай их абстрактными.
Также сделай абстрактным сам класс BaseObject.
А еще нам нужно будет определять попал шарик в кирпич или в подставку.
Это будем делать так:
В этом же классе, создадим специальный метод: boolean isIntersec(BaseObject o)
Он будет определять — «пересеклись» объекты или нет. Если пересеклись — возвращать true, если нет — false.
Т.к. объекты мы условно считаем кругами, то предлагаю такую формулу взаимодействия
Если центр круга одного объекта попал в круг другого, то будем считать, что они столкнулись.
Или еще проще:
дистанция_между_объектами <= max (радиус_первого_объекта, радиус_второго_объекта)
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

-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;

import java.util.*;

public class Arkanoid {
    private int width, height;
    
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    
    public static Arkanoid game;
    private boolean isGameOver;
    
    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void move() {
        ball.move();
        stand.move();
    }
    
    public void checkBricksBump(){
        for (Brick brick: bricks) {
           if( ball.isIntersec(brick))
           {
               double angle = Math.random() * 360;
               ball.setDirection(angle);
               bricks.remove(brick);
               break;
           }
        }
    }
    
    public void checkStandBump(){
        if (ball.isIntersec(stand)){
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }
    
    public void  checkEndGame (){
        if(ball.getY()>height) {isGameOver = true;}
    }
    
    public void draw(Canvas canvas) {
        stand.draw(canvas);
        ball.draw(canvas);
       for (Brick brick : bricks) {
           brick.draw(canvas);
       }
    }
    
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


public abstract class BaseObject {
    
    protected double x;
    protected double y;
    
    protected double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    abstract void draw(Canvas canvas);
    abstract void move();
    boolean isIntersec(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
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
    private int width, height;
    private char[][] matrix;
    
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height+2][width+2];
    }
    
    public void setPoint(double x, double y, char c) {
        int x0 = (int) Math.round(x);
        int y0 = (int) Math.round(y);
        if (y0 < 0 || y0 >= matrix.length) return;
        if (x0 < 0 || x0 >= matrix[y0].length) return;

        matrix[y0][x0] = c;
    }    
    
    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1)
                    setPoint(x + j, y + i, c);
            }
        }
    }
    
    public void clear() { matrix = new char[height+2][width+2];}
    
    public void print() {
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public char[][] getMatrix() {
        return matrix;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public void setMatrix(char[][] newMatrix) {
        this.matrix = newMatrix;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball extends BaseObject {
    
    private double speed;
    private double direction;
    private double dx, dy;
    private boolean isFrozen;
    
    public double getSpeed() {return speed;}
    public double getDirection() {return direction;}
    public double getDx() {return dx;}
    public double getDy() {return dy;}
    
    public void setSpeed(double speed) {this.speed = speed;}
    
    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }
    
    void checkRebound(int minx, int maxx, int miny, int maxy) {
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }
    
    public void setDx(double dx) {this.dx = dx;}
    public void setDy(double dy) {this.dy = dy;}
    
    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        isFrozen = true;
    }
    
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }
    public void move() {
        if (isFrozen == false) {x += dx; y += dy;}
    }
    
    public void start() {isFrozen = false;}
    
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick extends BaseObject {
    
    public Brick(double x, double y) {
        super(x, y, 3);
    }
    public void draw(Canvas canvas) {}
    public void move() {}
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand extends BaseObject {
    
    private double speed;
    private double direction;
    
    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }
    public void draw(Canvas canvas) {}
   void move() {
        double dx = speed * direction;
        x = x + dx;
    }
    
    void moveLeft() {
        direction = -1;
    }

    void moveRight() {
        direction = 1;
    }

    
    public double getSpeed() {return speed;}
    public double getDirection() {return direction;}
}
------------------------------------------------------------------------------------------------------------------------------
*/
