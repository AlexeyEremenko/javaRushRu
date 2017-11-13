
//Whether Paul, or Apollos, or Cephas, or the world, or life, or death, or things present, or things to come; all are yours; (1Cor 3:22)

package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(queue.take());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}

/*
Мир скучен для скучных людей
Разберись с BlockingQueue.
По образу и подобию класса Producer создай класс Consumer, который будет выводить данные из BlockingQueue в консоль.


Требования:
1. Класс Consumer должен быть создан в отдельном файле.
2. Класс Consumer должен реализовывать интерфейс Runnable.
3. Класс Consumer должен содержать приватное поле BlockingQueue queue.
4. Класс Consumer должен содержать конструктор с одним параметром, инициализирующий поле queue.
5. Метод run() класса Consumer должен постоянно выводить на экран значения из очереди.
*/
