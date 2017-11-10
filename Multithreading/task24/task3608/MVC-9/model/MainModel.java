
//But the natural man receives not the things of the Spirit of God: for they are foolishness unto him: neither can he know them, because they are spiritually discerned. (1Cor 2:14)

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
    
    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name, id, level);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }
}
