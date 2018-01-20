package com.springvalidation;

import com.springvalidation.model.entity.MessageEntity;
import com.springvalidation.util.DBManager;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author Jesus Lord Almighty
 * at 19.01.18
 */

@Named
@SessionScoped
public class CDI implements Serializable {

    @EJB
    private DBManager dbManager;

    private String data;
    private boolean createSuccess;

    public void createMessage(){
        createSuccess = dbManager.createMessage(data);
    }

    public List<MessageEntity> getAllMessages(){
        return dbManager.getAllMessages();
    }

}
