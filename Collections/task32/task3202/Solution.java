
//And in that day ye shall ask me nothing. Verily, verily, I say unto you, Whatsoever ye shall ask the Father in my name, he will give it you. (John 16:23)

package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();

        try {
            while (is.available() > 0) {
                byte[] buf = new byte[1024];
                int len = is.read(buf);
                String s = new String(buf, 0, len);
                writer.append(s);
            }
        } catch (Exception e) {
            return new StringWriter();
        }

        return writer;
    }
}

/*
Читаем из потока

Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.

Возвращаемый объект ни при каких условиях не должен быть null.

Метод main не участвует в тестировании.





Требования:

1. Публичный статический метод getAllDataFromInputStream (InputStream) должен существовать.

2. Метод getAllDataFromInputStream (InputStream) должен возвращать StringWriter.

3. Метод getAllDataFromInputStream (InputStream) должен вернуть StringWriter, который содержит все данные из переданного потока.

4. Возвращаемый объект ни при каких условиях не должен быть null.
*/
