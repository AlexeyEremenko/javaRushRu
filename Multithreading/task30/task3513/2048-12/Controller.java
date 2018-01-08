
//One of the two who heard John, and followed him, was Andrew, Simon Peter's brother. (John 1:40)

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
2048 (12)

Ну что, попробуем наш алгоритм в действии? Осталось добавить сохранение игрового состояния в начало каждого метода движения, а также еще один кейс для обработки клавиши, которой будем выполнять отмену последнего хода.



При сохранении текущего состояния в стек, обрати внимание на то, чтобы всегда сохранялось актуальное состояние и только однажды. Если ты послушал мой совет и реализовал методы right, up, down с помощью поворотов и вызова метода left, можешь использовать следующий подход:

1. В самом начале методов right, up, down вызываем метод saveState с gameTiles в качестве параметра.

2. В методе left организуем проверку того, вызывался ли уже метод saveState. За это у нас отвечает флаг isSaveNeeded, соответственно, если он равен true, выполняем сохранение. После выполнения сдвига влево устанавливаем флаг isSaveNeeded равным true.



Также добавим в метод keyPressed класса Controller вызов метода rollback по нажатию на клавишу Z (код - KeyEvent.VK_Z).





Требования:

1. Метод keyPressed класса Controller должен вызывать метод rollback у модели в случае, если была нажата клавиша с кодом KeyEvent.VK_Z.

2. Метод left должен один раз сохранять текущее игровое состояние и счет в соответствующие стеки.

3. Метод right должен один раз сохранять текущее игровое состояние и счет в соответствующие стеки.

4. Метод up должен один раз сохранять текущее игровое состояние и счет в соответствующие стеки.

5. Метод down должен один раз сохранять текущее игровое состояние и счет в соответствующие стеки.
*/
