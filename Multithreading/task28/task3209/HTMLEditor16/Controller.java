
//And I John saw these things, and heard them. And when I had heard and seen,
//I fell down to worship before the feet of the angel which shewed me these things. (Revelation 22:8)

package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.StringReader;

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
HTML Editor (16)

Добавь метод setPlainText(String text) в контроллер. Он будет записывать переданный текст с html тегами в документ document. При его реализации:

16.1. Сбрось документ.

16.2. Создай новый реадер StringReader на базе переданного текста.

16.3. Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в

документ document.

16.4. Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать.





Требования:

1. Класс Controller должен содержать публичный метод setPlainText(String text), который будет записывать переданный текст с html тегами в документ document.

2. Метод setPlainText(String text) должен сбрасывать документ через метод resetDocument().

3. Метод setPlainText(String text) должен создавать новый StringReader на базе переданного параметра.

4. Метод setPlainText(String text) должен вызывать метод read() у объекта HTMLEditorKit.

5. Если в методе setPlainText(String text) возникнет исключительная ситуация, то исключение должно логироваться через метод log у класса ExceptionHandler.
*/
