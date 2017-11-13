
//For though you have ten thousand instructors in Christ, yet have you not many fathers: for in Christ Jesus I have begotten you through the gospel. (1Cor 4:15)

package com.javarush.task.task30.task3008;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    
    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Something wrong with sending message...");
            }
        }
    }
    
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Please, input server port: ");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server starting...");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Error, server socket was closed.");
        }
    }
    
    private static class Handler extends Thread {
        private Socket socket;
        
        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}

/*
Чат (7)
Т.к. сервер может одновременно работать с несколькими клиентами, нам понадобится
метод для отправки сообщения сразу всем.

Добавь в класс Server:
1. Статическое поле Map<String, Connection> connectionMap, где ключом будет имя
клиента, а значением — соединение с ним.
2. Инициализацию поля из п.7.1 с помощью подходящего Map из библиотеки
java.util.concurrent, т.к. работа с этим полем будет происходить из разных потоков и
нужно обеспечить потокобезопасность.
3. Статический метод void sendBroadcastMessage(Message message), который должен
отправлять сообщение message всем соединениям из connectionMap. Если при
отправке сообщение произойдет исключение IOException, нужно отловить его и
сообщить пользователю, что не смогли отправить сообщение.


Требования:
1. В классе Server должно существовать статическое приватное поле connectionMap типа Map.
2. Поле connectionMap должно быть инициализировано потокобезопасной реализаций интерфейса Map из пакета java.util.concurrent.
3. В классе Server должен быть корректно реализован статический метод sendBroadcastMessage(Message message), отправляющий сообщение всем соединениям из connectionMap.
*/
