
//When Jesus had spoken these words, he went out with his disciples over the brook Kidron, where there was a garden, into which he and his disciples entered. (John 18:1)

-----------------------------------------------AmigoOutputStream.java---------------------------------------------------------
package com.javarush.task.task18.task1812;

import java.io.IOException;

public interface AmigoOutputStream {
    void flush() throws IOException;

    void write(int b) throws IOException;

    void write(byte[] b) throws IOException;

    void write(byte[] b, int off, int len) throws IOException;

    void close() throws IOException;
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------QuestionFileOutputStream.java--------------------------------------------------
package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    
    AmigoOutputStream component;
    
    QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }
    
    public void flush() throws IOException {
        component.flush();
    }

    public void write(int b) throws IOException {
         component.write(b);
    }

    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        if (string.equals("Д")) {
            component.close();
        }
        br.close();
    }
}
------------------------------------------------------------------------------------------------------------------------------





/*
Расширяем AmigoOutputStream
Используя шаблон проектирования Wrapper (Decorator) расширь функциональность AmigoOutputStream.
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу «Вы действительно хотите закрыть поток? Д/Н«.
2. Считайте строку.
3. Если считанная строка равна «Д«, то закрыть поток.
4. Если считанная строка не равна «Д«, то не закрывать поток.


Требования:
1. Интерфейс AmigoOutputStream изменять нельзя.
2. Класс QuestionFileOutputStream должен реализовывать интерфейс AmigoOutputStream.
3. Класс QuestionFileOutputStream должен инициализировать в конструкторе поле типа AmigoOutputStream.
4. Все методы QuestionFileOutputStream должны делегировать свое выполнение объекту AmigoOutputStream.
5. Метод close() должен спрашивать у пользователя "Вы действительно хотите закрыть поток? Д/Н".
6. Метод close() должен закрывать поток только в случае, если считает с консоли ответ "Д".


-----------------------------------------------AmigoOutputStream.java---------------------------------------------------------
package com.javarush.task.task18.task1812;

import java.io.IOException;

public interface AmigoOutputStream {
    void flush() throws IOException;

    void write(int b) throws IOException;

    void write(byte[] b) throws IOException;

    void write(byte[] b, int off, int len) throws IOException;

    void close() throws IOException;
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------QuestionFileOutputStream.java--------------------------------------------------
package com.javarush.task.task18.task1812;

import java.io.*;

* 
Расширяем AmigoOutputStream
*

public class QuestionFileOutputStream implements AmigoOutputStream {

}
------------------------------------------------------------------------------------------------------------------------------

*/
