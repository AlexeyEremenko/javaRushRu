
//He first findeth his own brother Simon, and saith unto him, We have found the Messias, which is, being interpreted, the Christ. (John 1:41)

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
2048 (13)

Твой прогресс впечатляет! Для разнообразия, предлагаю дать игре возможность самостоятельно

выбирать следующий ход.



Начнем с простого, реализуем метод randomMove в классе Model, который будет вызывать один из методов движения случайным образом. Можешь реализовать это вычислив целочисленное n = ((int) (Math.random() * 100)) % 4.

Это число будет содержать целое псевдослучайное число в диапазоне [0..3], по каждому из которых можешь вызывать один из методов left, right, up, down.



Не забудь добавить в метод keyPressed класса Controller вызов метода randomMove по нажатию на клавишу R (код - KeyEvent.VK_R).



P.S. Проверку корректности работы метода randomMove оставляю полностью под твою ответственность, проверю только наличие вызова метода Math.random().





Требования:

1. Метод keyPressed класса Controller должен вызывать метод randomMove у модели в случае, если была нажата клавиша с кодом KeyEvent.VK_R.

2. Метод randomMove должен использовать статический метод random класса Math.
*/
