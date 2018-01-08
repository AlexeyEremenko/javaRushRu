
//Then Jesus turned, and saw them following, and saith unto them, What seek ye? 
//They said unto him, Rabbi, (which is to say, being interpreted, Master,) where dwellest thou? (John 1:38)

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
2048 (10)

Пора приступить к реализации метода main в классе Main, чтобы иметь возможность наконец-то запустить игру и отдохнуть!



Метод main нам нужен только для того чтобы запустить приложение, все внутренности мы уже реализовали.

Для этого мы создадим в нем модель и контроллер, а также объект типа JFrame. Для примера я назову его game, но ты можешь выбрать любое другое имя.



У нашей игры (объекта типа JFrame) мы должны будем вызвать некоторые методы для того чтобы все корректно отображалось на экране:



game.setTitle("2048");

game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

game.setSize(450, 500);

game.setResizable(false);



game.add(controller.getView());





game.setLocationRelativeTo(null);

game.setVisible(true);



Обрати внимание на метод add в который мы передаем представление из контроллера. У нас еще нет геттера для поля view в классе Controller. Не забудь его добавить.



P.S. Результатом выполнения этого задания будет рабочая версия игры 2048, если у тебя вдруг что-то не работает, или работает не так как ожидалось, обязательно разберись и исправь прежде чем переходить к следующим задачам.





Требования:

1. В классе Controller должен быть создан корректный геттер для поля view.

2. В методе main класса Main должна быть создана новая модель и контроллер на базе этой модели.

3. В методе main класса Main должен быть создан объект типа JFrame.

4. В методе main класса Main на объекте JFrame должны быть выполнены методы перечисленные в условии задачи.
*/
