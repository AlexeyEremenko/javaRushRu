
//Then said some of his disciples among themselves, What is this that he saith unto us, A little while, and ye shall not see me: and again, a little while, and ye shall see me: and, Because I go to the Father? (John 16:17)

package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger count = new AtomicInteger(1);

    public MyThread() {
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(Runnable target) {
        super(target);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }

    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(String name) {
        super(name);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }
}

/*
Приоритеты в Threads

В отдельном файле создай класс MyThread унаследовавшись от Thread. MyThread должен:

1. Иметь возможность быть созданным используя любой конструктор супер-класса (Alt+Insert).

2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.

3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда не может быть больше максимального приоритета его трэд-группы.





Требования:

1. Создай класс MyThread в отдельном файле. Унаследуй его от Thread.

2. В классе MyThread должны присутствовать конструкторы, аналогичные конструкторам супер-класса.

3. Приоритет у объектов MyThread должен проставляться циклично, от MIN_PRIORITY до MAX_PRIORITY.

4. Если у объекта MyThread установлена ThreadGroup, приоритет MyThread не должен быть выше максимального приоритета ThreadGroup.
*/
