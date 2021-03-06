
//To deliver such a one unto Satan for the destruction of the flesh, that the spirit may be saved in the day of the Lord Jesus. (1Cor 5:5)

package com.javarush.task.task30.task3008.client;


public class BotClient extends Client {
    
    public static void main(String[] args) {
        new BotClient().run();

    }
    
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = "date_bot_" + ((int) (Math.random() * 100));
        return botName;
    }
    
    public class BotSocketThread extends SocketThread {
        
    }
}

/*
Чат (18)
Иногда бывают моменты, что не находится достойного собеседника. Не общаться же с самим собой :). Давай напишем бота, который будет представлять собой клиента, который автоматически будет отвечать на некоторые команды. Проще всего реализовать бота, который сможет отправлять текущее время или дату, когда его кто-то об этом попросит.

С него и начнем:
1) Создай новый класс BotClient в пакете client. Он должен быть унаследован от Client.
2) В классе BotClient создай внутренний класс BotSocketThread унаследованный от SocketThread. Класс BotSocketThread должен быть публичным.
3) Переопредели методы:
а) getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
б) shouldSendTextFromConsole(). Он должен всегда возвращать false. Мы не хотим, чтобы бот отправлял текст введенный в консоль.
в) getUserName(), метод должен генерировать новое имя бота, например: date_bot_X, где X – любое число от 0 до 99. Для генерации X используй метод Math.random().
4) Добавь метод main. Он должен создавать новый объект BotClient и вызывать у него метод run().


Требования:
1. В пакете client должен быть создан класс BotClient являющийся потомком класса Client.
2. В классе BotClient должен быть создан внутренний публичный класс BotSocketThread являющийся потомком класса SocketThread.
3. В классе BotClient должен быть переопределен метод getSocketThread возвращающий новый объект класса BotSocketThread.
4. В классе BotClient должен быть переопределен метод shouldSendTextFromConsole всегда возвращающий false.
5. В классе BotClient должен быть переопределен метод getUserName возвращающий имя бота по формату указанному в условии задачи.
6. В методе main класса BotClient должен быть создан новый объект класса BotClient и у него должен быть вызван метод run.
*/
