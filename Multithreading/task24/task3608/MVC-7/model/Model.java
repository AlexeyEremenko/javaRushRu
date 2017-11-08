
//John testified about him. He cried out, saying, "This was he of whom I said, 'He who comes after me has surpassed me, for he was before me.'" (John 1:15)

package com.javarush.task.task36.task3608.model;


public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
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
