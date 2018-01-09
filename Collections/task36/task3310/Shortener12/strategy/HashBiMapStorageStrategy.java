
//And they heard a great voice from heaven saying unto them, Come up hither. And they ascended up to heaven in a cloud;
//and their enemies beheld them. (Revelation 11:12)

package com.javarush.task.task33.task3310.strategy;

// 1.needed to download external library from:   https://github.com/google/guava/wiki/Release19
// 2.name:                                       guava-19.0.jar
// 3.destination folder:                         /JavaRushTasks/4.JavaCollections/
// 4.after downloading right click on this .jar in IDEA & click "add as library"
  
import com.google.common.collect.HashBiMap; //5. this import will work after 1-4

public class HashBiMapStorageStrategy implements StorageStrategy {

    private HashBiMap<Long, String> data = HashBiMap.create();
    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }
    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }
    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }
    @Override
    public Long getKey(String value) {
        return data.inverse().get(value);
    }
    @Override
    public String getValue(Long key) {
        return data.get(key);
    }

}

/*
Shortener (12)

Задача, когда требуется создать Map, работающий в две стороны (по ключу получать значение, а по значению ключ) не такая уж и редкая. Такие коллекции уже реализованы в различных сторонних библиотеках коллекций. Одна из таких Guava от Google.

12.1. Скачай и подключи библиотеку guava версии 19.0.

12.2. Реализуй стратегию HashBiMapStorageStrategy. Она должна:

12.2.1. Поддерживать интерфейс StorageStrategy.

12.2.2. Внутри иметь только одно поле data типа HashBiMap.

12.3. Проверь новую стратегию в методе main(). Запусти программу и сравни скорость работы пяти стратегий.





Требования:

1. Класс HashBiMapStorageStrategy должен поддерживать интерфейс StorageStrategy.

2. В классе HashBiMapStorageStrategy должно быть создано только одно поле data типа HashBiMap.

3. Метод containsKey должен проверять содержится ли ключ в data.

4. Метод containsValue должен проверять содержится ли значение в data.

5. Метод put должен добавлять пару (key, value) в data.

6. Метод getValue должен возвращать значение полученное из data.

7. Метод getKey должен возвращать значение полученное из data.inverse().
*/
