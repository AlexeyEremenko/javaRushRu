
//Jesus said to them, "Come and eat breakfast." None of the disciples dared inquire of him, "Who are you?" knowing that it was the Lord. (John 21:12)

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
MVC (1)
Привет! Эта задача будет на паттерн MVC — Model-View-Controller.
Мы вместе построим архитектуру используя MVC. Разберись подробно, что и почему нужно реализовывать так, как я тебе покажу.
Прочти дополнительную литературу, которую дает профессор в конце уровня.
Тебя, скорее всего, на собеседовании спросят об этом паттерне либо дадут задание, в котором нужно будет его реализовать.

Итак…
У тебя есть два пакета: bean, содержащий единственный класс User, и dao,
в котором хранится эмуляция базы данных в пакете mock и UserDao. UserDao — это уровень ДАО, т.е. уровень доступа к базе.
В нем размещают различные методы по сохранению и получению объектов из базы данных.
В реальном приложении строку private DataSource dataSource = DataSource.getInstance() не встретить.
Я реализовал DataSource в виде синглтона. В действительности, у тебя будет что-то такое:
@Autowired
private DataSource dataSource;

Фреймворк, которым ты будешь пользоваться, сам создаст объект базы данных и инициализирует поле dataSource.

Запомни, с ДАО уровнем работают сервисы. Никакие другие классы в ДАО не лезут. В сервисах описана бизнес логика.
Сервисы забирают данные из базы используя ДАО, обрабатывают их и отдают тому, кто данные запросил.
Однако не все данные хранятся в базе. Например, залогиненый пользователь будет храниться в специальном объекте — Модели.
Объект, который содержит в себе данные, необходимые для отображения информации на клиенте, называется Моделью.
Также этот объект Модель содержит ссылки на все необходимые сервисы.
Если данных для отображения очень много, то их выделяют в отдельный объект.

Напишем приложение, которое будет показывать список пользователей и что-то делать с ними, например, обновлять их данные и удалять.

1. Создай пакет model, в котором создай класс ModelData.
ModelData — это объект, который будет хранить необходимые данные для отображения на клиенте.
Создай поле с геттером и сеттером List<User> users — это будет список пользователей для отображения.

2. Используя любую модель должна быть возможность получить все необходимые данные для отображения. Поэтому в пакете model создай интерфейс Model, который должен содержать метод ModelData getModelData().

3. В пакете model создай класс FakeModel, реализующий Model. Он нам понадобится на начальном этапе.
В нем создай поле ModelData modelData, которое инициализируй объектом.

4. В интерфейсе Model создай метод void loadUsers().
Реализуй его в FakeModel: инициализируй список пользователей modelData любыми данными. Они не влияют на тестирование.

У меня такие данные:
User{name=’A’, id=1, level=1}
User{name=’B’, id=2, level=1}

Думаю, ты помнишь, что все методы интерфейса являются public-ами, поэтому модификатор указывать не нужно.
Программисты часто мОкают данные на начальном этапе. Получение реальных данных реализуется на последних этапах.
Мокать — это подменять реальные объекты на хардкоженные, тестовые данные.


Требования:
1. Класс ModelData должен быть создан в пакете model.
2. В классе ModelData должно быть создано приватное поле List users, геттер и сеттер для него.
3. Интерфейс Model должен быть создан в пакете model. В интерфейсе Model должен быть объявлен метод ModelData getModelData().
4. Класс FakeModel, реализующий интерфейс Model, должен быть создан в пакете model.
5. В классе FakeModel должно быть создано и инициализировано приватное поле ModelData modelData.
6. В интерфейсе Model должен быть объявлен метод void loadUsers().
7. Метод void loadUsers() в классе FakeModel должен инициализировать список пользователей в объекте modelData любыми данными.

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
*/
