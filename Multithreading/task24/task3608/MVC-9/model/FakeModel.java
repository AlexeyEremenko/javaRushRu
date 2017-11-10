
//But he that is spiritual judges all things, yet he himself is judged of no man (1Cor 2:15)

package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import java.util.Arrays;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    
    public void loadUsers() {
        modelData.setUsers(Arrays.asList(new User("test1", 1, 1), new User("test2", 1, 1)));
    }            
    
    public ModelData getModelData() {return this.modelData;}
    
    public void loadDeletedUsers() {throw new UnsupportedOperationException();}
    
    public void loadUserById(long userId) {throw new UnsupportedOperationException();}
    
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }
    
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
