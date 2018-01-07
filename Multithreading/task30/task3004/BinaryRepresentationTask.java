
//And I saw another mighty angel come down from heaven, clothed with a cloud: and a rainbow was upon his head, and his face was as it were the sun, and his feet as pillars of fire (Revelation 10:1)

package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }
        return result;


    }
}

/*
Fork/Join

1. Создай класс BinaryRepresentationTask. Для этого в IntelliJ IDEA на красном имени класса нажми Alt+Enter -> Create Class ...

(класс должен наследоваться от RecursiveTask<String>). Параметр конструктора - int x.

2. Реализуй логику метода compute - число должно переводиться в двоичное представление.

3. Используй методы fork и join.

4. Пример функциональной реализации - метод binaryRepresentationMethod.





Требования:

1. Создай класс BinaryRepresentationTask.

2. В классе BinaryRepresentationTask должен быть переопределен метод compute().

3. В классе BinaryRepresentationTask в методе compute() используй методы fork() и join().

4. Метод compute() должен правильно переводить число в двоичную систему счисления.
*/
