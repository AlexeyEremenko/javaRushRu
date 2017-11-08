
//The Word became flesh, and lived among us. We saw his glory, such glory as of the one and only Son of the Father,
//full of grace and truth. (John 1:14)

package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.view.UsersView;
import com.javarush.task.task36.task3608.view.EditUserView;

public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;
    
    public void setModel(Model model) {this.model = model;}
    
    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }
    
    public void setUsersView(UsersView usersView) {this.usersView = usersView;}
    
    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }
    
    public void setEditUserView(EditUserView editUserView) {this.editUserView = editUserView;}
    
    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }
}

/*
MVC (7)
1. Распредели методы по классам MVC:

public void onOpenUserEditForm(long userId) {
…loadUserById(userId);
…refresh(…getModelData());
}

public void fireEventOpenUserEditForm(long id) {
…onOpenUserEditForm(id);
}

public void loadUserById(long userId) {
User user = userService.getUsersById(userId);
…setActiveUser(user);
}

!!!! Пользователь видит Вью со списком пользователей, нажимает на одного из них, запрос идет на сервер, выгребаем новые данные и отображаем другую Вью, которая относится к одному выбранному пользователю.
Учти это при реализации этого задания.

2. Добавь в метод main открытие формы редактирования для пользователя с id=126 перед вызовом метода fireEventShowDeletedUsers().

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода onOpenUserEditForm(long) и реализовать этот метод.
2. Необходимо определить правильное расположение метода fireEventOpenUserEditForm(long) и реализовать этот метод.
3. Необходимо определить правильное расположение метода loadUserById(long) и реализовать этот метод.
4. В методе main класса Solution необходимо вызвать метод открытия формы редактирования для пользователя с id=126 у объекта класса UsersView перед вызовом метода fireEventShowDeletedUsers().
5. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
6. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.

*/
