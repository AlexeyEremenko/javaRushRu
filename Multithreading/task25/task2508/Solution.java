
//But God has chosen the foolish things of the world to confound the wise; and God has chosen the weak things of the world to confound the things which are mighty (1Cor 1:27)

-----------------------------------------------------Solution.java-------------------------------------------------------------------
package com.javarush.task.task25.task2508;

/* 
Не валять ваньку
*/
public class Solution
{
    /*
     Output:
     first
     first
     second
     second
     second
     third
     fifth
     */
    public static void main(String[] args) throws InterruptedException {
        CustomThreadManipulator manipulator = new TaskManipulator();

        manipulator.start("first");
        Thread.sleep(150);
        manipulator.stop();

        manipulator.start("second");
        Thread.sleep(250);
        manipulator.stop();

        manipulator.start("third");
        Thread.sleep(50);
        manipulator.stop();

        manipulator.start("forth");
        manipulator.stop();

        manipulator.start("fifth");
        Thread.sleep(1);
        manipulator.stop();
    }
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------CustomThreadManipulator.java----------------------------------------------------
package com.javarush.task.task25.task2508;

public interface CustomThreadManipulator {
    public void start(String threadName);
    public void stop();
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------TaskManipulator.java------------------------------------------------------------
package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    
    private Thread thread;
    
    @Override
    public void run() {
        while (!thread.isInterrupted()) {
        System.out.println(Thread.currentThread().getName());    
        try{
            Thread.sleep(100);
        }catch(InterruptedException e) {e.printStackTrace();}
        }
    }
    
    @Override
    public void stop() {
        thread.interrupt();
    }
    
    @Override
    public void start(String threadName) {
        this.thread = new Thread(this);
        this.thread.setName(threadName);
        this.thread.start();
    }
}
-------------------------------------------------------------------------------------------------------------------------------------







/*
Восстанови логику класса TaskManipulator.


Требования:
1. Класс TaskManipulator должен реализовывать интерфейсы Runnable и CustomThreadManipulator.
2. Метод run должен каждые 100 миллисекунд выводить имя исполняемой нити в консоль.
3. Класс TaskManipulator должен иметь внутреннее поле типа Thread.
4. Метод start должен создавать, сохранять во внутреннее поле и запускать нить с именем, которое передано через аргумент метода.
5. Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.


-----------------------------------------------------Solution.java-------------------------------------------------------------------
package com.javarush.task.task25.task2508;

public class Solution
{
    /*
     Output:
     first
     first
     second
     second
     second
     third
     fifth
     */
    public static void main(String[] args) throws InterruptedException {
        CustomThreadManipulator manipulator = new TaskManipulator();

        manipulator.start("first");
        Thread.sleep(150);
        manipulator.stop();

        manipulator.start("second");
        Thread.sleep(250);
        manipulator.stop();

        manipulator.start("third");
        Thread.sleep(50);
        manipulator.stop();

        manipulator.start("forth");
        manipulator.stop();

        manipulator.start("fifth");
        Thread.sleep(1);
        manipulator.stop();
    }
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------CustomThreadManipulator.java----------------------------------------------------
package com.javarush.task.task25.task2508;

public interface CustomThreadManipulator {
    public void start(String threadName);
    public void stop();
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------TaskManipulator.java------------------------------------------------------------
package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable {
    @Override
    public void run() {
    }
}
-------------------------------------------------------------------------------------------------------------------------------------
*/