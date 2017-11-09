
//But we speak the wisdom of God in a mystery, even the hidden wisdom, which God ordained before the world unto our glory (1Cor 2:7)


//https://refactoring.guru/        :))

package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Human {
    
    public static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected int course;
    private List<Human> children = new ArrayList<>();

    protected int[] size;

    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private int bloodGroup;
    
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        this.children.add(human);
    }
    
    public void removeChild(Human human) {
        this.children.remove(human);
    }

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }
    

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}

/*
Рефакторинг (2)
2.1. Извлечение подкласса.
2.1.1. Добавь класс Soldier в пакет human.
2.1.2. Избавься от поля isSoldier.
2.1.3. Перенеси в Soldier необходимые методы из Human.
2.1.4. Обнови сигнатуру конструктора Human.
2.2. Подъем тела конструктора.
2.2.1. Перенеси инициализацию полей name и age в подходящее место, добавь необходимые параметры в конструктор Human.
2.2.2. Добавь конструктор в класс Soldier.


Требования:
1. Класс Soldier должен существовать в пакете human в отдельном файле. Класс Soldier должен наследоваться от класса Human.
2. В классе Human не должно быть поля isSoldier.
3. В класс Soldier из класса Human требуется перенести необходимые методы.
4. Конструктор класса Human должен принимать два параметра: String name и int age, и инициализировать соответствующие поля.
5. В классе Soldier должен быть конструктор, который принимает два параметра: String name и int age, и вызывает соответствующий конструктор суперкласса.
*/
