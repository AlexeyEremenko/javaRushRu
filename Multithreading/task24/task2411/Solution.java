
//But the other disciples came in the little boat (for they were not far from the land, but about two hundred cubits away), dragging the net full of fish. (John 21:8)

------------------------------------------------------Solution.java-----------------------------------------------------------
package com.javarush.task.task24.task2411;

/* 
Вспомним наследование
*/
public class Solution  extends C {
    private class A {
        protected String value = "A";

        public A() {
            System.out.print(value);
        }
    }

    private A a = new A() {
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
            value = "Y";
            if (super.getClass().getName().contains(".Solution$")) {
                System.out.print(value);
            }
        }
    };

    public Solution() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Solution();
    }
}
------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------------C.java--------------------------------------------------------------
package com.javarush.task.task24.task2411;

public class C implements JustAnInterface {
    public C() {
        System.out.print("C");
        B localB = B;
    }
}
------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------JustAnInterface.java------------------------------------------------------
package com.javarush.task.task24.task2411;

public interface JustAnInterface {
    public static final B B = new B();

    class B extends C {
        public B() {
            System.out.print("B");
        }
    }
}
------------------------------------------------------------------------------------------------------------------------------





/*
Вспомним наследование
Исправить наследование во всех классах, чтобы вывод метода main был CCBAYS.


Требования:
1. Вывод на экран должен соответствовать условию задачи.
2. Класс C должен поддерживать интерфейс JustAnInterface.
3. Класс B должен быть потомком класса C.
4. Класс Solution должен быть потомком класса C.

------------------------------------------------------Solution.java-----------------------------------------------------------
package com.javarush.task.task24.task2411;

/* 
Вспомним наследование
*/
public class Solution {
    private class A {
        protected String value = "A";

        public A() {
            System.out.print(value);
        }
    }

    private A a = new A() {
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
            value = "Y";
            if (super.getClass().getName().contains(".Solution$")) {
                System.out.print(value);
            }
        }
    };

    public Solution() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Solution();
    }
}
------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------------C.java--------------------------------------------------------------
package com.javarush.task.task24.task2411;

public class C {
    public C() {
        System.out.print("C");
        B localB = B;
    }
}
------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------JustAnInterface.java------------------------------------------------------
package com.javarush.task.task24.task2411;

public interface JustAnInterface {
    public static final B B = new B();

    class B {
        public B() {
            System.out.print("B");
        }
    }
}
------------------------------------------------------------------------------------------------------------------------------

*/
