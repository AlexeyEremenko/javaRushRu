
//John answered them, "I baptize in water, but among you stands one whom you don't know. (John 1:26)

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

    public static void removeStudent(int index) {
        try {
            students.remove(index);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public static void findDimaOrSasha() {
        //boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals("Dima")) {
                System.out.println("Студент Dima есть в базе.");
                break;
            }
            if (students.get(i).getName().equals("Sasha")) {
                System.out.println("Студент Sasha есть в базе.");
                break;
            }
        }
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
