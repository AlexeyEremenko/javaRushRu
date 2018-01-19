package com.springvalidation.model;

import com.springvalidation.model.entity.MessageEntity;
import com.springvalidation.util.DBManager;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesus Lord Almighty
 * at 19.01.18
 */

public class Index {

    @EJB
    private DBManager dbManager;

    List<Person> persons = new ArrayList<>(100);

    @NotNull(message = "data field may not be null")
    @Size(min=2, max=240)
    private String data;

    private String col1, col2, col3, col4;

    private boolean createSuccess;

    /*public void createMessage(){
        createSuccess = dbManager.createMessage(data);
    }*/

    public List<MessageEntity> getAllMessages(){
        return  dbManager.getAllMessages();
    }








    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = getAllMessages().get(0).getTime();
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = getAllMessages().get(0).getAuthor();
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = getAllMessages().get(0).getData();
    }

    public String getCol4() {
        return col4;
    }

    public void setCol4(String col4) {
        this.col4 = getAllMessages().get(0).getPassword();
    }
}
