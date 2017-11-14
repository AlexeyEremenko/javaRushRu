
//Therefore let us keep the feast, not with old leaven, neither with the leaven of malice and wickedness; but with the unleavened bread of sincerity and truth (1Cor 5:8)

package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
*/
public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        Object uno = obj1.hashCode() > obj2.hashCode()? obj1: obj2;
        Object duo = obj1.hashCode() > obj2.hashCode()? obj2: obj1;
        synchronized (uno) {
            longTimeMethod();
            synchronized (duo) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}

/*
Убираем deadlock
Используя стратегию избегания deadlock-а сделай так, чтобы он не возник.
Метод main не участвует в тестировании.
Действуй аналогично примеру из лекций.
Изменения вноси только в safeMethod.


Требования:
1. Метод safeMethod не должен вызывать deadlock при использовании из разных потоков.
2. В методе safeMethod должен содержаться вызов метода unsafeMethod, с теми же аргументами.
3. В методе safeMethod должен содержаться вызов метода longTimeMethod.
4. В методе safeMethod должно содержаться два блока synchronized.
*/
