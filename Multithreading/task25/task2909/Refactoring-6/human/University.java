
//Now he that plants and he that waters are one: and every man shall receive his own reward according to his own labor. (1Cor 3:8)

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

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {    //TODO:
            if (student.getAverageGrade() == averageGrade) {return student;}
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxGrade = 0; 
        for (Student student : students) {   //TODO:
            if (student.getAverageGrade() > maxGrade) {maxGrade = student.getAverageGrade();}
        }
        return getStudentWithAverageGrade(maxGrade);
    }

    public Student getStudentWithMinAverageGrade(){
        double minGrade = students.get(0).getAverageGrade(); 
        for (Student student : students) {   //TODO:
            if (student.getAverageGrade() < minGrade) {minGrade = student.getAverageGrade();}
        }
        return getStudentWithAverageGrade(minGrade);
    }

    public void expel(Student student) {
        students.remove(student);
    }
    
    public String getName() {return name;}
    
    public void setName(String name) {this.name = name;}
    
    public int getAge() {return age;}
    
    public void setAge(int age) {this.age = age;}
}

/*
Рефакторинг (6)
6.1. Замена параметра набором специализированных методов. Замени метод setValue() класса
Student специализированными методами setCourse и setAverageGrade.
6.2. Добавление параметра. Добавить параметр с типом double в метод getStudentWithAverageGrade(), чтобы было понятно с каким средним балом нужен студент.
Реализуй метод getStudentWithAverageGrade().
6.3. Удаление параметра. Убери параметр из метода getStudentWithMaxAverageGrade().
Реализуй этот метод, он должен возвращать студента с максимальным средним балом.
6.4. Разделение запроса и модификатора. Раздели метод getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade() и void expel(Student student). Первый метод должен возвратить студента с минимальным средним балом, а второй — отчислить переданного студента (удалять из списка students).


Требования:
1. Необходимо заменить метод setValue класса Student специализированными методами setCourse и setAverageGrade.
2. Необходимо добавить параметр с типом double в метод getStudentWithAverageGrade() класса University и реализовать метод.
3. Необходимо удалить параметр из метода getStudentWithMaxAverageGrade(double) класса University и реализовать метод.
4. Необходимо разделить метод getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade() и void expel(Student student) и реализовать эти два метода.
*/
