
//The third day, there was a marriage in Cana of Galilee. Jesus' mother was there. (John 2:1)

package com.javarush.task.task30.task3008.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGuiView {
    private final ClientGuiController controller;

    private JFrame frame = new JFrame("Чат");
    private JTextField textField = new JTextField(50);
    private JTextArea messages = new JTextArea(10, 50);
    private JTextArea users = new JTextArea(10, 10);

    public ClientGuiView(ClientGuiController controller) {
        this.controller = controller;
        initView();
    }

    private void initView() {
        textField.setEditable(false);
        messages.setEditable(false);
        users.setEditable(false);

        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(messages), BorderLayout.WEST);
        frame.getContentPane().add(new JScrollPane(users), BorderLayout.EAST);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.sendTextMessage(textField.getText());
                textField.setText("");
            }
        });
    }

    public String getServerAddress() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите адрес сервера:",
                "Конфигурация клиента",
                JOptionPane.QUESTION_MESSAGE);
    }

    public int getServerPort() {
        while (true) {
            String port = JOptionPane.showInputDialog(
                    frame,
                    "Введите порт сервера:",
                    "Конфигурация клиента",
                    JOptionPane.QUESTION_MESSAGE);
            try {
                return Integer.parseInt(port.trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Был введен некорректный порт сервера. Попробуйте еще раз.",
                        "Конфигурация клиента",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getUserName() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите ваше имя:",
                "Конфигурация клиента",
                JOptionPane.QUESTION_MESSAGE);
    }

    public void notifyConnectionStatusChanged(boolean clientConnected) {
        textField.setEditable(clientConnected);
        if (clientConnected) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Соединение с сервером установлено",
                    "Чат",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Клиент не подключен к серверу",
                    "Чат",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void refreshMessages() {
        messages.append(controller.getModel().getNewMessage() + "\n");
    }

    public void refreshUsers() {
        ClientGuiModel model = controller.getModel();
        StringBuilder sb = new StringBuilder();
        for (String userName : model.getAllUserNames()) {
            sb.append(userName).append("\n");
        }
        users.setText(sb.toString());
    }
}

/*
Чат (21)
У меня есть отличнейшая новость для тебя. Компонент представление (View) уже готов. Я добавил класс ClientGuiView. Он использует библиотеку javax.swing. Ты должен как следует разобраться в каждой строчке этого класса. Если тебе все понятно – это замечательно, если нет – обязательно найди ответы на свои вопросы с помощью дебага, документации или поиска в Интернет.

Осталось написать компонент контроллер (Controller):
1. Создай класс ClientGuiController унаследованный от Client.
2. Создай и инициализируй поле, отвечающее за модель ClientGuiModel model.
3. Создай и инициализируй поле, отвечающее за представление ClientGuiView view. Подумай, что нужно передать в конструктор при инициализации объекта.
4. Добавь внутренний класс GuiSocketThread унаследованный от SocketThread. Класс GuiSocketThread должен быть публичным. В нем переопредели следующие методы:
а) void processIncomingMessage(String message) – должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
б) void informAboutAddingNewUser(String userName) – должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
в) void informAboutDeletingNewUser(String userName) – должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
г) void notifyConnectionStatusChanged(boolean clientConnected) – должен вызывать аналогичный метод у представления.
5. Переопредели методы в классе ClientGuiController:
а) SocketThread getSocketThread() – должен создавать и возвращать объект типа GuiSocketThread.
б) void run() – должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run(). Разберись, почему нет необходимости вызывать метод run в отдельном потоке, как мы это делали для консольного клиента.
в) getServerAddress(), getServerPort(), getUserName(). Они должны вызывать одноименные методы из представления (view).
6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.
7. Реализуй метод main(), который должен создавать новый объект ClientGuiController и вызывать у него метод run().
Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что
все работает корректно.


Требования:
1. В пакете client должен быть корректно объявлен класс ClientGuiController и вложенный в него класс GuiSocketThread.
2. В классе ClientGuiController должны быть корректно объявлены и инициализированы поля перечисленные в условии задачи.
3. Метод processIncomingMessage должен быть реализован в классе GuiSocketThread в соответствии с условием задачи.
4. Метод informAboutAddingNewUser должен быть реализован в классе GuiSocketThread в соответствии с условием задачи.
5. Метод informAboutDeletingNewUser должен быть реализован в классе GuiSocketThread в соответствии с условием задачи.
6. Метод notifyConnectionStatusChanged должен быть реализован в классе GuiSocketThread в соответствии с условием задачи.
7. Метод getSocketThread в классе ClientGuiController должен возвращать новый объект типа GuiSocketThread.
8. Метод run в классе ClientGuiController должен получать объект SocketThread через метод getSocketThread и вызывать у него метод run.
9. Методы getServerAddress, getServerPort, getUserName в классе ClientGuiController должны вызывать соответствующие методы у объекта view.
10. Метод getModel в классе ClientGuiController должен возвращать значение поля model.
11. Метод main в классе ClientGuiController должен создавать новый объект типа ClientGuiController и вызывать у него метод run.
12. Класс ClientGuiController должен быть потомком класса Client.
*/
