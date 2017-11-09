------------------------------------------University.java-------------------------------------------------------
package com.javarush.task.task29.task2909.human;

import java.util.*;

public class University {
    
    private List<Student> students = new ArrayList<Student>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public List<Student> getStudents() {return students;}
    
    public void setStudents(List<Student> students) {this.students = students;}

    public Student getStudentWithAverageGrade() {
        //TODO:
        return null;
    }

    public Student getStudentWithMaxAverageGrade(double averageGrade) {
        //TODO:
        return null;
    }

    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
    }
    
    public String getName() {return name;}
    
    public void setName(String name) {this.name = name;}
    
    public int getAge() {return age;}
    
    public void setAge(int age) {this.age = age;}
}
----------------------------------------------------------------------------------------------------------------


-------------------------------------------UniversityPerson.java------------------------------------------------
package com.javarush.task.task29.task2909.human;


public class UniversityPerson extends Human{
    private University university;
    
    public UniversityPerson(String name, int age) {
        super(name, age);
    }
    
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
----------------------------------------------------------------------------------------------------------------


--------------------------------------------Student.java--------------------------------------------------------
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
    
     public int getCourse() {
        return course;
    }
    
    public void live() {
        learn();
    }

    public void learn() {
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
----------------------------------------------------------------------------------------------------------------


---------------------------------------------Teacher.java-------------------------------------------------------
package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends UniversityPerson {
    
    private int numberOfStudents;
    

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public void printData() {
        System.out.println("Преподаватель: " + name);
    }
}
----------------------------------------------------------------------------------------------------------------
