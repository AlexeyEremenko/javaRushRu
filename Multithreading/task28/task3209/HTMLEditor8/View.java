
//These things I command you, that ye love one another. (John 15:17)

package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    
    public void init() {
        initGui();
        this.addWindowListener(new FrameListener(this));
        this.setVisible(true);
    }
    
    public void exit() {
        controller.exit();
    }
    
    public void initMenuBar() {}
    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(144, 144));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void actionPerformed(ActionEvent actionEvent) {}

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void selectedTabChanged() {}
}





/*
HTML Editor (8)
Пришло время добавить все необходимые пункты меню и написать классы действий, выполняемые при нажатии. Это довольно трудоемкая и рутинная работа, а ты отличный ученик и не хотелось бы тебя огорчать. Поэтому, в качестве бонуса ты получаешь готовый класс MenuHelper! А ты:
8.1. Напиши в пакете actions заглушки для следующих классов:
8.1.1. Класс отмены действия UndoAction. Он должен наследоваться от AbstractAction и содержать конструктор UndoAction(View view).
8.1.2. Класс возврата действия RedoAction. Требования аналогичны требованиям к UndoAction.
8.1.3. Класс StrikeThroughAction, который отвечает за стиль текста "Зачеркнутый". Унаследуй его от StyledEditorKit.StyledTextAction.
8.1.4. Класс SubscriptAction, который отвечает за стиль текста "Подстрочный знак". Его также унаследуй его от StyledEditorKit.StyledTextAction.
8.1.5. Класс SuperscriptAction. Он будет отвечать за стиль "Надстрочный знак". Добавь ему правильный родительский класс.
8.2. Напиши в пакете listeners заглушки для классов:
8.2.1. UndoMenuListener, он должен реализовывать интерфейс MenuListener и иметь конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem). Чем он будет заниматься узнаешь чуть позже.
8.2.2. TextEditMenuListener. Этот класс также должен реализовывать интерфейс MenuListener.
Добавь ему конструктор TextEditMenuListener(View view). В следующих заданиях мы рассмотрим его детальнее.


Требования:
1. Класс UndoAction должен быть создан в отдельном файле.
2. Класс RedoAction должен быть создан в отдельном файле.
3. Класс StrikeThroughAction должен быть создан в отдельном файле.
4. Класс SubscriptAction должен быть создан в отдельном файле.
5. Класс SuperscriptAction должен быть создан в отдельном файле.
6. Класс UndoMenuListener должен быть создан в отдельном файле.
7. Класс TextEditMenuListener должен быть создан в отдельном файле.
*/
