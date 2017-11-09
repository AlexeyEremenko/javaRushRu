
//But God has revealed them unto us by his Spirit: for the Spirit searches all things, yea, the deep things of God. (1Cor 2:10)

package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Human {
    
    private double averageGrade;
    private String university;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }
    

    public void live() {
        learn();
    }

    public void learn() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Студент: " + name);
    }

    public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }

    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }

    public void setBeginningOfSession(int day, int month, int year) {
        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
    }

    public double getAverageGrade() {
        return averageGrade;
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
