
//But he that is spiritual judges all things, yet he himself is judged of no man. (1Cor 2:15)

package com.javarush.task.task36.task3608.model;


public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}
