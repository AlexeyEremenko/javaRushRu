
//And I baptized also the household of Stephanas: besides, I know not whether I baptized any other. (1Cor 1:16)

----------------------------------------------------Solution.java-------------------------------------------------------------------
package com.javarush.task.task24.task2401;

/* 
Создание своего интерфейса-маркера
*/
public class Solution {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl();
        Util.testClass(obj);
    }
}
------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------Util.java----------------------------------------------------------------------
package com.javarush.task.task24.task2401;

import java.lang.reflect.Method;

public class Util {
    //пример того, как можно использовать интерфейс-маркер
    //this method is available only for a SelfInterfaceMarker implementation
    public static void testClass(SelfInterfaceMarker interfaceMarker) throws UnsupportedInterfaceMarkerException {
        if (interfaceMarker == null) {throw new UnsupportedInterfaceMarkerException();}
        for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}
------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------SelfInterfaceMarker.java------------------------------------------------------
package com.javarush.task.task24.task2401;


public interface SelfInterfaceMarker {
}
------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------SelfInterfaceMarkerImpl.java---------------------------------------------------
package com.javarush.task.task24.task2401;


public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    
    public void marque() {}
    
    public void more() {}
}
------------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------UnsupportedInterfaceMarkerException.java--------------------------------------
package com.javarush.task.task24.task2401;


public class UnsupportedInterfaceMarkerException extends Exception {
}
------------------------------------------------------------------------------------------------------------------------------------


/*
Создание своего интерфейса-маркера
1. Создай интерфейс-маркер SelfInterfaceMarker.
2. Создай класс SelfInterfaceMarkerImpl, который реализует SelfInterfaceMarker.
3. Добавь в SelfInterfaceMarkerImpl минимум 2 любых public метода.
4. Создай исключение UnsupportedInterfaceMarkerException, унаследуй его от класса Exception.
5. В методе testClass класса Util: если параметр == null, то выбросьте UnsupportedInterfaceMarkerException.


Требования:
1. Интерфейс-маркер SelfInterfaceMarker должен быть создан в отдельном файле.
2. Класс SelfInterfaceMarkerImpl должен быть создан в отдельном файле и реализовывать интерфейс SelfInterfaceMarker.
3. В классе SelfInterfaceMarkerImpl должны существовать минимум два public метода.
4. Исключение UnsupportedInterfaceMarkerException должно быть создано в отдельном файле.
5. Метод testClass класса Util должен бросать исключение UnsupportedInterfaceMarkerException в случае, если полученный параметр равен null.
6. В интерфейсе SelfInterfaceMarker не должны быть объявлены методы или декларированы константы.

----------------------------------------------------Solution.java-------------------------------------------------------------------
package com.javarush.task.task24.task2401;

/* 
Создание своего интерфейса-маркера
*/
public class Solution {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl();
        Util.testClass(obj);
    }
}
------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------Util.java----------------------------------------------------------------------
package com.javarush.task.task24.task2401;

import java.lang.reflect.Method;

public class Util {
    //пример того, как можно использовать интерфейс-маркер
    //this method is available only for a SelfInterfaceMarker implementation
    public static void testClass(SelfInterfaceMarker interfaceMarker) throws UnsupportedInterfaceMarkerException {
        for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}
------------------------------------------------------------------------------------------------------------------------------------
*/
