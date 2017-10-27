
//When therefore I have accomplished this, and have sealed to them this fruit, I will go on by way of you to Spain. (Romans 15:28)

-----------------------------------------------------AdapterFileOutputStream.java--------------------------------------------------
package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;

    public static void main(String[] args) {

    }

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}
-----------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------AmigoStringWriter.java-------------------------------------------------------
package com.javarush.task.task19.task1902;

import java.io.IOException;

public interface AmigoStringWriter {
    void flush() throws IOException;
    void writeString(String s) throws IOException;
    void close() throws IOException;
}
-----------------------------------------------------------------------------------------------------------------------------------





/*
Адаптер
Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.


Требования:
1. AmigoStringWriter должен быть интерфейсом.
2. Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
3. Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
4. Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
5. Метод flush() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
6. Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
7. Метод close() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.

-----------------------------------------------------AdapterFileOutputStream.java--------------------------------------------------
package com.javarush.task.task19.task1902;

* 
Адаптер
*

public class AdapterFileOutputStream {

    public static void main(String[] args) {

    }

}
-----------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------AmigoStringWriter.java-------------------------------------------------------
package com.javarush.task.task19.task1902;

import java.io.IOException;

public interface AmigoStringWriter {
    void flush() throws IOException;
    void writeString(String s) throws IOException;
    void close() throws IOException;
}
-----------------------------------------------------------------------------------------------------------------------------------


*/
