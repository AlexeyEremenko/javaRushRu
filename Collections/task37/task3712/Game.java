
//And saith unto him, Every man at the beginning doth set forth good wine; and when men have well drunk, then that which is worse:
//but thou hast kept the good wine until now. (John 2:10)

package com.javarush.task.task37.task3712;

public abstract class Game {
    void run() {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }

    abstract void prepareForTheGame();
    abstract void playGame();
    abstract void congratulateWinner();
}

/*
Шаблонный метод
Классы Football, Basketball и Tennis описывают три популярные игры.
Спроси у своего любимого поисковика о паттерне Template method (Шаблонный метод) и сделай так, чтобы код написанный в методе main класса Solution имел смысл.
P.S. Класс Game должен быть абстрактным.
Требования:
1. Классы Football, Basketball и Tennis должны быть потомками класса Game.
2. В классе Game должны быть определены три абстрактных метода prepareForTheGame, playGame и congratulateWinner.
3. В классе Game должен быть реализован метод run, вызывающий методы prepareForTheGame, playGame и congratulateWinner в правильном порядке.
4. Класс Game должен быть абстрактным.
*/
