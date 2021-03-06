
//But the court which is without the temple leave out, and measure it not; for it is given unto the Gentiles: and the holy city shall they tread under foot forty and two months. (Revelation 11:2)

package com.javarush.task.task33.task3310.strategy;

public interface StorageStrategy {

    boolean containsKey(Long key);
    boolean containsValue(String value);
    void put(Long key, String value);
    Long getKey(String value);
    String getValue(Long key);
}

/*
Shortener (2)

Укорачиватель Shortener будет поддерживать разные стратегии хранения данных (строк и их идентификаторов). Все эти стратегии будут наследоваться от интерфейса StorageStrategy. Почитай подробнее про паттерн Стратегия на Вики.

Наше хранилище будет оперировать двумя понятиями: ключ и значение. Ключом будет идентификатор строки, а значением сама строка.



2.1. Добавь интерфейс StorageStrategy в пакет strategy.

2.2. Добавь в интерфейс следующие методы:

2.2.1. boolean containsKey(Long key) - должен вернуть true, если хранилище

содержит переданный ключ.

2.2.2. boolean containsValue(String value) - должен вернуть true, если хранилище

содержит переданное значение.

2.2.3. void put(Long key, String value) - добавить в хранилище новую пару ключ -

значение.

2.2.4. Long getKey(String value) - вернуть ключ для переданного значения.

2.2.5. String getValue(Long key) - вернуть значение для переданного ключа.





Требования:

1. В интерфейсе StorageStrategy должен быть объявлен метод boolean containsKey(Long key).

2. В интерфейсе StorageStrategy должен быть объявлен метод boolean containsValue(String value).

3. В интерфейсе StorageStrategy должен быть объявлен метод void put(Long key, String value).

4. В интерфейсе StorageStrategy должен быть объявлен метод Long getKey(String value).

5. В интерфейсе StorageStrategy должен быть объявлен метод boolean String getValue(Long key).

6. Интерфейс StorageStrategy должен быть создан в пакете strategy.
*/
