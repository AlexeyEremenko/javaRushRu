
//But all these things will they do to you for my name's sake, because they don't know him who sent me.(John 15:21)

package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {

    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    public void menuSelected(MenuEvent e) {
        JMenu menu = (JMenu) e.getSource();
        Component[] components = menu.getMenuComponents();
        for (Component component : components){
            component.setEnabled(view.isHtmlTabSelected());
        }
    }

    public void menuDeselected(MenuEvent e) {}

    public void menuCanceled(MenuEvent e) {}
}

/*
HTML Editor (13)

Реализуем класс TextEditMenuListener в пакет listeners. Этот класс будет работать аналогично классу UndoMenuListener только для других пунктов меню. Пункты меню, отвечающие за стиль, шрифт, цвет и т.д. должны быть доступны только тогда, когда в нашем редакторе выбрана первая вкладка.

13.1. Добавь в представление метод boolean isHtmlTabSelected(). Он должен возвращать true, если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).

13.2. Добавь в класс TextEditMenuListener поле View, проинициализируй его в конструкторе класса.

13.3. В классе TextEditMenuListener переопредели метод menuSelected(MenuEvent menuEvent). Он должен:

13.3.1. Из переданного параметра получать объект, над которым было совершено действие. В нашем случае это будет объект с типом JMenu.

13.3.2. У полученного меню получать список компонентов (пунктов меню).

13.3.3. Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра результат вызова метода isHtmlTabSelected() из представления. Запусти приложение и убедись, что пункты меню стиль, выравнивание, цвет и шрифт доступны только, когда активна закладка HTML и не доступны для закладки Текст.





Требования:

1. Класс View должен содержать публичный метод boolean isHtmlTabSelected(), определяющий текущую вкладку.

2. Класс TextEditMenuListener должен содержать поле View view.

3. Конструктор класса TextEditMenuListener(View view) должен инициализировать поле view.

4. Метод menuSelected(MenuEvent menuEvent) класса TextEditMenuListener должен устанавливать доступность пунктов меню стиль, выравнивание, цвет и шрифт в зависимости от выбранной вкладки.


*/
