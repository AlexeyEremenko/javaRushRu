
//You didn't choose me, but I chose you, and appointed you, that you should go and bear fruit, 
//and that your fruit should remain; that whatever you will ask of the Father in my name, he may give it to you. (John 15:16)

package com.javarush.task.task16.task1601;

/* 
My first thread
*/

public class Solution {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }
    
public static class TestThread implements Runnable {
    public void run() {System.out.println("My first thread");}
}
}


/*
My first thread
Создать public static class TestThread — нить с интерфейсом Runnable.
TestThread должен выводить в консоль «My first thread«.


Требования:
1. Добавь в класс Solution публичный статический класс TestThread.
2. Класс TestThread должен реализовывать интерфейс Runnable.
3. Метод run класса TestThread должен выводить "My first thread".
4. Программа должна вывести "My first thread".
5. Метод main не изменять.


package com.javarush.task.task16.task1601;

/* 
My first thread
*/

public class Solution {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }
}

*/
