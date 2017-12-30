
//And the gates of it shall not be shut at all by day: for there shall be no night there. (Revelation 21:25)

package com.javarush.task.task22.task2213;

import java.awt.event.KeyEvent;

/**
 * Класс Tetris - содержит основной функционал игры.
 */
public class Tetris {
    private Field field;                //Поле с клетками
    private Figure figure;              //Фигурка

    private boolean isGameOver;         //Игра Окончена?

    public Tetris(int width, int height) {
        field = new Field(width, height);
        figure = null;
    }

    /**
     * Геттер переменной field.
     */
    public Field getField() {
        return field;
    }

    /**
     * Геттер переменной figure.
     */
    public Figure getFigure() {
        return figure;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() throws Exception {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //выставляем начальное значение переменной "игра окончена" в ЛОЖЬ
        isGameOver = false;
        //создаем первую фигурку посередине сверху: x - половина ширины, y - 0.
        figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0);

        //пока игра не окончена
        while (!isGameOver) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                //получить самое первое событие из очереди
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;
                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    figure.left();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    figure.right();
                    //Если  код клавиши равен 12 ("цифра 5 на доп. клавиатуре") - повернуть фигурку
                else if (event.getKeyCode() == 12)
                    figure.rotate();
                    //Если "пробел" - фигурка падает вниз на максимум
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    figure.downMaximum();
            }

            step();             //делаем очередной шаг
            field.print();      //печатаем состояние "поля"
            Thread.sleep(300);  //пауза 300 миллисекунд - 1/3 секунды
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over");
    }

    /**
     * Один шаг игры
     */
    public void step() {
            //опускаем фигурку вниз
            figure.down();

            //если разместить фигурку на текущем месте невозможно
            if (!figure.isCurrentPositionAvailable()) {
                figure.up();                    //поднимаем обратно
                figure.landed();                //приземляем

                isGameOver = figure.getY() <= 1;//если фигурка приземлилась на самом верху - игра окончена

                field.removeFullLines();        //удаляем заполненные линии

                figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0); //создаем новую фигурку
            }

    }

    /**
     * Сеттер для figure
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    /**
     * Сеттер для field
     */
    public void setField(Field field) {
        this.field = field;
    }

    public static Tetris game;

    public static void main(String[] args) throws Exception {
        game = new Tetris(10, 20);
        game.run();
    }
}

/*
Тетрис(15)

Напиши реализацию метода step в классе Tetris.

В методе надо переместить фигурку вниз на один шаг.



Если после перемещения положить фигурку на текущее место невозможно, то:

а) поднять ее обратно (up)

б) "приземлить" ее (landed)

в) удалить все "полные линии" в объекте field

г) создать новую фигурку взамен старой.





Требования:

1. В методе step класса Tetris необходимо переместить на 1 шаг вниз текущую фигуру.

2. В методе step класса Tetris необходимо вызвать метод up у текущей фигуры, если ее дальнейшее перемещение невозможно.

3. В методе step класса Tetris необходимо вызвать метод landed у текущей фигуры, если ее дальнейшее перемещение невозможно.

4. В методе step класса Tetris необходимо удалить все полные строки, если дальнейшее перемещение текущей фигуры невозможно.

5. В методе step класса Tetris необходимо создать новую случайную фигуру(метод createRandomFigure) и сохранить ее в поле figure, если дальнейшее перемещение текущей фигуры невозможно.
*/