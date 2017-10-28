
//But you have a custom, that I should release someone to you at the Passover. Therefore do you want me to release to you the King of the Jews?" (John 18:39)

------------------------------------------------Solution.java-----------------------------------------------------------
package com.javarush.task.task20.task2007;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/* 
Как сериализовать JavaRush?
*/
public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
------------------------------------------------------------------------------------------------------------------------



--------------------------------------------------User.java-------------------------------------------------------------
package com.javarush.task.task20.task2007;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }
}
------------------------------------------------------------------------------------------------------------------------






/*
Как сериализовать JavaRush?
Сделай так, чтобы сериализация класса JavaRush была возможной.


Требования:
1. Класс JavaRush должен существовать внутри класса Solution.
2. Класс JavaRush должен быть статическим.
3. Класс JavaRush должен быть публичным.
4. Класс JavaRush должен поддерживать интерфейс Serializable.


------------------------------------------------Solution.java-----------------------------------------------------------
package com.javarush.task.task20.task2007;

import java.util.ArrayList;
import java.util.List;

/* 
Как сериализовать JavaRush?
*/
public class Solution {
    public static class JavaRush {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
------------------------------------------------------------------------------------------------------------------------



--------------------------------------------------User.java-------------------------------------------------------------
package com.javarush.task.task20.task2007;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }
}
------------------------------------------------------------------------------------------------------------------------

*/
