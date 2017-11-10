
//I have fed you with milk, and not with solid food: for until now you were not able to bear it, neither yet now are you able. (1Cor 3:2)

package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;
    
    public void setController(Controller controller) {this.controller = controller;}
    
    public void refresh(ModelData modelData) {
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }
        for (int i = 0; i < modelData.getUsers().size(); i++) {
            System.out.println("\t" + modelData.getUsers().get(i));
        }
        System.out.println("===================================================");
    }
    
    public void fireEventShowAllUsers() {controller.onShowAllUsers();}
    
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
