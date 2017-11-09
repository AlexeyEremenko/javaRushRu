
//Now we have received, not the spirit of the world, but the Spirit who is of God; 
//that we might know the things that are freely given to us of God (1Cor 2:12)

package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Human {
    
    private double averageGrade;
    private String university;
    private Date beginningOfSession;
    private Date endOfSession;
    
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }
    
     public int getCourse() {
        return course;
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
