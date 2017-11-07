
//He said to them, "Cast the net on the right side of the boat, and you will find some." They cast it therefore, and now they weren't able to draw it in for the multitude of fish. (John 21:6)

-----------------------------------------------Solution.java-------------------------------------------------------
package com.javarush.task.task24.task2408;

import java.util.List;

/* 
Как избежать Copy+Paste
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
-------------------------------------------------------------------------------------------------------------------


------------------------------------------------Mouse.java---------------------------------------------------------
package com.javarush.task.task24.task2408;

/*
обратите внимание, как именно Mouse отличается от Dog
Этот класс - привычный для вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}
-------------------------------------------------------------------------------------------------------------------


-------------------------------------------------Pet.java----------------------------------------------------------
package com.javarush.task.task24.task2408;

public interface Pet {
    public Sayable toSayable(int i);
}
-------------------------------------------------------------------------------------------------------------------


--------------------------------------------------Sayable.java-----------------------------------------------------
package com.javarush.task.task24.task2408;

public interface Sayable {
    String say();
}
-------------------------------------------------------------------------------------------------------------------


---------------------------------------------------Dog.java--------------------------------------------------------
package com.javarush.task.task24.task2408;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь другому классу, не интерфейсу :)))
Класс DogPet использует 2 класса - SuperDog и Dog, разберись с getName в классе DogPet
Так намного лучше, чем Copy+Paste!
 */
 
 import java.util.*;
 
public class Dog implements Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    /**
     * Если так получилось, что есть готовый класс А (тут SuperDog) с логикой, которую вы хотите использовать.
     * То возможны 3 способа:
     * 1) из класса А скопировать логику себе (это плохо, т.к. поддерживать несколько копий одного и того же кода проблематично)
     * 2) создать экземпляр класса А внутри нашего класса и использовать его, связь has-a (не всегда подходит, т.к. класс А сам по себе)
     * 3) создать внутренний класс, который наследуется от А, использовать его методы вместе с
     * методами и полями нашего класса, т.к. внутренний класс имеет доступ к своему родителю как наследник,
     * а также ко всем полям и методам включая private того класса, в который он вложен.
     * <p/>
     * Итак, разбираемся с п.3:
     * Внутри метода toSayable создайте class DogPet, который наследуется от SuperDog и реализует интерфейс Sayable
     * создайте метод private String getName(), который будет использовать логику двух классов - Dog и SuperDog.
     * Пусть этот метод возвращает имя собаки (класс Dog), которое с обеих сторон выделено getSuperQuotes (класс SuperDog)
     * Пример, " *** Барбос *** "
     * Логика метода say:
     * Если i < 1, то используя метод getName вывести на экран, что собака спит. Пример, " *** Шарик ***  спит."'
     * Иначе вывести фразу: "имя_собаки лает гааав! сегодняшняя_дата". Пример для i=3, " *** Тузик ***  лает гааав! 13-ноя-2013 Ср"
     * Для форматирования даты используйте formatter из класса SuperDog.
     * <p/>
     * <b>Пример вывода:</b>
     *  *** Барбос ***  лает гааааав! 13-ноя-2013 Ср
     *  *** Тузик ***  лает гаав! 13-ноя-2013 Ср
     *  *** Бобик ***  лает гааав! 13-ноя-2013 Ср
     * Мыша пищит.
     *  *** Шарик ***  спит.
     *
     * @param i количество букв 'а' в слове гав
     * @return экземпляр класса DogPet
     */
    public Sayable toSayable(final int i) {
        class DogPet extends SuperDog implements Sayable {

            private String getName() {
                return getSuperQuotes() + Dog.this.name + getSuperQuotes();
            }

            @Override
            public String say() {
                if (i < 1)
                    return getName() + " спит.";
                else {
                    StringBuffer sbuf = new StringBuffer();
                    for (int j = 0; j < i; j++)
                        sbuf.append("а");
                    return getName() + " лает г" + sbuf + "в! " + formatter.format(new Date());
                }
            }
        }
        return new DogPet();
    }
}
-------------------------------------------------------------------------------------------------------------------


----------------------------------------------------SuperDog.java--------------------------------------------------
package com.javarush.task.task24.task2408;

import java.text.SimpleDateFormat;

public abstract class SuperDog {
    protected String getSuperQuotes() {
        //some logic here
        return " *** ";
    }

    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy EEE");
}
-------------------------------------------------------------------------------------------------------------------


---------------------------------------------------Util.java-------------------------------------------------------
package com.javarush.task.task24.task2408;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает с классами Dog, Mouse.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Dog("Барбос"));
        pets.add(new Dog("Тузик"));
        pets.add(new Dog("Бобик"));
        pets.add(new Mouse());
        pets.add(new Dog("Шарик"));
        return pets;
    }

    public static List<Sayable> convertPetToSayable(List<Pet> pets) {
        List<Sayable> result = new LinkedList<>();
        for (Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toSayable(i));
        }
        return result;
    }
}
-------------------------------------------------------------------------------------------------------------------



