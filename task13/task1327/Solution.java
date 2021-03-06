

//Yet a little while, and the world will see me no more; but you will see me. Because I live, you will live also. (John 14:19)

----------------------------------------------Solution.java---------------------------------------------------
    package com.javarush.task.task13.task1327;

import java.util.ArrayList;
import java.util.List;

/* 
Репка
*/

public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }
}

--------------------------------------------------------------------------------------------------------------
    
    
----------------------------------------------Person.java-----------------------------------------------------
 package com.javarush.task.task13.task1327;

public class Person implements RepkaItem {
    private String name;
    private String namePadezh;
    public String getNamePadezh() {return namePadezh;}

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }
    
    public void pull(Person person) {System.out.println(name + " за " + person.getNamePadezh());}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // public String getNamePadezh() {
    //    return namePadezh;
    //}

    public void setNamePadezh(String namePadezh) {
        this.namePadezh = namePadezh;
    }
}
   
--------------------------------------------------------------------------------------------------------------
    
    
----------------------------------------------RepkaItem.java--------------------------------------------------
    package com.javarush.task.task13.task1327;

public interface RepkaItem {
    public String getNamePadezh();
}

--------------------------------------------------------------------------------------------------------------
    
    
----------------------------------------------RepkaStory.java-------------------------------------------------
    package com.javarush.task.task13.task1327;

import java.util.List;

public class RepkaStory {
    static void tell(List<Person> items) {
        Person first;
        Person second;
        for (int i = items.size() - 1; i > 0; i--) {
            first = items.get(i - 1);
            second = items.get(i);
            second.pull(first);
        }
    }
}
--------------------------------------------------------------------------------------------------------------    





/*
Репка
Сказка Репка:
1. Реализовать интерфейс RepkaItem в классе Person.
2. В классе Person реализовать метод pull(Person person), который выводит фразу типа ‘<name> за <person>‘.

Пример:
Бабка за Дедку
Дедка за Репку

3. Исправить логическую ошибку цикла в методе tell класса RepkaStory.
4. Выполнить метод main и наслаждаться сказкой!


Требования:
1. Интерфейс RepkaItem должен быть реализован в классе Person.
2. В классе Person должен быть реализован метод pull c одним параметром типа Person.
3. Метод pull в классе Person должен выводить на экран фразу типа ' за '. Например: Бабка за Дедку.
4. В результате выполнения метода main на экран должен быть выведен краткий вариант сказки про Репку.

package com.javarush.task.task13.task1327;

import java.util.ArrayList;
import java.util.List;

/* 
Репка
*/



----------------------------------------------Solution.java---------------------------------------------------
    public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }
}
--------------------------------------------------------------------------------------------------------------
    
    
----------------------------------------------Person.java-----------------------------------------------------
    package com.javarush.task.task13.task1327;

public class Person {
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePadezh() {
        return namePadezh;
    }

    public void setNamePadezh(String namePadezh) {
        this.namePadezh = namePadezh;
    }
}

--------------------------------------------------------------------------------------------------------------
    
    
----------------------------------------------RepkaItem.java--------------------------------------------------
    package com.javarush.task.task13.task1327;

public interface RepkaItem {
    public String getNamePadezh();
}

--------------------------------------------------------------------------------------------------------------
    
    
----------------------------------------------RepkaStory.java-------------------------------------------------
    package com.javarush.task.task13.task1327;

import java.util.List;

public class RepkaStory {
    static void tell(List<Person> items) {
        Person first;
        Person second;
        for (int i = items.size() - 1; i > 0; i--) {
            first = items.get(i - 1);
            second = items.get(i);
            first.pull(second);
        }
    }
}

--------------------------------------------------------------------------------------------------------------

*/
