
//According to the grace of God which is given unto me, as a wise master builder, I have laid the foundation,
//and another builds thereon. But let every man take heed how he builds thereupon. (1Cor 3:10)

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

    public void incAverageGrade(double delta) {
    setAverageGrade(getAverageGrade() + delta);
    }
    
    public void setCourse(int course) {
        this.course = course;
    }
    
    public void setAverageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
    }

    public void setBeginningOfSession(Date beginningOfSession) {
        this.beginningOfSession = beginningOfSession;
    }

    public void setEndOfSession(Date endOfSession) {
        this.endOfSession = endOfSession;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}

/*
Рефакторинг (7)
7.1. Параметризация метода. Замени методы incAverageGradeBy01() и incAverageGradeBy02() одним методом incAverageGrade(double delta).
7.2. Передача всего объекта. Перепиши метод addInfoAboutStudent(), чтобы он в качестве параметра принимал объект типа Student.
7.3. Замена параметра вызовом метода. Перепиши метод printInfoAboutStudent(), чтобы он не требовал в качестве параметра имя студента, а получал его, вызвав соответствующий метод у переданного объекта.
7.4. Замена параметров объектом. Перепиши методы setBeginningOfSession и setEndOfSession,чтобы они вместо набора параметров принимали по одному объекту даты.


Требования:
1. Необходимо заменить методы incAverageGradeBy01() и incAverageGradeBy02() класса Student одним методом incAverageGrade(double delta).
2. Необходимо изменить метод addInfoAboutStudent(String, int, double) класса StudentsDataBase, чтобы он в качестве параметра принимал объект типа Student.
3. Необходимо изменить метод printInfoAboutStudent(String, Student) класса StudentsDataBase, чтобы он не требовал в качестве параметра имя студента.
4. Необходимо изменить метод setBeginningOfSession(int, int, int) класса Student, чтобы он принимал один параметр типа Date.
5. Необходимо изменить метод setEndOfSession(int, int, int) класса Student, чтобы он принимал один параметр типа Date.
*/
