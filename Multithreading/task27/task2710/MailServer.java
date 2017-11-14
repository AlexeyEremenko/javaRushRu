
//Now therefore there is utterly a fault among you, because you go to law one with another. Why do you not rather take wrong? why do you not rather allow yourselves to be defrauded? (1Cor 6:7)

package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long beforeTime = System.currentTimeMillis();
        
        synchronized (mail){      //сделайте что-то тут - do something here
            while (mail.getText() == null)
                try {
                    mail.wait();
                }catch (Exception e) {e.printStackTrace();}
        }
        String name = Thread.currentThread().getName();
        long afterTime = System.currentTimeMillis();
        System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
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
*/
