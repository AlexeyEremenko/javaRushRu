package com.springvalidation.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Jesus Lord Almighty
 * at 19.01.18
 */

@Entity
public class MessageEntity {

    @Id
    private String data;
    private String password;
    private String time;
    private String author;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}