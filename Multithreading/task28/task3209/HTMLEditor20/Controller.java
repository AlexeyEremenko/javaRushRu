
//	And, behold, I come quickly; and my reward is with me, to give every man according as his work shall be. (Revelation 22:12)

package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {return document;}
    
    public void init() {
        createNewDocument();
    }
    
    public void exit() {
        System.exit(0);
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        currentFile = null;
        view.resetUndo();
    }
    public void openDocument() {}
    public void saveDocument() {}
    public void saveDocumentAs() {}


    public static void main(String [] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}

/*
HTML Editor (20)

20.1. Реализуй метод создания нового документа createNewDocument() в контроллере. Он должен:

20.1.1. Выбирать html вкладку у представления.

20.1.2. Сбрасывать текущий документ.

20.1.3. Устанавливать новый заголовок окна, например: "HTML редактор". Воспользуйся методом setTitle(), который унаследован в нашем представлении.

20.1.4. Сбрасывать правки в Undo менеджере. Используй метод resetUndo представления.

20.1.5. Обнулить переменную currentFile.

20.2. Реализуй метод инициализации init() контроллера. Он должен просто вызывать метод создания нового документа.

Проверь работу пункта меню Новый.





Требования:

1. Метод createNewDocument() в контроллере должен выбирать html вкладку у представления.

2. Метод createNewDocument() в контроллере должен сбрасывать текущий документ.

3. Метод createNewDocument() в контроллере должен устанавливать новый заголовок окна.

4. Метод createNewDocument() в контроллере должен сбрасывать правки в Undo менеджере.

5. Метод createNewDocument() в контроллере должен обнулить currentFile.

6. Метод init() в контроллере должен вызывать метод создания нового документа.
*/
