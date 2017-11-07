
//So when they had eaten their breakfast, Jesus said to Simon Peter, "Simon, son of Jonah, do you love me more than these?" He said to him, "Yes, Lord; you know that I have affection for you." He said to him, "Feed my lambs." (John 21:15)

package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import java.util.Arrays;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    
    public void loadUsers() {
        modelData.setUsers(Arrays.asList(new User("test1", 1, 1), new User("test2", 1, 1)));
    }            
    
    public ModelData getModelData() {return this.modelData;}
}



