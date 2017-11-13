
//But I will come to you shortly, if the Lord wills, and will know, not the speech of them who are puffed up, but the power (1Cor 4:19) 

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
        
        public void run() {

            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Established a new connection to remote-socket, address: " + socket.getRemoteSocketAddress());
            }
            String userName = null;

            try (Connection connection = new Connection(socket)) {

                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("error of remote socket address data exchange");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Closed connection to remote-socket, address: "); // + socketAddress);
            }
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
Чат (11)
Пришло время написать главный метод класса Handler, который будет вызывать все
вспомогательные методы, написанные ранее. Реализуем метод void run() в классе Handler.

Он должен:
1. Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress.
2. Создавать Connection, используя поле socket.
3. Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
4. Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED). Подумай, какой метод подойдет для этого лучше всего.
5. Сообщать новому участнику о существующих участниках.
6. Запускать главный цикл обработки сообщений сервером.
7. Обеспечить закрытие соединения при возникновении исключения.
8. Отловить все исключения типа IOException и ClassNotFoundException, вывести в консоль информацию, что произошла ошибка при обмене данными с удаленным адресом.
9. После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя, мы должны удалить запись для этого имени из connectionMap и разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
10. Последнее, что нужно сделать в методе run() – вывести сообщение, информирующее что соединение с удаленным адресом закрыто.

Наш сервер полностью готов. Попробуй его запустить.


Требования:
1. Метод run должен выводить на экран сообщение о том, что было установлено соединение с удаленным адресом (используя метод getRemoteSocketAddress).
2. Метод run должен создавать новое соединение (connection) используя в качестве параметра поле socket.
3. Метод run должен вызывать метод serverHandshake используя в качестве параметра только что созданное соединение; результатом будет имя пользователя (userName).
4. Метод run должен вызывать метод sendBroadcastMessage используя в качестве параметра новое сообщение (MessageType.USER_ADDED, userName).
5. Метод run должен вызывать метод sendListOfUsers используя в качестве параметров connection и userName.
6. Метод run должен вызывать метод serverMainLoop используя в качестве параметров connection и userName.
7. Прежде чем завершиться, метод run должен удалять из connectionMap запись соответствующую userName, и отправлять всем участникам чата сообщение о том, что текущий пользователь был удален.
8. Метод run должен корректно обрабатывать исключения IOException и ClassNotFoundException.
*/
