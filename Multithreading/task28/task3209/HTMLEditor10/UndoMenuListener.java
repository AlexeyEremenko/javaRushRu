
//If ye were of the world, the world would love his own: but because ye are not of the world, 
//but I have chosen you out of the world, therefore the world hateth you. (John 15:19)

package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UndoMenuListener implements MenuListener {

    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    public void menuSelected(MenuEvent e) {
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());
    }

    public void menuDeselected(MenuEvent e) {}

    public void menuCanceled(MenuEvent e) {}
}

/*
HTML Editor (10)

Наш редактор будет поддерживать механизм отмены/возврата (undo/redo) действий в

редакторе.

Реализуй класс UndoMenuListener. Этот слушатель будет следить за меню, а если конкретнее, то за моментом, когда меню редактирования будет выбрано пользователем. В этот момент он будет запрашивать у представления можем ли мы сейчас отменить или вернуть какое-то действие, и в зависимости от этого делать доступными или не доступными пункты меню "Отменить" и "Вернуть".

10.1. Добавь в класс UndoMenuListener следующие поля:

10.1.1. Представление View view.

10.1.2. Пункт меню "Отменить" JMenuItem undoMenuItem.

10.1.3. Пункт меню "Вернуть" JMenuItem redoMenuItem.

10.2. Реализуй конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem), он должен инициализировать поля класса.

10.3. Реализуй метод menuSelected(MenuEvent menuEvent). Он будет вызываться перед показом меню. Он должен:

10.3.1. Спрашивать у представления можем ли мы отменить действие с помощью метода boolean canUndo(). Пока у представления нет такого метода, поэтому добавь заглушку, которая всегда возвращает false.

10.3.2. Делать доступным или не доступным пункт меню undoMenuItem в зависимости от того, что нам вернуло представление.



Подсказка: используй метод setEnabled().



10.3.3. Аналогично поступи и для пункта меню redoMenuItem, добавив метод-заглушку canRedo() в представление.

Запусти программу и убедись, что пункты меню Отменить и Вернуть недоступны.





Требования:

1. Класс UndoMenuListener должен содержать поле представления View view.

2. Класс UndoMenuListener должен содержать поле JMenuItem undoMenuItem.

3. Класс UndoMenuListener должен содержать поле JMenuItem redoMenuItem.

4. Конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) должен корректно инициализировать поля класса.

5. Класс View должен содержать public boolean метод canUndo(), возвращающий false.

6. Класс View должен содержать public boolean метод canRedo(), возвращающий false.

7. Метод menuSelected(MenuEvent menuEvent) должен делать доступными или не доступными пункты меню undoMenuItem и redoMenuItem.
*/