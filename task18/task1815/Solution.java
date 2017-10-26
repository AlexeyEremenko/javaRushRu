
//Jesus therefore, knowing all the things that were happening to him, went forth, and said to them, "Who are you looking for?" (John 18:4)


package com.javarush.task.task18.task1815;

import java.util.List;
import javax.smartcardio.ATR;

/* 
Таблица
*/


public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {

        ATableInterface component;

        TableInterfaceWrapper (ATableInterface atable) {
            this.component = atable;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            this.component.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return this.component.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            this.component.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}




/*
Таблица
Измени класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для ATableInterface.
Метод setModel должен вывести в консоль количество элементов в новом листе перед обновлением модели.
Метод getHeaderText должен возвращать текст в верхнем регистре — используйте метод toUpperCase().


Требования:
1. Класс TableInterfaceWrapper должен реализовывать интерфейс ATableInterface.
2. Класс TableInterfaceWrapper должен инициализировать в конструкторе поле типа ATableInterface.
3. Метод setModel() должен вывести в консоль количество элементов в новом листе перед обновлением модели.
4. Метод getHeaderText() должен возвращать текст в верхнем регистре.
5. Метод setHeaderText() должен устанавливать текст для заголовка без изменений.


package com.javarush.task.task18.task1815;

import java.util.List;

* 
Таблица
*

public class Solution {
    public class TableInterfaceWrapper {

    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}


*/
