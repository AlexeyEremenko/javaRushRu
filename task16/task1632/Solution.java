
//I myself am also persuaded about you, my brothers, that you yourselves are full of goodness, filled with all knowledge, 
//able also to admonish others (Romans 15:14)

--------------------------------------------Solution.java---------------------------------------------------------------------
package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    
    static {
        threads.add(new PrimaInfinita());
        threads.add(new SecundaInterrupted());
        threads.add(new TertiaHooray());
        threads.add(new QuartaMessageInterrupt());
        threads.add(new QuintaSum());
    }

    public static void main(String[] args) {
    }
}

class PrimaInfinita extends Thread {
    
    @Override
    public void run() {
        while (true){
           // INFINITE 
        }
    }
}

class SecundaInterrupted extends Thread {
    
    @Override
    public void run() {
        while (true) {
            //INTERRUPTED
            try{
                Thread.sleep(1);
                }catch(InterruptedException e) {System.out.println("InterruptedException");}
        }
    }
}

class TertiaHooray extends Thread {
    
    @Override
    public void run() {
        while (true) {
            //HOORAY
            try{
                System.out.println("Ура");
                Thread.sleep(500);
                }catch(InterruptedException e) {e.printStackTrace();}
        }
    }
}

class QuartaMessageInterrupt extends Thread implements Message {
    
    @Override
    public void run() {
        while (!isInterrupted()) {
            //MESSAGE+INTERRUPT
        }
    }
    
    @Override
    public void showWarning() {
        interrupt();
    }
}

class QuintaSum extends Thread {
    
    @Override
    public void run() {
        String string;
   int result = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(string = br.readLine()).equals("N")) {
                //SUM
                result += Integer.parseInt(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
------------------------------------------------------------------------------------------------------------------------------



---------------------------------------------Message.java---------------------------------------------------------------------
package com.javarush.task.task16.task1632;

public interface Message {
    void showWarning();
}
------------------------------------------------------------------------------------------------------------------------------





/*
Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить «InterruptedException» при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить «Ура«;
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово «N«, а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()


Требования:
1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
2. Нити из списка threads не должны стартовать автоматически.
3. Нить 1 из списка threads должна бесконечно выполняться.
4. Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
6. Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
7. Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.

--------------------------------------------Solution.java---------------------------------------------------------------------
package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
    }
}
------------------------------------------------------------------------------------------------------------------------------



---------------------------------------------Message.java---------------------------------------------------------------------
package com.javarush.task.task16.task1632;

public interface Message {
    void showWarning();
}
------------------------------------------------------------------------------------------------------------------------------


*/
