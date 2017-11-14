
//I wrote unto you in an epistle not to company with fornicators (1Cor 5:9)

package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        int lckA = obj1.hashCode();
        int lckB = obj2.hashCode();
        Object uno = lckA > lckB ? obj1 : obj2;
        Object duo = lckA > lckB ? obj2 : obj1;
        synchronized (uno) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
            synchronized (duo) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        new Thread() {    //do something here
            
            public void run() {
                synchronized (o1) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {e.printStackTrace();}
                }
            }
        }.start();

        Thread thread2=new Thread() {
            
            public void run() {
                synchronized (o1)
                {
                    synchronized (o2)
                    {
                        solution.someMethodWithSynchronizedBlocks(o1, o2);
                    }
                }
            }
        };
        thread2.start();
        return Thread.State.BLOCKED.equals(thread2.getState());
    }

    public static Thread.State waitAndGetState(Thread thread) throws InterruptedException {
        Thread.sleep(300);
        return thread.getState();
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
/*
Определяем порядок захвата монитора
Реализуй логику метода isNormalLockOrder, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks — порядку передаваемых в него аргументов.
В случае, если сначала происходит синхронизация по o1, а потом по o2, метод должен вернуть true.
Если наоборот — false.


Требования:
1. Метод isNormalLockOrder должен возвращать true в случае, если синхронизация в методе someMethodWithSynchronizedBlocks происходит сначала по объекту o1, а потом по o2.
2. Метод isNormalLockOrder должен возвращать false в случае, если синхронизация в методе someMethodWithSynchronizedBlocks происходит сначала по объекту o2, а потом по o1.
3. Метод isNormalLockOrder НЕ должен быть приватным.
4. Класс Solution НЕ должен быть объявлен с модификатором final.

package com.javarush.task.task27.task2707;

* 
Определяем порядок захвата монитора
*
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
*/
