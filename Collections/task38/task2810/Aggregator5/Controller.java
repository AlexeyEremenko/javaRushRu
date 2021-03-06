
//If I have told you earthly things, and ye believe not, how shall ye believe, if I tell you of heavenly things? (John 3:12)

package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jesus Lord Almighty
 * at 12.01.18
 */

public class Controller {

    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers.length == 0 || providers == null) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }


    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
                List<Vacancy> vacancies = new ArrayList<>();
            try {
                for (Provider provider : providers) {
                    vacancies.addAll(provider.getJavaVacancies(" "));
                }
            }catch(NullPointerException e) {if (providers == null || providers.length == 0) {vacancies = Collections.emptyList();}}

            System.out.println(vacancies.size());

    }
}

/*
Aggregator (5)

1. Добавь в интерфейс метод getVacancies(String searchString), который будет возвращать список вакансий.



2. Поправь ошибки в классе HHStrategy.



3. Вернись в метод getJavaVacancies класса Provider, реализуй его логику из расчета, что всех данных хватает.



4. Давай попробуем запустить и посмотреть, как работает наша программа.

В методе main вместо вывода на экран напиши controller.scan();

Воспользуйся подсказкой IDEA и создай метод.

Внутри метода пройдись по всем провайдерам и собери с них все вакансии, добавь их в список. Выведи количество вакансий в консоль.



5. Исправь NPE, если появляется это исключение (поставь заглушку).





Требования:

1. В интерфейсе Strategy добавь метод getVacancies(String searchString).

2. Обнови класс HHStrategy, что бы в нем не было ошибок.

3. В классе Provider реализуй логику метода getJavaVacancies.

4. В методе main вместо вывода на экран добавь вызов controller.scan(). Реализуй этот метод согласно заданию.

5. Вызов main не должен кидать NullPointerException. Поставь заглушки в необходимых местах.
*/
