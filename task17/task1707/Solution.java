
//Now we know that you know all things, and don't need for anyone to question you. By this we believe that you came forth from God. (John 16:30)

------------------------------------------------------Solution.java------------------------------------------------------------------
package com.javarush.task.task17.task1707;

/* 
МВФ
*/

public class Solution {
    public static void main(String[] args) {
        IMF fund = IMF.getFund();
        IMF anotherFund = IMF.getFund();
        System.out.println(fund == anotherFund );
    }
}
-------------------------------------------------------------------------------------------------------------------------------------



---------------------------------------------------------IMF.java--------------------------------------------------------------------
package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;

    public static IMF getFund() {
       synchronized(IMF.class) { //add your code here - добавь код тут 
        if (imf == null) {imf = new IMF();}
       
        return imf;
       }
    }

    private IMF() {
    }
}
-------------------------------------------------------------------------------------------------------------------------------------





/*
МВФ
Singleton паттерн — синхронизация в методе.
Класс IMF — это Международный Валютный Фонд.
Внутри метода getFund создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте поле imf так, чтобы метод getFund всегда возвращал один и тот же объект.


Требования:
1. Класс IMF должен содержать приватное статическое поле IMF imf.
2. Класс IMF должен содержать приватный конструктор.
3. Класс IMF должен содержать публичный статический метод IMF getFund().
4. Метод getFund() должен содержать синхронизированный блок.
5. Внутри синхронизированного блока должно быть проинициализировано поле imf.
6. Метод getFund() должен всегда возвращать один и тот же объект.


------------------------------------------------------Solution.java------------------------------------------------------------------
package com.javarush.task.task17.task1707;

/* 
МВФ
*/

public class Solution {
    public static void main(String[] args) {
        IMF fund = IMF.getFund();
        IMF anotherFund = IMF.getFund();
        System.out.println(fund == anotherFund );
    }
}
-------------------------------------------------------------------------------------------------------------------------------------



---------------------------------------------------------IMF.java--------------------------------------------------------------------
package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;

    public static IMF getFund() {
        //add your code here - добавь код тут
        return imf;
    }

    private IMF() {
    }
}
-------------------------------------------------------------------------------------------------------------------------------------

*/
