
// and that the Gentiles might glorify God for his mercy. As it is written, "Therefore will I give praise to you among the Gentiles, and sing to your name. (Romans 15:9)


package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable {
        private int countIndexUp = 1;//Add your code here - добавь код тут
        
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexUp += 1;
                    if (countIndexUp > number) {
                        Thread.sleep(500);
                        return;
                    }
                    Thread.sleep(500);
                }
            }catch(InterruptedException e) {e.printStackTrace();}
        }
        
        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}




/*
Создание по образцу
Разберись, как работает программа.
По образу и подобию CountDownRunnable создай нить CountUpRunnable, которая выводит значения в нормальном порядке — от 1 до number.


Требования:
1. Класс CountUpRunnable должен реализовывать интерфейс Runnable.
2. Класс CountUpRunnable должен иметь публичный метод run без параметров.
3. Метод run класса CountUpRunnable должен работать примерно 2,5 секунды.
4. Метод run класса CountUpRunnable должен каждые полсекунды выводить имя потока, двоеточие и значение счетчика от 1 до 5 (например: "Увеличиваем: 1").
5. Метод run класса CountUpRunnable должен вызывать Thread.sleep(500).


package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable {
        //Add your code here - добавь код тут
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}

*/
