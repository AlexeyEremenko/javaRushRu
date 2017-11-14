
//But now I have written unto you not to keep company, if any man that is called a brother be a fornicator, or covetous, or an idolater, or a railer, or a drunkard, or an extortioner; with such a one no not to eat. (1Cor 5:11)

package com.javarush.task.task27.task2708;

public class Apartment {
    private String location;
    private final RealEstate realEstate;

    public Apartment(RealEstate realEstate) {
        this.realEstate = realEstate;
        setLocation(String.valueOf(Math.random() * 10));
    }

    public synchronized String getLocation() {
        return location;
    }

    public void setLocation(String location) {

        this.location = location;

    }

    public void revalidate(boolean isEmpty) {
        if (isEmpty)
            realEstate.up(this);
    }
}

/*
Убираем deadLock используя открытые вызовы
Синхронизированные методы, которые вызывают внутри себя синхронизированные методы других классов, приводят к dead-lock-у.
1. Перенесите синхронизацию с метода в синхронизированный блок, куда поместите лишь необходимые части кода.
2. Уберите избыточную синхронизацию методов.
3. В стеке вызова методов не должно быть перекрестной синхронизации, т.е. такого synchronizedMethodAClass().synchronizedMethodBClass().synchronizedMethodAClass()

Этот способ избавления от дэдлока называется «открытые вызовы«, о нем читайте в дополнительном материале к лекции.
Метод main не участвует в тестировании.


Требования:
1. Должна быть обеспечена возможность корректного взаимодействия объектов типа Apartment и RealEstate без возникновения взаимных блокировок.
2. Метод up класса RealEstate должен быть объявлен без модификатора synchronized.
3. Метод revalidate класса RealEstate должен быть объявлен без модификатора synchronized.
4. Метод revalidate класса Apartment должен быть объявлен без модификатора synchronized.
5. Метод revalidate класса RealEstate должен содержать один synchronized блок.
6. В synchronized блоке метода revalidate класса RealEstate должен содержаться вызов метода revalidate на объекте apartment с параметром randomValue.
*/
