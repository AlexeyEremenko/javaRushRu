
//But we preach Christ crucified, unto the Jews a stumbling block, and unto the Greeks foolishness; (1Cor 1:23)

package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread tr : threads) {   //implement this method - реализуйте этот метод
            switch (tr.getState()) {
                case NEW:
                    tr.start();
                    break;
                case WAITING:
                    tr.interrupt();
                    break;
                case TIMED_WAITING:
                    tr.interrupt();
                    break;
                case BLOCKED:
                    tr.interrupt();
                    break;
                case RUNNABLE:
                    tr.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(tr.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread();
        }
        Solution.processThreads(threads);
        threads[0].interrupt();
        try {
            threads[1].join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Solution.processThreads(threads);
    }
}
/*
Switch для нитей
Обработай список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запусти ее.
2. Если нить в ожидании, то прерви ее.
3. Если нить работает, то проверь маркер isInterrupted.
4. Если нить прекратила работу, то выведи в консоль ее приоритет.
Используй switch.


Требования:
1. Метод processThreads принимает аргументом массив нитей.
2. Если переданная нить не запущена, нужно ее запустить.
3. Если переданная нить находится в ожидании, нужно ее прервать.
4. Если переданная нить работает, то нужно проверить маркер isInterrupted.
5. Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
6. Метод processThreads должен использовать оператор switch.

package com.javarush.task.task25.task2504;

* 
Switch для нитей
*
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
*/
