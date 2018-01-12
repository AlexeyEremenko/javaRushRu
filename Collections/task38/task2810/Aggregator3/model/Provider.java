
//Jesus answered and said unto him, Art thou a master of Israel, and knowest not these things? (John 3:10)

package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * @author Jesus Lord Almighty
 * at 12.01.18
 */

public class Provider {

    Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString) {
        return null;
    }
}

/*
Aggregator (3)

Начиная с этого задании ты начнешь писать логику получения данных с сайта.

Эта логика будет полностью сосредоточена в классах, реализующих Strategy.



Провайдер в данном случае выступает в качестве контекста, если мы говорим о паттерне Стратегия.

В провайдере должен быть метод, который будет вызывать метод стратегии для выполнения главной операции.

Этот метод будет возвращать все java вакансии с выбранного сайта (ресурса).



1. В корне задачи создай пакет vo (value object), в котором создай класс Vacancy.

Этот класс будет хранить данные о вакансии.



2. В Provider создай метод List<Vacancy> getJavaVacancies(String searchString). Оставь пока метод пустым.



3. Что есть у вакансии?

Название, зарплата, город, название компании, название сайта, на котором вакансия найдена, ссылка на вакансию. В классе Vacancy создай соответствующие строковые поля: title, salary, city, companyName, siteName, url.



4. Создай геттеры и сеттеры для всех полей класса Vacancy.



5. В пакете model создай класс HHStrategy от Strategy.

Этот класс будет реализовывать конкретную стратегию работы с сайтом ХэдХантер (http://hh.ua/ и http://hh.ru/).





Требования:

1. В корне задачи создай пакет vo, в нем создай класс Vacancy.

2. В классе Provider создай пустой метод getJavaVacancies(String searchString), который будет возвращать список вакансий.

3. В классе Vacancy создай строковые поля: title, salary, city, companyName, siteName, url.

4. К полям в классе Vacancy создай геттеры и сеттеры.

5. В пакете model создай класс HHStrategy, который реализует интерфейс Strategy.
*/
