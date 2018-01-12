
//The wind bloweth where it listeth, and thou hearest the sound thereof, but canst not tell whence it cometh,
//and whither it goeth: so is every one that is born of the Spirit. (John 3:8)

package com.javarush.task.task28.task2810.model;

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
}

/*
Aggregator (1)

Пришло время немного поработать с информацией в инете. В этом задании ты будешь писать агрегатор java вакансий.

Что у нас должно быть?

Должен быть список сайтов, на которых мы ищем вакансии.

Для начала возьмем http://hh.ua/ и http://hh.ru/, потом уже добавим другие сайты поиска работы.

Это один и тот же сайт, только в разных доменах.



С чего же нужно начать реализацию? Конечно же с метода main : )

1. Создай класс Aggregator с методом main.



2. Создай пакет model, в нем создай класс Provider.

Этот класс будет обобщать способ получения данных о вакансиях.



3. Т.к. для каждого сайта будет выполняться одинаковый сценарий, то будет паттерн Стратегия. Почитай про него в инете на вики.

В пакете model создай интерфейс Strategy.

Он будет отвечать за получение данных с сайта.



4. В класс Provider добавь поле Strategy strategy. Добавь конструктор с этим полем и сеттер.





Требования:

1. Создай класс Aggregator с методом main.

2. Создай пакет model, и в нем создай класс Provider.

3. В пакете model создай интерфейс Strategy.

4. В класс Provider добавь поле Strategy strategy. Добавь конструктор с этим полем и сеттер.
*/
