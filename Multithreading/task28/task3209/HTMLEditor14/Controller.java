
//If I had not come and spoken unto them, they had not had sin: but now they have no cloke for their sin.(John 15:22)

package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
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

    public static void main(String [] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}

/*
HTML Editor (14)

14.1. Добавь в класс представления метод selectHtmlTab(). Он должен:

14.1.1. Выбирать html вкладку (переключаться на нее).

14.1.2. Сбрасывать все правки с помощью метода, который ты реализовал ранее.

14.2. Добавь в класс контроллера геттер для модели, в нашем случае это поле document.

14.3. Добавь в представление метод update(), который должен получать документ у контроллера и устанавливать его в панель редактирования htmlTextPane.

14.4. Добавь в представление метод showAbout(), который должен показывать диалоговое окно с информацией о программе. Информацию придумай сам, а вот тип сообщения должен быть JOptionPane.INFORMATION_MESSAGE.





Требования:

1. Класс View должен содержать публичный метод selectHtmlTab(), который должен выбирать вкладку и сбрасывать все правки.

2. Класс Controller должен содержать геттер для поля document.

3. Класс View должен содержать публичный метод update(), который должен устанавливать документ в панель редактирования.

4. Класс View должен содержать публичный метод showAbout(), который должен показывать диалоговое окно с информацией о программе.
*/
