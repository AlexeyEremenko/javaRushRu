
//He said, "I am the voice of one crying in the wilderness, 'Make straight the way of the Lord,' as Isaiah the prophet said." (John 1:23)

package com.javarush.task.task36.task3608.model;


public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
}

/*
MVC (8)
1. Следуя принципу MVC аналогично реализации предыдущих методов сделай следующее:
напиши логику удаления пользователя. После удаления должен отображаться список пользователей.

Распредели методы по классам MVC, используя следующие сигнатуры публичных методов:
void fireEventUserDeleted(long id)
void onUserDelete(long id)
void deleteUserById(long id)

Примечание: метод, который ты собираешься добавить в Вью нужно добавить в EditUserView.

2. Добавь в main вызов fireEventUserDeleted(124L) перед вызовом метода fireEventShowDeletedUsers().

3. Выполни рефакторинг класса MainModel. Теперь, когда есть удаленные пользователи, часть методов стала работать неправильно.
Почти во всех методах, где требуется список пользователей, нужно работать только с активными(живыми) пользователями.
Вынеси в отдельный приватный метод List<User> getAllUsers() получение списка всех активных пользователей.
Фильтрация активных пользователей у тебя уже есть — метод List<User> filterOnlyActiveUsers(List<User> allUsers).
Отрефактори все методы, которые используют список пользователей. Они должны использовать список живых пользователей.

4. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода fireEventUserDeleted(long) и реализовать этот метод.
2. Необходимо определить правильное расположение метода onUserDelete(long) и реализовать этот метод.
3. Необходимо определить правильное расположение метода deleteUserById(long) и реализовать этот метод.
4. В методе main класса Solution необходимо вызвать метод fireEventUserDeleted(124L) у объекта класса EditUserView перед вызовом метода fireEventShowDeletedUsers().
5. В методе main вызов методов должен происходить в такой последовательности: fireEventShowAllUsers(), fireEventOpenUserEditForm(126L), fireEventUserDeleted(124L), fireEventShowDeletedUsers().
6. Необходимо реализовать приватный метод List getAllUsers() в классе MainModel.
7. Необходимо выполнить рефакторинг: все методы класса MainModel, которые используют список пользователей, должны использовать список живых пользователей.
8. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
9. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.
*/
