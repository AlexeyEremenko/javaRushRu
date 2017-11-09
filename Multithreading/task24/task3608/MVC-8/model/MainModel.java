
//They said therefore to him, "Who are you? Give us an answer to take back to those who sent us. What do you say about yourself?" (John 1:22)

package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;
import com.javarush.task.task36.task3608.model.ModelData;
import java.util.Arrays;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();
    
     private List<User> getAllUsers() { return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100)); }
    
    public ModelData getModelData() {
        return modelData;
    }
    
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }
    
    public void loadDeletedUsers() {
         modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }
    
    public void loadUserById(long userId) {
         User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
    
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }
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
