
//He that is unjust, let him be unjust still: and he which is filthy, let him be filthy still: 
//and he that is righteous, let him be righteous still: and he that is holy, let him be holy still. (Revelation 22:11)

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

    public void createNewDocument() {}
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
HTML Editor (19)

Реализуем метод actionPerformed(ActionEvent actionEvent) у представления, этот метод наследуется от интерфейса ActionListener и будет вызваться при выборе пунктов меню, у которых наше представление указано в виде слушателя событий.

19.1. Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка. По этой строке ты можешь понять какой пункт меню создал данное событие.

19.2. Если это команда "Новый", вызови у контроллера метод createNewDocument(). В этом пункте и далее, если необходимого метода в контроллере еще нет - создай заглушки.

19.3. Если это команда "Открыть", вызови метод openDocument().

19.4. Если "Сохранить", то вызови saveDocument().

19.5. Если "Сохранить как..." - saveDocumentAs().

19.6. Если "Выход" - exit().

19.7. Если "О программе", то вызови метод showAbout() у представления.

Проверь, что заработали пункты меню Выход и О программе.





Требования:

1. Метод actionPerformed(ActionEvent actionEvent) должен получать из события команду с помощью метода getActionCommand().

2. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Новый", метод должен вызывать у контроллера createNewDocument().

3. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Открыть", метод должен вызывать у контроллера openDocument().

4. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить", метод должен вызывать у контроллера saveDocument().

5. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить как...", метод должен вызывать у контроллера saveDocumentAs().

6. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Выход", метод должен вызывать у контроллера exit().

7. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "О программе", метод должен вызывать у представления showAbout().
*/
