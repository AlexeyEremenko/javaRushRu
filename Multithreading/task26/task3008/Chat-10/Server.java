
//Now some are puffed up, as though I would not come to you. (1Cor 4:18)

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
        
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();

                if (answer.getType() == MessageType.USER_NAME) {

                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }
        
        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }
        
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message != null && message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error: something wrong");
                }
            }
        }
    }
}

/*
Чат (10)
Этап третий – главный цикл обработки сообщений сервером.
Добавь приватный метод void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException, где значение параметров такое же, как и у метода
sendListOfUsers.

Он должен:
1. Принимать сообщение клиента
2. Если принятое сообщение – это текст (тип TEXT), то формировать новое текстовое сообщение путем конкатенации: имени клиента, двоеточия, пробела и текста сообщения. Например, если мы получили сообщение с текстом «привет чат» от пользователя «Боб«, то нужно сформировать сообщение «Боб: привет чат«.
3. Отправлять сформированное сообщение всем клиентам с помощью метода sendBroadcastMessage.
4. Если принятое сообщение не является текстом, вывести сообщение об ошибке
5. Организовать бесконечный цикл, внутрь которого перенести функционал пунктов 10.1-10.4.


Требования:
1. В классе Handler должен быть создан метод private void serverMainLoop(Connection connection, String userName).
2. Метод serverMainLoop должен в бесконечном цикле получать сообщения от клиента (используя метод receive класса Connection).
3. Если сообщение, полученное методом serverMainLoop, имеет тип MessageType.TEXT, то должно быть отправлено новое сообщение всем участникам чата используя метод sendBroadcastMessage (форматирование сообщения описано в условии).
4. Если сообщение, полученное методом serverMainLoop, имеет тип отличный от MessageType.TEXT, метод sendBroadcastMessage не должен быть вызван.
*/
