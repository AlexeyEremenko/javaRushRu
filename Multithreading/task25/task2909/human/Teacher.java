
//But we speak wisdom among them that are mature: yet not the wisdom of this world, nor of the princes of this world, that come to nothing (1Cor 2:6)

package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Human {
    
    private int numberOfStudents;
    private String university;

    public Teacher(String name, int age, int numberOfStudents) {
        super(false);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Преподаватель: " + name);
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
