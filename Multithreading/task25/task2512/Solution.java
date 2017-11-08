
//That, according as it is written, He that glories, let him glory in the Lord. (1Cor 1:31)

package com.javarush.task.task25.task2512;

import java.util.Stack;
/* 
Живем умом Христовым
*/
public class Solution implements Thread.UncaughtExceptionHandler {
 @Override
    public void uncaughtException(Thread thread, Throwable e) {
        thread.interrupt();
        Stack<Throwable> exceptions = new Stack<>();
        exceptions.push(e);
        Throwable throwable = e.getCause();
        while (throwable != null) {
            exceptions.push(throwable);
            throwable = throwable.getCause();
        }
        while (!exceptions.empty())
        {
            Throwable currentException = exceptions.pop();
            System.out.println(currentException.getClass().getName() + ": " +currentException.getMessage());
        }
    }

    public static void main (String args[]) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
/*
Живем умом Христовым
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC


Требования:
1. Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
2. После вызова uncaughtException нужно прервать нить, которая бросила исключение.
3. Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
4. Сообщения должны выводиться в формате "exception class : exception message".

package com.javarush.task.task25.task2512;

* 
Живем умом Христовым
*
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
    }

    public static void main(String[] args) {
    }
}
*/
