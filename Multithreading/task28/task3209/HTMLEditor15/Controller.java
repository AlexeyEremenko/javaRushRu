
//Behold, I come quickly: blessed is he that keepeth the sayings of the prophecy of this book. (Revelation 22:7)

package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;

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
HTML Editor (15)

Добавь в контроллер метод resetDocument(), который будет сбрасывать текущий документ. Он должен:

15.1. Удалять у текущего документа document слушателя правок которые можно отменить/вернуть (найди подходящий для этого метод, унаследованный от AbstractDocument). Слушателя нужно запросить у представления (метод getUndoListener()).

Не забудь проверить, что текущий документ существует (не null).

15.2. Создавать новый документ по умолчанию и присваивать его полю document.



Подсказка: воспользуйся подходящим методом класса HTMLEditorKit.



15.3. Добавлять новому документу слушателя правок.

15.4. Вызывать у представления метод update().





Требования:

1. Класс Controller должен содержать публичный метод resetDocument(), который будет сбрасывать текущий документ.

2. Метод resetDocument() должен удалять у текущего документа document слушателя правок через метод removeUndoableEditListener().

3. Метод resetDocument() должен создавать новый документ по умолчанию через метод createDefaultDocument().

4. Метод resetDocument() должен добавлять новому документу слушателя правок через метод addUndoableEditListener().

5. Метод resetDocument() должен вызывать у представления метод update().
*/
