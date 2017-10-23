
//"When the Counselor has come, whom I will send to you from the Father, the Spirit of truth, who proceeds from the Father, he will testify about me. (John 15:26)

package com.javarush.task.task16.task1611;

/* 
Часы
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("Clock has to be stopped");
        Thread.sleep(2000);
        System.out.println("Double-check");
    }

    public static class Clock extends Thread {
        public Clock() {
            setPriority(MAX_PRIORITY);
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTikTak();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTikTak() throws InterruptedException {
           System.out.println("Tik");//add your code here - добавь код тут
           Thread.sleep(500);
           System.out.println("Tak");
           Thread.sleep(500);
        }
    }
}





/*
Часы
1. Разберись, что делает программа.
2. Реализуй логику метода printTikTak:
2.1. Через первые полсекунды должна выводиться в консоль фраза: Tik.
2.2. Через вторые полсекунды должна выводиться в консоль фраза: Tak.


Требования:
1. Метод printTikTak должен выводить две строчки: "Tik" и "Tak".
2. Метод printTikTak должен работать примерно секунду.
3. Метод printTikTak должен два раза заснуть на полсекунды. Используй метод Thread.sleep(500).
4. В консоли не должно быть сообщений после фразы "Double-check".
5. Метод main должен создавать объект типа Clock.


package com.javarush.task.task16.task1611;

* 
Часы
*

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("Clock has to be stopped");
        Thread.sleep(2000);
        System.out.println("Double-check");
    }

    public static class Clock extends Thread {
        public Clock() {
            setPriority(MAX_PRIORITY);
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTikTak();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTikTak() throws InterruptedException {
            //add your code here - добавь код тут
        }
    }
}

*/
