
//For I verily, as absent in body, but present in spirit, have judged already, as though I were present, concerning him that has so done this deed (1cor 5:3)

package com.javarush.task.task30.task3008.client;

import java.io.IOException;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;
import com.javarush.task.task30.task3008.Connection;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected;
    
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
    
    public void run() {
        {
            SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Thread error");
                System.exit(1);
            }
            if (clientConnected) {
                ConsoleHelper.writeMessage("Connection established. To quit, type 'exit'");
                while (clientConnected) {
                    String message = ConsoleHelper.readString();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (shouldSendTextFromConsole()) {
                            sendTextMessage(message);
                        }
                    }
                }
            } else {
                ConsoleHelper.writeMessage("Error at client side");
            }
        }
    }
    
    protected String getServerAddress() {
        String serverAddress;
        ConsoleHelper.writeMessage("Enter server address: ");
        serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }
    
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server port: ");
        return ConsoleHelper.readInt();
    }
    
    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter User name: ");
        return ConsoleHelper.readString();
    }
    
    protected boolean shouldSendTextFromConsole() {
        return true;
    }
    
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error, can't send your message...");
            clientConnected = false;
        }
    }
    
    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }
        
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("User " + userName + " joined to chat");
        }
        
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("User " + userName + " has left this chat");
        }
        
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }
        
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message message;

            while (!clientConnected) {
                try {
                    message = connection.receive();
                } catch (ClassNotFoundException e) {
                    throw new IOException("Unexpected MessageType");
                }
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else {
                    if (message.getType() == MessageType.NAME_ACCEPTED) {notifyConnectionStatusChanged(true);}
                    else throw new IOException("Unexpected MessageType");}

            }
        }
        
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message;

            while (true) {

                try {
                    message = connection.receive();
                } catch (Exception e) {
                    break;
                }
                if (message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
                else {
                    if (message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                    else {
                        if (message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                        else break;
                    }
                }

            }
            throw new IOException("Unexpected MessageType");

        }
    } 
}
/*
Чат (16)
Теперь все готово, чтобы дописать необходимые методы класса SocketThread.

1) Добавь protected метод clientHandshake() throws IOException, ClassNotFoundException. Этот метод будет представлять клиента серверу.
Он должен:
а) В цикле получать сообщения, используя соединение connection.
б) Если тип полученного сообщения NAME_REQUEST (сервер запросил имя), запросить ввод имени пользователя с помощью метода getUserName(), создать новое сообщение с типом MessageType.USER_NAME и введенным именем, отправить сообщение серверу.
в) Если тип полученного сообщения MessageType.NAME_ACCEPTED (сервер принял имя), значит сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет. Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true. После этого выйди из метода.
г) Если пришло сообщение с каким-либо другим типом, кинь исключение IOException(«Unexpected MessageType«).

2) Добавь protected метод void clientMainLoop() throws IOException, ClassNotFoundException. Этот метод будет реализовывать главный цикл обработки сообщений сервера. Внутри метода:
а) Получи сообщение от сервера, используя соединение connection.
б) Если это текстовое сообщение (тип MessageType.TEXT), обработай его с помощью метода processIncomingMessage().
в) Если это сообщение с типом MessageType.USER_ADDED, обработай его с помощью метода informAboutAddingNewUser().
г) Если это сообщение с типом MessageType.USER_REMOVED, обработай его с помощью метода informAboutDeletingNewUser().
д) Если клиент получил сообщение какого-либо другого типа, брось исключение IOException(«Unexpected MessageType«).
е) Размести код из предыдущих пунктов внутри бесконечного цикла. Цикл будет завершен автоматически если произойдет ошибка (будет брошено исключение) или поток, в котором работает цикл, будет прерван.


Требования:
1. Метод clientHandshake должен отправлять новое сообщение (MessageType.USER_NAME, getUserName()) используя connection, если тип принятого сообщения равен MessageType.NAME_REQUEST.
2. Метод clientHandshake должен вызывать метод notifyConnectionStatusChanged(true) и завершаться, если тип принятого сообщения равен MessageType.NAME_ACCEPTED.
3. Метод clientHandshake должен бросать исключение IOException, если тип принятого сообщения не MessageType.NAME_ACCEPTED или не MessageType.NAME_REQUEST.
4. Метод clientHandshake должен принимать сообщения от сервера до тех пор, пока тип сообщения равен MessageType.NAME_REQUEST.
5. Метод clientMainLoop должен принимать сообщения от сервера до тех пор, пока тип сообщения равен MessageType.TEXT, MessageType.USER_REMOVED или MessageType.USER_ADDED.
6. Метод clientMainLoop должен обрабатывать полученное сообщение с помощью метода processIncomingMessage, если тип принятого сообщения равен MessageType.TEXT.
7. Метод clientMainLoop должен обрабатывать полученное сообщение с помощью метода informAboutAddingNewUser, если тип принятого сообщения равен MessageType.USER_ADDED.
8. Метод clientMainLoop должен обрабатывать полученное сообщение с помощью метода informAboutDeletingNewUser, если тип принятого сообщения равен MessageType.USER_REMOVED.
9. Метод clientMainLoop должен бросать исключение IOException, если тип принятого сообщения не MessageType.TEXT, MessageType.USER_REMOVED или не MessageType.USER_ADDED.
10. Сигнатура метода clientHandshake должна соответствовать условию задачи.
11. Сигнатура метода clientMainLoop должна соответствовать условию задачи.

*/
