
//Nay, you do wrong, and defraud, and that your brethren. (1Cor 6:8)

package com.javarush.task.task27.task2710;

public class Mail {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
