
//All things were made through him. Without him was not anything made that has been made. (John 1:3)

package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;
    
    public void setController(Controller controller) {this.controller = controller;}
    
    public void refresh(ModelData modelData) {
        System.out.println("All users:");
        for (int i = 0; i < modelData.getUsers().size(); i++) {
            System.out.println("\t" + modelData.getUsers().get(i));
        }
        System.out.println("===================================================");
    }
    
    public void fireEventShowAllUsers() {controller.onShowAllUsers();}
    
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}

/*
MVC (5)
В сервисе есть метод, который возвращает всех удаленных пользователей. Давай их отобразим.

1. Распредели методы по классам MVC:

public void fireEventShowDeletedUsers() {
…onShowAllDeletedUsers();
}

public void onShowAllDeletedUsers() {
…loadDeletedUsers();
}

public void loadDeletedUsers() {
List<User> users = userService.getAllDeletedUsers();
}

Не забудь, что данные, полученные с сервера, необходимо положить в ModelData. А потом обновить view.
Добавь это самостоятельно в нужные методы.

2. Добавь в Solution.main вызов нового метода, который ты поместил в view.

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода fireEventShowDeletedUsers() и реализовать этот метод.
2. Необходимо определить правильное расположение метода onShowAllDeletedUsers() и реализовать этот метод.
3. Необходимо определить правильное расположение метода loadDeletedUsers() и реализовать этот метод.
4. В методе main класса Solution необходимо вызвать метод, который ты ранее реализовал в классе UsersView.
5. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
6. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.
*/
