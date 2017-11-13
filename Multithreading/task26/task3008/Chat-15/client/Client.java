
//And you are puffed up, and have not rather mourned, that he that has done this deed might be taken away from among you. (1Cor 5:2)

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
    } 
}

/*
Чат (15)
Напишем реализацию класса SocketThread. Начнем с простых вспомогательных методов.

Добавь методы, которые будут доступны классам потомкам и не доступны остальным классам вне пакета:
1) void processIncomingMessage(String message) – должен выводить текст message в консоль.
2) void informAboutAddingNewUser(String userName) – должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату.
3) void informAboutDeletingNewUser(String userName) – должен выводить в консоль, что участник с именем userName покинул чат.
4) void notifyConnectionStatusChanged(boolean clientConnected) – этот метод должен:
а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
б) Оповещать (пробуждать ожидающий) основной поток класса Client.

Подсказка: используй синхронизацию на уровне текущего объекта внешнего класса и метод notify. Для класса SocketThread внешним классом является класс Client.


Требования:
1. Метод processIncomingMessage должен выводить на экран сообщение полученное в качестве параметра.
2. Метод informAboutAddingNewUser должен выводить на экран сообщение о том что пользователь подключился к чату.
3. Метод informAboutDeletingNewUser должен выводить на экран сообщение о том что пользователь покинул чат.
4. Метод notifyConnectionStatusChanged должен устанавливать значение поля clientConnected внешнего объекта Client равным полученному параметру.
5. Метод notifyConnectionStatusChanged должен вызвать метод notify на внешнем объекте Client.
*/
