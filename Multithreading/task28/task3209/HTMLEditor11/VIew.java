
//Remember the word that I said unto you, The servant is not greater than his lord. If they have persecuted me,
//they will also persecute you; if they have kept my saying, they will keep yours also. (John 15:20)

package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }

    public void init() {
        initGui();
        this.addWindowListener(new FrameListener(this));
        this.setVisible(true);
    }
    
    public void exit() {
        controller.exit();
    }
    
    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);

        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }
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

    public boolean canUndo() {return undoManager.canUndo();}
    public boolean canRedo() {return undoManager.canRedo();}

    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

}

/*
HTML Editor (11)

11.1. Добавь в представление поле UndoManager undoManager. Разберись для чего используется этот класс. Проинициализируй поле класса новым объектом.

11.2. Добавь класс UndoListener реализующий интерфейс UndoableEditListener в пакет listeners. Этот класс будет следить за правками, которые можно отменить или вернуть.

11.3. Добавь в класс UndoListener:

11.3.1. Поле UndoManager undoManager.

11.3.2. Конструктор, который принимает UndoManager и инициализирует поле класса.

11.3.3. Метод undoableEditHappened(UndoableEditEvent e). Он должен из переданного события получать правку и добавлять ее в undoManager.

11.4. Добавь в представление поле UndoListener undoListener, проинициализируй его используя undoManager.

11.5. Добавь в представление методы:

11.5.1. void undo() - отменяет последнее действие. Реализуй его используя undoManager.

Метод не должен кидать исключений, логируй их.

11.5.2. void redo() - возвращает ранее отмененное действие. Реализуй его по аналогии с предыдущим пунктом.

11.5.3. Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager.

11.5.4. Реализуй геттер для undoListener.

11.5.5. Добавь и реализуй метод void resetUndo(), который должен сбрасывать все правки в менеджере undoManager.





Требования:

1. Класс View должен содержать приватное поле UndoManager undoManager, которое должно быть сразу проинициализовано.

2. Класс View должен содержать приватное поле UndoListener undoListener, которое должно быть сразу проинициализовано через поле undoManager.

3. Класс View должен содержать геттер к полю UndoListener undoListener.

4. Класс View должен содержать public void метод undo().

5. Класс View должен содержать public void метод redo().

6. Реализация метода canUndo() класса View должна использовать undoManager.

7. Реализация метода canRedo() класса View должна использовать undoManager.

8. Класс View должен содержать public void метод resetUndo(), который должен сбрасывать все правки в менеджере undoManager.

9. Класс UndoListener должен быть создан в отдельном файле.

10. Класс UndoListener должен содержать приватное поле UndoManager undoManager.

11. Конструктор UndoListener(UndoManager undoManager) должен корректно инициализировать поле undoManager.

12. Метод undoableEditHappened(UndoableEditEvent e) в классе UndoListener должен из переданного события получать правку и добавлять ее в undoManager.
*/
