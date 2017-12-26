
//But all these things will they do unto you for my name's sake, because they know not him that sent me.(John 15:21)

package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {

    public StrikeThroughAction() {
        super(StyleConstants.StrikeThrough.toString());
    }

    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setStrikeThrough(simpleAttributeSet, !StyleConstants.isStrikeThrough(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}

/*
HTML Editor (12)

12.1. Напиши реализацию класса RedoAction:

12.1.1. Добавь в класс поле View. Добавь его инициализацию в конструкторе.

12.1.2. Реализуй метод actionPerformed(ActionEvent actionEvent), он должен вызывать метод redo() у представления.

12.2. Напиши реализацию класса UndoAction по аналогии с RedoAction.

12.3. Изучи реализацию класса StrikeThroughAction, которую ты получил вместе с заданием и реализуй аналогичным образом классы:

12.3.1. SubscriptAction

12.3.2. SuperscriptAction

Запусти программу и убедись, что пункты меню Подстрочный знак, Надстрочный знак и Зачеркнутый работают. Пункты, отвечающие за отмену и возврат действия пока не подключены к контроллеру и мы не сможем их проверить.





Требования:

1. Класс RedoAction должен содержать поле View view.

2. Конструктор класса RedoAction(View view) должен инициализировать поле view.

3. Метод actionPerformed(ActionEvent actionEvent) класса RedoAction должен вызывать метод redo() у представления.

4. Класс UndoAction должен содержать поле View view.

5. Конструктор класса UndoAction(View view) должен инициализировать поле view.

6. Метод actionPerformed(ActionEvent actionEvent) класса UndoAction должен вызывать метод undo() у представления.

7. Конструктор без параметров класса SubscriptAction должен вызывать конструктор суперкласса с параметром StyleConstants.Subscript.

8. Метод actionPerformed(ActionEvent actionEvent) класса SubscriptAction должен использовать метод setSubscript у StyleConstants с параметрами: SimpleAttributeSet и !StyleConstants.isSubscript(mutableAttributeSet).

9. Конструктор без параметров класса SuperscriptAction должен вызывать конструктор суперкласса с параметром StyleConstants.Superscript.

10. Метод actionPerformed(ActionEvent actionEvent) класса SuperscriptAction должен использовать метод setSuperscript у StyleConstants с параметрами: SimpleAttributeSet и !StyleConstants.isSuperscript(mutableAttributeSet).


*/
