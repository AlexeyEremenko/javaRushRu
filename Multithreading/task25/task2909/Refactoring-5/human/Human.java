
//Who then is Paul, and who is Apollos, but ministers by whom you believed, even as the Lord gave to every man? (1Cor 3:5)

package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Human implements Alive {
    
    public String getPosition() {return "Человек";}
    
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
    
    public void printData() {
        System.out.println(getPosition() + ": " + name);
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

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}

/*
Рефакторинг (5)
5.1. Создание шаблонного метода.
5.1.1. Добавь в класс Human метод String getPosition(), который должен возвращать строку «Человек«.
5.1.2. Переопредели этот метод в классе Student и Teacher. Метод должен возвращать «Студент» и «Преподаватель» соответственно.
5.1.3. Замени метод printData в подклассах шаблонным методом в базовом классе, использующим getPosition().
5.2. Замена делегирования наследованием. Класс Worker должен наследоваться от Human, а не содержать его.
5.3. Переименование метода. Переименуй метод setSlr, чтобы было понятно сеттером чего является этот метод.


Требования:
1. В классе Human должен существовать метод String getPosition(), который возвращает строку "Человек".
2. В классе Student переопредели метод String getPosition(), чтобы он возвращал строку "Студент".
3. В классе Teacher переопредели метод String getPosition(), чтобы он возвращал строку "Преподаватель".
4. Необходимо заменить метод printData() в классе Student на метод printData() в классе Human. Используй getPosition().
5. Необходимо заменить метод printData() в классе Teacher на метод printData() в классе Human. Используй getPosition().
6. Класс Worker должен наследоваться от класса Human, а не содержать его.
7. В классе Worker необходимо переименовать метод setSlr(double) на setSalary(double).
*/
