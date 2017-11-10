
//But as it is written, Eye has not seen, nor ear heard, neither have entered into the heart of man, the things which God has prepared for them that love him. (1Cor 2:9)

package com.javarush.task.task36.task3608.bean;

public class User implements Cloneable {
    private String name;
    private final long id;
    private int level;

    public static final User NULL_USER = new User();

    public User(String name, long id, int level) {
        this.name = name;
        this.id = id;
        this.level = level;
    }

    public User() {
        this("", 0, 0);
    }


    //methods with logic
    public boolean isNew() {
        return id == 0;
    }

    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException ignored) {
            return NULL_USER;
        }
    }

    public User clone(long newId) {
        if (this == NULL_USER) return NULL_USER;

        return new User(name, newId, level);
    }

    /////  getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", level=" + level +
                '}';
    }
}

/*
MVC (9)
Это последнее задание по MVC.

1. Следуя принципу MVC аналогично реализации предыдущих методов сделай следующее:
напиши логику обновления пользователя. После обновления должен отображаться список пользователей.

Распредели методы по классам MVC, используя следующие сигнатуры публичных методов:
void fireEventUserChanged(String name, long id, int level)
void onUserChange(String name, long id, int level)
void changeUserData(String name, long id, int level)

где name и level — это новые значения для пользователя с выбранным id.

Примечание: метод, который ты собираешься добавить в Вью нужно добавить в EditUserView.

2. Добавь в main вызов fireEventUserChanged перед вызовом метода fireEventShowDeletedUsers().

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода fireEventUserChanged(String name, long id, int level) и реализовать этот метод.
2. Необходимо определить правильное расположение метода onUserChange(String name, long id, int level) и реализовать этот метод.
3. Необходимо определить правильное расположение метода void changeUserData(String name, long id, int level) и реализовать этот метод.
4. В методе main необходимо вызвать метод fireEventUserChanged(String, long, int) перед вызовом метода fireEventShowDeletedUsers().
5. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
6. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.
*/
