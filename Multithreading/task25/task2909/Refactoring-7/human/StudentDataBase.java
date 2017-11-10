
//For no other foundation can a man lay than what is laid, which is Jesus Christ. (1Cor 3:11)

package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);

    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) throws IndexOutOfBoundsException {
        students.remove(index);
    }

    public static void findDimaOrSasha() {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (!found) {
                if (students.get(i).getName().equals("Dima")) {
                    System.out.println("Студент Dima есть в базе.");
                    found = true;
                }

                if (students.get(i).getName().equals("Sasha")) {
                    System.out.println("Студент Sasha есть в базе.");
                    found = true;
                }
            }
        }
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
