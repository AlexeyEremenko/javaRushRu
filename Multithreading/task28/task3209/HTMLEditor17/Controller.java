
//Then saith he unto me, See thou do it not: for I am thy fellowservant, and of thy brethren the prophets, 
//and of them which keep the sayings of this book: worship God. (Revelation 22:9)

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
    
    public void init() {}
    
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

    public static void main(String [] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}

/*
HTML Editor (17)

Добавь метод String getPlainText() в контроллер. Он должен получать текст из документа со всеми html тегами.

17.1. Создай объект StringWriter.

17.2. Перепиши все содержимое из документа document в созданный объект с помощью

метода write класса HTMLEditorKit.

17.3. Как обычно, метод не должен кидать исключений.





Требования:

1. Класс Controller должен содержать публичный метод String getPlainText(), который будет получать текст из документа со всеми html тегами.

2. В методе getPlainText() должен создаваться объект класса StringWriter.

3. Метод getPlainText() должен вызывать метод write() у объекта HTMLEditorKit.

4. Если в методе getPlainText() возникнет исключительная ситуация, то исключение должно логироваться через метод log у класса ExceptionHandler.
*/
