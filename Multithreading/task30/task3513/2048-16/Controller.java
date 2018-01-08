
//Now Philip was of Bethsaida, the city of Andrew and Peter. (John 1:44)

package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private static final int WINNING_TILE = 2048;
    Model model = new Model();

    View view;

    public Controller(Model model) {
        this.view = new View(this);
        this.model = model;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
       return model.score;
    }

    public void resetGame(){
        model.score = 0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            resetGame();
        }
        if(!model.canMove()){view.isGameLost = true;}
        if(view.isGameLost == false && view.isGameWon == false){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT : model.left();break;
                case KeyEvent.VK_RIGHT : model.right();break;
                case KeyEvent.VK_UP : model.up();break;
                case KeyEvent.VK_DOWN : model.down();break;

                case KeyEvent.VK_Z : model.rollback();break;
                case KeyEvent.VK_R : model.randomMove();break;
                case KeyEvent.VK_A : model.autoMove();break;
            }
        }
        if(model.maxTile == WINNING_TILE){view.isGameWon = true;}
        view.repaint();
    }

    public View getView() {
        return view;
    }
}

/*
2048 (16)

Осталось совсем немного! У нас есть способ вычислить эффективность любого хода, а также мы можем их сравнивать между собой.



Давай реализуем метод autoMove в классе Model, который будет выбирать лучший из возможных ходов и выполнять его.



Сделаем так:

1) Создадим локальную PriorityQueue с параметром Collections.reverseOrder() (для того, чтобы вверху очереди всегда был максимальный элемент) и размером равным четырем.

2) Заполним PriorityQueue четырьмя объектами типа MoveEfficiency (по одному на каждый вариант хода).

3) Возьмем верхний элемент и выполним ход связанный с ним.



После реализации метода autoMove добавим его вызов в метод keyPressed класса Controller по нажатию на клавишу A (код - KeyEvent.VK_A).



P.S. В качестве факультативного задания можешь почитать про указатели на методы и попробовать передать аргумент в метод getMoveEfficiency используя оператор "::". Для метода left должно получиться getMoveEfficiency(this::left). Альтернативно можешь использовать внутренний анонимный класс.





Требования:

1. В методе autoMove должен быть создан объект типа PriorityQueue с размером равным четырем.

2. В методе autoMove в PriorityQueue должно быть добавлено 4 объекта типа MoveEfficiency с помощью метода offer (по одному на каждый вариант хода).

3. Метод keyPressed класса Controller должен вызывать метод autoMove у модели в случае, если была нажата клавиша с кодом KeyEvent.VK_A.

4. В методе autoMove должен быть выполнен метод move связанный с объектом MoveEfficiency полученном с помощью метода peek или poll.
*/
