package com.springvalidation.util;

import com.springvalidation.model.entity.Book;
import com.springvalidation.model.entity.MessageEntity;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Jesus Lord Almighty
 * at 19.01.18
 */

@Stateless
public class DBManager {

    @PersistenceContext(name= "PU")
    private EntityManager entityManager;

    public List<Book> getAllBooks(){
        Query query = entityManager.createQuery("select entity from Book entity");
        if (query.getResultList() == null) {return Collections.emptyList();}
        List<Book> list = query.getResultList();
        return list;
    }

    public boolean createMessage(String data){
        if(StringUtils.isEmpty(data.trim())){
            return false;
        }

        MessageEntity messageEntity = entityManager.find(MessageEntity.class, data.trim());
        if(messageEntity != null){
            return false;
        }

        messageEntity = new MessageEntity();
        Date date = new Date();
        long time = date.getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        SimpleDateFormat format = new SimpleDateFormat("dd MMM hh:mm:ss");

        messageEntity.setData(data.trim());
        messageEntity.setTime(format.format(calendar.getTime()));
        messageEntity.setAuthor("user: ");
        messageEntity.setPassword(generateColor());
        entityManager.persist(messageEntity);

        return true;
    }

    public List<MessageEntity> getAllMessages(){
        Query query = entityManager.createQuery("select entity from MessageEntity entity");

        List<MessageEntity> rl = query.getResultList();
        List<MessageEntity> reverse = new ArrayList<MessageEntity>();

        for (MessageEntity message: rl) {
            reverse.add(0, message);
        }
        return reverse;
    }

    int i = 0;
    public String generateColor() {
        i++;
        if (i%2==0) {return "#7fffd4";}
        return "#ffe4c4";
    }
}
