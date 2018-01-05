
//John answered them, saying, I baptize with water: but there standeth one among you, whom ye know not (John 1:26)

package com.javarush.task.task28.task2809;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Character implements Runnable {
    protected abstract int getId();

    public void run() {
        System.out.println(toString() + " вступил в игру");
        doSomething();
        System.out.println(toString() + " умер");
    }

    private void doSomething() {
        try {
            Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(10, 100));
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " #" + getId();
    }

}

/*
Plants vs Zombies

1. Почитай про java.util.concurrent.Phaser.

2. Расставь методы в нужных местах:

- arriveAndDeregister() - начинает запускать методы run у тасок,

- arriveAndAwaitAdvance() - ждет, когда все трэды будут созданы.



Пример вывода см. в output.txt.

Логика:

Сначала все персонажи присоединяются к игре.

После того, как все персонажи присоединятся к игре и готовы играть, выводится фраза "Игра началась!".

После этого персонажи вступают в игру, после чего умирают.





Требования:

1. Класс Character менять не нужно.

2. Классы Plant и Zombie менять не нужно.

3. В классе Solution вызови метод phaser.arriveAndDeregister в правильном месте.

4. В классе Solution вызови метод phaser.arriveAndAwaitAdvance в правильном месте.
*/
