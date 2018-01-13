
//And the dragon was wroth with the woman, and went to make war with the remnant of her seed,
//which keep the commandments of God, and have the testimony of Jesus Christ. (Revelation 12:17)

package com.javarush.task.task40.task4006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url){
        String host = url.getHost();
        String request = url.getFile();
        try (Socket socket = new Socket(host, 80);
             PrintStream writer = new PrintStream(socket.getOutputStream());
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            writer.print("GET " + /*"/" +*/ request + /*" HTTP/1.1" +*/ "\r\n");

            writer.print("\r\n");
            writer.flush();

            String responseLine;
            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Отправка GET-запроса через сокет

Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.

Адрес сервера и параметры для GET-запроса получи из параметра url.

Порт используй дефолтный для http (80).

Классы HttpURLConnection, HttpClient и т.д. не использовать.

Не оставляй закомементированный код.





Требования:

1. Метод getSite должен создавать объект класса Socket с правильными параметрами (String host, int port).

2. Метод getSite должен записать в OutputStream правильный запрос.

3. Метод getSite должен выводить на экран InputStream сокета.

4. Метод getSite не должен использовать HttpURLConnection или HttpClient.
*/
