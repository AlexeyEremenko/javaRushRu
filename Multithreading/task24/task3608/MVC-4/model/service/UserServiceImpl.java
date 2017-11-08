
//This saying therefore went out among the brothers, that this disciple wouldn't die. Yet Jesus didn't say to him that he wouldn't die, but, "If I desire that he stay until I come, what is that to you?" (John 21:23)

package com.javarush.task.task36.task3608.model.service;

import com.javarush.task.task36.task3608.Util;
import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();

    @Override
    public User deleteUser(long id) {
        User user = userDao.getUserById(id);
        Util.markDeleted(user);
        userDao.createOrUpdate(user);

        return user;
    }

    @Override
    public User createOrUpdateUser(String name, long id, int level) {
        User user = new User(name, id, level);
        return userDao.createOrUpdate(user);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }

    @Override
    public List<User> getAllDeletedUsers() {
        List<User> result = new ArrayList<>();
        for (User user : userDao.getAllUsers()) {
            if (Util.isUserDeleted(user)) {
                result.add(user);
            }
        }

        return result;
    }

    @Override
    public List<User> getUsersBetweenLevels(int fromLevel, int toLevel) {
        //it's better to get all users from DAO by one DB request, but we will use what we have
        List<User> result = new ArrayList<>();
        for (int i = fromLevel; i <= toLevel; i++) {
            result.addAll(userDao.getUsersByLevel(i));
        }

        return result;
    }

    @Override
    public List<User> filterOnlyActiveUsers(List<User> allUsers) {
        //will not change allUsers list, create new one instead of that
        List<User> result = new ArrayList<>();
        for (User user : allUsers) {
            if (User.NULL_USER != user && !Util.isUserDeleted(user)) {
                result.add(user);
            }
        }

        return result;
    }

    @Override
    public User getUsersById(long userId) {
        return userDao.getUsersById(userId);
    }
}

/*
MVC (4)
Пора заменять нашу фейковую Модель на реальную, которая будет получать данные из DataSource.
В пакет model.service я добавил сервис для работы с пользователями.
Также в корне этой задачи ты найдешь утильный класс Util.

1. Аналогично FakeModel создай модель MainModel.

2. Т.к. Модель обращается к сервисам, то в MainModel создай поле UserService userService, инициализируй объектом.

3. Реализуй логику метода loadUsers:
3.1. Достань всех пользователей между 1 и 100 уровнями. (Метод getUsersBetweenLevels(1, 100)).
3.2. Положи всех пользователей в modelData.

4. Обнови Solution.main: замени FakeModel на MainModel.
Преимущества MVC в том, что в любой момент времени легко можно заменить любую часть паттерна.


Требования:
1. Класс MainModel, реализующий интерфейс Model, должен быть создан в пакете model.
2. В классе MainModel должно быть создано и инициализировано приватное поле ModelData modelData.
3. В классе MainModel должно быть создано и инициализировано приватное поле UserService userService.
4. В классе MainModel необходимо реализовать метод getModelData.
5. Метод loadUsers класса MainModel должен быть реализован согласно условию.
6. В методе main класса Solution должен создаваться объект класса MainModel вместо объекта класса FakeModel.
*/
