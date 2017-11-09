
//And my speech and my preaching were not with enticing words of man's wisdom, but in demonstration of the Spirit and of power (1Cor 2:4)

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

    protected boolean isSoldier;

    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private int bloodGroup;
    
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

    public Human(boolean isSoldier) {
        this.isSoldier = isSoldier;
        this.id = nextId;
        nextId++;
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

    public void live() {
        if (isSoldier)
            fight();
    }

    public void fight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}

/*
Рефакторинг (1)
Пришло время немного порефакторить.
Википедия говорит: «Рефакторинг (англ. refactoring) или реорганизация кода — процесс изменения внутренней структуры программы, не затрагивающий её внешнего поведения и имеющий целью облегчить понимание её работы. В основе рефакторинга лежит последовательность небольших эквивалентных (то есть сохраняющих поведение) преобразований. Поскольку каждое преобразование маленькое, программисту легче проследить за его правильностью, и в то же время вся последовательность может привести к существенной перестройке программы и улучшению её согласованности и четкости.» Такими маленькими преобразованиями мы и будем заниматься. После каждого изменения следи за сохранностью работоспособности кода. Многие методы рефакторинга не однократно применены и проверены сообществом программистов. Получили свои названия. Каждое задание будет сопровождено названием рефакторинга. Ты всегда можешь прочитать более подробно о нем в книге Мартина Фаулера «Рефакторинг: Улучшение существующего кода«.

Начнем. Внимательно ознакомься с кодом пакета human (человек).

Задания:
1.1. Подъем поля. Подними поле children в базовый класс.
1.2. Подъем метода. Подними сеттер и геттер для children в базовый класс.
1.3. Инкапсуляция коллекции.
1.3.1. Метод getChildren должен возвращать не модифицируемое представление списка children.
1.3.2. Убери сеттер для children.
1.3.3. Добавь методы addChild(Human) и removeChild(Human). Реализуй их логику.


Требования:
1. Поле children должно быть расположено в классе Human, и не должно быть расположено в классах Teacher и Student.
2. Сеттер и геттер для поля children должны быть расположены в классе Human, и не должны быть расположены в классах Teacher и Student.
3. Метод getChildren в классе Human должен возвращать Collections.unmodifiableList(children).
4. Необходимо удалить метод setChildren из класса Human.
5. Необходимо добавить методы addChild (Human) и removeChild (Human) в класс Human, и реализовать их.
*/
