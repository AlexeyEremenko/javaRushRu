
//But unto them who are called, both Jews and Greeks, Christ the power of God, and the wisdom of God. (1Cor 1:24)

package com.javarush.task.task25.task2505;

/* 
Без порожняков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(String.format("%s, %s, %s", secretKey, thread.getName(), e.getMessage()));
                e.printStackTrace();
            }
            public MyUncaughtExceptionHandler() {
            }
        }
    }
}
/*
1. Создай private class MyUncaughtExceptionHandler, который на перехват исключения должен подождать половину секунды, а затем вывести на экран secretKey, имя трэда и сообщение возникшего исключения.
Используй String.format(…).

Пример:
super secret key, Thread-0, it's an example

2. Разберись в последовательности выполняемого кода и обеспечь логирование возникновения исключения в п.1.
3. Метод main в тестировании не участвует.


Требования:
1. Создай private class MyUncaughtExceptionHandler с конструктором по-умолчанию в классе MyThread.
2. Во время перехвата исключения, MyUncaughtExceptionHandler должен вызвать Thread.sleep(500).
3. Затем, MyUncaughtExceptionHandler должен выводить в консоль secretKey, имя трэда и сообщение возникшего исключения.
4. Для вывода сообщения используй String.format(...).
5. Нужно обеспечить логирование возникновения исключения.

package com.javarush.task.task25.task2505;

* 
Без порожняков
*
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }
}
*/
