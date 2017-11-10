

//I have planted, Apollos watered; but God gave the increase. (1Cor 3:6)

package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    
    private double averageGrade;
    
    private Date beginningOfSession;
    private Date endOfSession;
    
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }
    
    @Override
    public String getPosition() {return "Студент";}
    
     public int getCourse() {
        return course;
    }
    
    public void live() {
        learn();
    }

    public void learn() {
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
