
//For what man knows the things of a man, except the spirit of man which is in him? even so the things of God knows no man, but the Spirit of God. (1Cor 2:11)

package com.javarush.task.task29.task2909.human;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Human implements Alive {
    
    public static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    
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

    public void live() {}

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

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}

/*
Рефакторинг (3)
3.1. Спуск поля. Спусти поле course в соответствующий класс. Сделай его приватным.
3.2. Спуск метода. Спусти геттер для поля course в соответствующий класс.
3.3. Извлечение интерфейса.
3.3.1. Создай интерфейс Alive (живой) в пакете human.
3.3.2. Интерфейс должен содержать метод жить live().
3.3.3. Добавь интерфейс нужному классу.
3.4. Свертывание иерархии. Избавься от класса Professor.


Требования:
1. Необходимо спустить поле course в нужный класс и сделать его приватным.
2. Необходимо спустить геттер для поля course в нужный класс.
3. Интерфейс Alive должен существовать в пакете human.
4. Интерфейс Alive должен содержать объявление метода жить live().
5. Класс Human должен поддерживать интерфейс Alive.
6. Класс Professor нужно удалить.
*/
