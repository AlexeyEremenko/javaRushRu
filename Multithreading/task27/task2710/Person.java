
//But brother goes to law with brother, and that before the unbelievers (1Cor 6:6)

package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            //сделайте что-то тут - do something here
            mail.setText("Person [" + name + "] has written an email 'AAA'");
            
            synchronized (mail) {  //сделайте что-то тут - do something here
                mail.notifyAll();
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
Расставьте wait-notify
Расставь wait-notify.

Пример вывода:
Thread-0 MailServer has got: [Person [Thread-1] has written an email 'AAA'] in 1001 ms after start


Требования:
1. Объекты класса MailServer должны работать корректно в многопоточном окружении.
2. Объекты класса Person должны работать корректно в многопоточном окружении.
3. В методе run класса MailServer должен присутствовать synchronized блок, монитор - mail.
4. В методе run класса Person должен присутствовать synchronized блок, монитор - mail.

package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            //сделайте что-то тут - do something here
            mail.setText("Person [" + name + "] has written an email 'AAA'");
            //сделайте что-то тут - do something here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
*/
