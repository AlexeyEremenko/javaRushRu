
//	But if thy brother be grieved with thy meat, now walkest thou not charitably. 
Destroy not him with thy meat, for whom Christ died. (Romans 14:15)

-----------------------------------------------Solution.java------------------------------------------------------------
package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            allMoney.add(new Hrivna(144000.0));//напишите тут ваш код
            allMoney.add(new USD(12000.0));
            allMoney.add(new Ruble(0.0));
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}

------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Money.java---------------------------------------------------------------
package com.javarush.task.task14.task1417;

public abstract class Money {
    
    private double amount;
    
    public Money(double amount) {
        this.amount = amount;
    }

    public double getAmount(){return amount;}

    public abstract String getCurrencyName();
}
------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Hrivna.java--------------------------------------------------------------
package com.javarush.task.task14.task1417;


public class Hrivna extends Money {
    
    public Hrivna (double amount) {super(amount);}
    
    public String getCurrencyName() {return "HRN";}
}
------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------USD.java-----------------------------------------------------------------
package com.javarush.task.task14.task1417;


public class USD extends Money {
    
    public USD (double amount) {super(amount);}
    
    public String getCurrencyName() {return "USD";}
}
------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ruble.java---------------------------------------------------------------
package com.javarush.task.task14.task1417;


public class Ruble extends Money {
    
    public Ruble (double amount) {super(amount);}
    
    public String getCurrencyName() {return "RUB";}
}
------------------------------------------------------------------------------------------------------------------------






/*
Валюты
Расширить функциональность программы, которая позволит производить манипуляции с валютами.

1. В абстрактном классе Money создай приватное поле amount типа double.
2. Создай публичный геттер для поля amount(public double getAmount()), чтобы к этому полю можно было получить доступ извне класса Money.
3. В отдельном файле создай классы Hrivna, Ruble и USD, которые будут являться потомками класса Money.
4. В классах Hrivna, Ruble и USD реализуй метод getCurrencyName который будет возвращать название соответствующей валюты(строку) в виде аббревиатуры(USD, HRN, RUB).
5. В классах Hrivna, Ruble и USD реализуй публичный(public) конструктор, который принимает один параметр и вызывает конструктор базового класса(super) с этим параметром.
6. Заполни список allMoney объектами всех возможных, в рамках условия задачи и функциональности программы, валют.


Требования:
1. В классе Money должно содержаться приватное поле amount типа double.
2. В классе Money должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение переменной amount согласно переданному параметру.
3. В классе Money должен быть реализован публичный метод getAmount, который будет возвращать значение поля amount.
4. Классы Hrivna, Ruble и USD должны быть потомками класса Money и существовать в отдельных файлах.
5. В классах Hrivna, Ruble и USD должен быть реализован метод getCurrencyName.
6. Метод getCurrencyName должен возвращать название соответствующей валюты(строку) в виде аббревиатуры(USD, HRN, RUB).
7. В классах Hrivna, Ruble и USD должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение поля amount класса Money путем вызова конструктора класса родителя c тем же параметром.

-----------------------------------------------Solution.java------------------------------------------------------------
package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //напишите тут ваш код
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Money.java---------------------------------------------------------------
package com.javarush.task.task14.task1417;

public abstract class Money {
    public Money(double amount) {
    }

    public abstract double getAmount();

    public abstract String getCurrencyName();
}
------------------------------------------------------------------------------------------------------------------------
*/
