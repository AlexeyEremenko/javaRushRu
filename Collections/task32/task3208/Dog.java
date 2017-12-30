
//He that overcometh shall inherit all things; and I will be his God, and he shall be my son. (Revelation 21:7)

package com.javarush.task.task32.task3208;

import java.rmi.RemoteException;

public class Dog implements Animal {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void say() throws RemoteException {
        System.out.println("woof");
    }

    @Override
    public void printName() throws RemoteException {
        System.out.print("Dog " + name + " ");
    }
}

/*
RMI-2

Реализуй логику метода run в SERVER_THREAD. В нем будет имитироваться серверная часть:

1) Инициализируй поле registry, которое будет принимать и обрабатывать запросы на 2099 порту.

2) Создай два объекта - Cat и Dog.

3) Используй класс UnicastRemoteObject, чтобы создать Remote объекты для созданных Cat и Dog.

Remote объекты будут в состоянии принимать обращения к своим методам используя выбранный порт (2099).

4) Для Cat и Dog добавь в registry связь уникального текстового ключа и Remote объекта. Текстовый ключ придумай сам.

5) При возникновении любого исключения выведи его стек-трейс в поток System.err.

Метод main не участвует в тестировании.





Требования:

1. В методе run() необходимо инициализировать поле registry. Для этого используй LocateRegistry.createRegistry (2099).

2. В методе run() необходимо создать два объекта - Cat и Dog.

3. В методе run() необходимо создать Remote объекты для созданных Cat и Dog используя UnicastRemoteObject.exportObject (Remote, int).

4. Для Cat и Dog нужно добавить в registry связь уникального текстового ключа и Remote объекта используя registry.bind (String, Remote).

5. При возникновении любого исключения нужно вывести его стек-трейс в поток System.err используя метод printStackTrace ().
*/
