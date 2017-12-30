
//And he said unto me, It is done. I am Alpha and Omega, the beginning and the end. I will give unto him that is athirst of the fountain of the water of life freely. (Revelation 21:6)

package com.javarush.task.task32.task3207;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoubleString extends Remote {
    String doubleString(String str) throws RemoteException;
}

/*
К серверу по RMI

Реализуй логику метода run в CLIENT_THREAD. В нем будет имитироваться клиентская часть, которая коннектится к серверу.

1) Из registry получи сервис с именем UNIC_BINDING_NAME.

2) Вызови метод у полученного сервиса, передай любой не пустой аргумент.

3) Выведи в консоль результат вызова метода.

4) Обработай специфические исключения.

Метод main не участвует в тестировании.





Требования:

1. В методе run() необходимо из registry получить сервис с именем UNIC_BINDING_NAME.

2. В методе run() необходимо вызвать метод doubleString (String) у полученного сервиса.

3. В методе run() необходимо вывести в консоль результат вызова метода doubleString (String).

4. В методе run() должен быть перехват исключения RemoteException.

5. В методе run() должен быть перехват исключения NotBoundException.
*/
