
//Let a man so account of us, as of the ministers of Christ, and stewards of the mysteries of God. (1Cor 4:1)

package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Consumer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Consumer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            if (!map.isEmpty()) {
                for (String key : map.keySet()) {
                    System.out.println(map.remove(key));
                }
            }
        }
    }
}

/*
Мир не меняется, меняемся мы
Разберись с ConcurrentHashMap.
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение, где ключ — счетчик начиная с 1, значение — фраза: «Some text for i» , пример «Some text for 1«.
2. при возникновении исключения выводить в консоль: «[TREAD_NAME] thread was terminated«, пример «[thread-1] thread was terminated«.


Требования:
1. Класс Producer должен быть создан в отдельном файле.
2. Класс Producer должен реализовывать интерфейс Runnable.
3. Класс Producer должен содержать приватное поле ConcurrentHashMap map.
4. Класс Producer должен содержать конструктор с одним параметром, инициализирующий поле map.
5. Метод run() класса Producer должен каждые полсекунды добавлять в ConcurrentHashMap ключ и значение согласно заданию.
6. Метод run() класса Producer должен при возникновении исключения выводить в консоль "[TREAD_NAME] thread was terminated".

package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Consumer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Consumer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            if (!map.isEmpty()) {
                for (String key : map.keySet()) {
                    System.out.println(map.remove(key));
                }
            }
        }
    }
}
*/
