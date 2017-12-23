
//In the midst of the street of it, and on either side of the river, was there the tree of life, which bare twelve manner of fruits,
//and yielded her fruit every month: and the leaves of the tree were for the healing of the nations. (Revelation 22:2)

package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    
    public void init() {}
    
    public void exit() {
        controller.exit();
    }

    public void actionPerformed(ActionEvent actionEvent) {}

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}

/*
HTML Editor (2)
2.1. Добавь в контроллер и представление по методу init(), пока без реализаций. Они будут отвечать за инициализацию контроллера и представления.
2.2. Теперь напишем в классе Controller метод main(). Он должен:
2.2.1. Создавать объект представления.
2.2.2. Создавать контроллер, используя представление.
2.2.3. Устанавливать у представления контроллер.
2.2.4. Инициализировать представление.
2.2.5. Инициализировать контроллер. Контроллер должен инициализироваться после представления.
2.3. Добавь в контроллер метод exit(), он должен вызывать статический метод exit у класса
System.
2.3.1. Метод exit в классе Controller не должен быть статическим.
2.4. Добавь в представление метод exit(), он должен вызывать exit() у контроллера.


Требования:
1. Класс Controller должен содержать метод public void init().
2. Класс View должен содержать метод public void init().
3. Класс Controller должен реализовывать метод public void exit().
4. Класс View должен реализовывать метод public void exit().
5. Реализуй, согласно условию, метод public static void main(String[] args) у класса Controller.
*/
