
//Then Jesus came and took the bread, gave it to them, and the fish likewise. (John 21:13)


package com.javarush.task.task36.task3608.dao;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.dao.mock.DataSource;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private DataSource dataSource = DataSource.getInstance();

    public User getUserById(long id) {
        List<User> users = dataSource.getUsers();
        for (User user : users) {
            if (user.getId() == id) {
                return user.clone();
            }
        }
        return User.NULL_USER;
    }

    public List<User> getUsersByName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException();

        List<User> users = dataSource.getUsers();
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (name.equals(user.getName())) {
                addUserToResult(result, user);
            }
        }
        return result;
    }

    public List<User> getAllUsers() {
        List<User> users = dataSource.getUsers();
        List<User> result = new ArrayList<>();
        for (User user : users) {
            addUserToResult(result, user);
        }
        return result;
    }
