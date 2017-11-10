
//They asked him, "Why then do you baptize, if you are not the Christ, nor Elijah, nor the prophet?" (John 1:25)

package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Human implements Alive {
    
    public String getPosition() {return "Человек";}
    
    private static int nextId = 0;
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
        this.id = nextId;
        nextId++;
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
Рефакторинг (8)
8.1. Удаление сеттера. Удали метод setId(). Поле id должно устанавливаться только в момент
создания объекта.
8.2. Сокрытие метода (поля). Изменить область видимости поля nextId в соответствии с
областью его использования.
8.3. Замена исключения проверкой условия. Перепиши метод removeStudent(int index), чтобы
он удалял студента из списка студентов только, если он там есть. Метод не должен кидать
исключение.
8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его
работы. В методе не должны использоваться флаги типа found, воспользуйся оператором
break.


Требования:
1. Необходимо удалить метод setId(int) класса Human.
2. Необходимо изменить область видимости поля nextId класса Human с public на private.
3. Необходимо изменить метод removeStudent(int index) класса StudentsDataBase, чтобы он не бросал исключение.
4. Необходимо изменить метод findDimaOrSasha() класса StudentsDataBase, сохранив логику его работы. Из метода нужно удалить флаг boolean found и воспользоваться оператором break.

*/
