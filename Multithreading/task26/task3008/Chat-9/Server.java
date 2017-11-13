
//For this cause have I sent unto you Timothy, who is my beloved son, and faithful in the Lord, who shall bring you into remembrance of my ways which are in Christ, as I teach everywhere in every church. (1Cor 4:17)

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
    }
}

/*
Чат (9)
Этап второй, но не менее важный – отправка клиенту (новому участнику) информации об
остальных клиентах (участниках) чата.

Для этого:
1) Добавь приватный метод void sendListOfUsers(Connection connection, String userName) throws IOException, где connection – соединение с участником, которому будем слать информацию, а userName – его имя. Метод должен:
2) Пройтись по connectionMap.
3) У каждого элемента из п.2 получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем.
4) Отправить сформированную команду через connection.
5) Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе.


Требования:
1. В классе Handler должен быть создан метод private void sendListOfUsers(Connection connection, String userName).
2. Метод sendListOfUsers должен отправлять через connection сообщение о том, что был добавлен пользователь с именем name для каждого имени из connectionMap.
3. Метод sendListOfUsers НЕ должен отправлять сообщение о добавлении пользователя, если имя пользователя совпадает со вторым параметром метода (userName).
*/
