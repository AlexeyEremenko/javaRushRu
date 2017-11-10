
//Which things also we speak, not in the words which man's wisdom teaches, but which the Holy Spirit teaches; comparing spiritual things with spiritual. (1Cor 2:13)

package com.javarush.task.task36.task3608.model.service;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public interface UserService {
    public User deleteUser(long id);

    public User createOrUpdateUser(String name, long id, int level);

    public List<User> getUsersByName(String name);

    public List<User> getAllDeletedUsers();

    public List<User> getUsersBetweenLevels(int fromLevel, int toLevel);

    List<User> filterOnlyActiveUsers(List<User> allUsers);

    User getUsersById(long userId);
}
