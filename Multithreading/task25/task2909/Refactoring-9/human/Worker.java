
//He is the one who comes after me, who is preferred before me, whose sandal strap I'm not worthy to loosen." (John 1:27)

package com.javarush.task.task29.task2909.human;

public class Worker extends Human {
    
    private double salary;
    private String company;

    public Worker(String name, int age) {
        super(name, age);
    }

    public void live() {
        
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
/*
Рефакторинг (9)
9.1. Самоинкапсуляция поля. Перепиши метод incAverageGrade() используя сеттер и геттер для доступа к averageGrade.
9.2. Замена поля-массива объектом. Замени массив int[] size объектом нового типа Size,
содержащим публичные поля: рост int height и вес int weight. Публичный класс Size объяви
внутри класса Human.
9.3. Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для него.
9.4. Замена кодирования типа классом.
9.4.1. Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
9.4.4. Примени в классе Human новый тип BloodGroup.


Требования:
1. Необходимо изменить метод incAverageGrade() класса Student с использованием сеттера и геттера для доступа к averageGrade.
2. Необходимо заменить массив int[] size класса Human объектом нового типа Size.
3. Необходимо изменить модификатор доступа поля company в классе Worker на приватный. Необходимо добавить сеттер и геттер для этого поля.
4. Необходимо создать публичный класс BloodGroup внутри пакета human.
5. Необходимо добавить в класс BloodGroup константное поле int code, приватный конструктор, принимающий int и инициализирующий поле code, геттер для поля класса.
6. Необходимо добавить в класс BloodGroup статические методы first(), second(), third() и fourth(), создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
7. Необходимо изменить тип поля bloodGroup класса Human на BloodGroup, обновить сеттер и геттер.
8. Необходимо удалить из класса Human константы: FIRST, SECOND, THIRD, FOURTH.
*/