/*
Как избежать Copy+Paste
В классе Dog реализуй логику метода toSayable, которая описана в джавадоке.


Требования:
1. В классе Dog должен быть реализован публичный метод toSayable с одним параметром типа int.
2. Метод toSayable должен возвращать объект типа Sayable.
3. Объект возвращаемый методом toSayable должен быть потомком класса SuperDog.
4. В случае, если параметр переданный в метод toSayable меньше 1, метод say должен вернуть строку с сообщением о том что собака спит (формат согласно javadoc).
5. В случае, если параметр переданный в метод toSayable больше либо равен 1, метод say должен вернуть строку с сообщением о том что собака лает и текущую дату (формат согласно javadoc).
6. Программа должна выводить данные на экран.
7. В методе getName класса DogPet должен быть вызван метод getSuperQuotes класса SuperDog.

-----------------------------------------------Solution.java-------------------------------------------------------
package com.javarush.task.task24.task2408;

import java.util.List;

/* 
Как избежать Copy+Paste
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
-------------------------------------------------------------------------------------------------------------------


------------------------------------------------Mouse.java---------------------------------------------------------
package com.javarush.task.task24.task2408;

/*
обратите внимание, как именно Mouse отличается от Dog
Этот класс - привычный для вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}
-------------------------------------------------------------------------------------------------------------------


-------------------------------------------------Pet.java----------------------------------------------------------
package com.javarush.task.task24.task2408;

public interface Pet {
    public Sayable toSayable(int i);
}
-------------------------------------------------------------------------------------------------------------------


--------------------------------------------------Sayable.java-----------------------------------------------------
package com.javarush.task.task24.task2408;

public interface Sayable {
    String say();
}
-------------------------------------------------------------------------------------------------------------------


---------------------------------------------------Dog.java--------------------------------------------------------
package com.javarush.task.task24.task2408;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь другому классу, не интерфейсу :)))
Класс DogPet использует 2 класса - SuperDog и Dog, разберись с getName в классе DogPet
Так намного лучше, чем Copy+Paste!
 */
public class Dog implements Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    /**
     * Если так получилось, что есть готовый класс А (тут SuperDog) с логикой, которую вы хотите использовать.
     * То возможны 3 способа:
     * 1) из класса А скопировать логику себе (это плохо, т.к. поддерживать несколько копий одного и того же кода проблематично)
     * 2) создать экземпляр класса А внутри нашего класса и использовать его, связь has-a (не всегда подходит, т.к. класс А сам по себе)
     * 3) создать внутренний класс, который наследуется от А, использовать его методы вместе с
     * методами и полями нашего класса, т.к. внутренний класс имеет доступ к своему родителю как наследник,
     * а также ко всем полям и методам включая private того класса, в который он вложен.
     * <p/>
     * Итак, разбираемся с п.3:
     * Внутри метода toSayable создайте class DogPet, который наследуется от SuperDog и реализует интерфейс Sayable
     * создайте метод private String getName(), который будет использовать логику двух классов - Dog и SuperDog.
     * Пусть этот метод возвращает имя собаки (класс Dog), которое с обеих сторон выделено getSuperQuotes (класс SuperDog)
     * Пример, " *** Барбос *** "
     * Логика метода say:
     * Если i < 1, то используя метод getName вывести на экран, что собака спит. Пример, " *** Шарик ***  спит."'
     * Иначе вывести фразу: "имя_собаки лает гааав! сегодняшняя_дата". Пример для i=3, " *** Тузик ***  лает гааав! 13-ноя-2013 Ср"
     * Для форматирования даты используйте formatter из класса SuperDog.
     * <p/>
     * <b>Пример вывода:</b>
     *  *** Барбос ***  лает гааааав! 13-ноя-2013 Ср
     *  *** Тузик ***  лает гаав! 13-ноя-2013 Ср
     *  *** Бобик ***  лает гааав! 13-ноя-2013 Ср
     * Мыша пищит.
     *  *** Шарик ***  спит.
     *
     * @param i количество букв 'а' в слове гав
     * @return экземпляр класса DogPet
     */
    public Sayable toSayable(final int i) {
       return null;
    }
}
-------------------------------------------------------------------------------------------------------------------


----------------------------------------------------SuperDog.java--------------------------------------------------
package com.javarush.task.task24.task2408;

import java.text.SimpleDateFormat;

public abstract class SuperDog {
    protected String getSuperQuotes() {
        //some logic here
        return " *** ";
    }

    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy EEE");
}
-------------------------------------------------------------------------------------------------------------------


---------------------------------------------------Util.java-------------------------------------------------------
package com.javarush.task.task24.task2408;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает с классами Dog, Mouse.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Dog("Барбос"));
        pets.add(new Dog("Тузик"));
        pets.add(new Dog("Бобик"));
        pets.add(new Mouse());
        pets.add(new Dog("Шарик"));
        return pets;
    }

    public static List<Sayable> convertPetToSayable(List<Pet> pets) {
        List<Sayable> result = new LinkedList<>();
        for (Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toSayable(i));
        }
        return result;
    }
}
-------------------------------------------------------------------------------------------------------------------


*/
