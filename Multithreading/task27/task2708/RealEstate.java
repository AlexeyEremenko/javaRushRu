
//For what have I to do to judge them also that are outside? do not you judge them that are within? (1Cor 5:12)

package com.javarush.task.task27.task2708;

import java.util.HashSet;
import java.util.Set;

public class RealEstate {

    private final Set<Apartment> allApartments;
    private final Set<Apartment> activeApartments;

    public RealEstate() {
        allApartments = new HashSet();
        activeApartments = new HashSet();

        //add some data
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
    }

    public Set<Apartment> getAllApartments() {
        return allApartments;
    }

    public  void up(Apartment apartment) {
        activeApartments.add(apartment);
    }

    public  void revalidate() {
        activeApartments.clear();
        for (Apartment apartment : allApartments) {
            boolean randomValue = Math.random() * 2 % 2 == 0;
            synchronized (this){
                apartment.revalidate(randomValue);
            }
        }
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
