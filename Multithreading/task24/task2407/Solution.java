
//For it is written, I will destroy the wisdom of the wise, and will bring to nothing the understanding of the prudent. (1Cor 1:19)

-------------------------------------------------Solution.java--------------------------------------------------
package com.javarush.task.task24.task2407;

import java.util.List;

/* 
Реализация интерфейса используя локальный класс
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
----------------------------------------------------------------------------------------------------------------


--------------------------------------------------Cat.java------------------------------------------------------
package com.javarush.task.task24.task2407;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i <= 0, то вывести на экран, что кот спит. Пример, "Васька спит."'
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {
        class CatPet implements Sayable {

            @Override
            public String say() {
                if (i < 1 )
                    return Cat.this.name+" спит.";
                else {
                    StringBuffer sbuf = new StringBuffer();
                    for (int j=0; j<i; j++)
                        sbuf.append("я");

                    return Cat.this.name + " говорит м"+sbuf+"у!";
                }
            }
        };
        return new CatPet ();
    }
}
----------------------------------------------------------------------------------------------------------------


---------------------------------------------------Mouse.java---------------------------------------------------
package com.javarush.task.task24.task2407;

/*
обратите внимание, как именно Mouse отличается от Cat
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
----------------------------------------------------------------------------------------------------------------


---------------------------------------------------Pet.java-----------------------------------------------------
package com.javarush.task.task24.task2407;

public interface Pet {
    public Sayable toSayable(int i);
}
----------------------------------------------------------------------------------------------------------------


----------------------------------------------------Sayable.java------------------------------------------------
package com.javarush.task.task24.task2407;

public interface Sayable {
    String say();
}
----------------------------------------------------------------------------------------------------------------


----------------------------------------------------Util.java---------------------------------------------------
package com.javarush.task.task24.task2407;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает со всеми классами Cat, Mouse. А ведь Mouse отличается от Cat.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Cat("Мурзик"));
        pets.add(new Cat("Васька"));
        pets.add(new Cat("Кошка"));
        pets.add(new Mouse());
        pets.add(new Cat("Томас"));
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
----------------------------------------------------------------------------------------------------------------

/*
Реализация интерфейса используя локальный класс
В классе Cat реализуй логику метода toSayable, которая описана в джавадоке.


Требования:
1. В классе Cat должен быть реализован публичный метод toSayable с одним параметром типа int.
2. Метод toSayable должен возвращать объект типа Sayable.
3. Если полученный параметр меньше 1, метод say() должен вернуть строку формата: "name спит.", где name - имя текущего кота.
4. Если полученный параметр больше либо равен 1, метод say() должен вернуть строку формата: "name говорит мяяяу!", где name - имя текущего кота, а количество букв "я" в слове "мяяяу" равно полученному параметру.
5. Программа должна выводить данные на экран.

-------------------------------------------------Solution.java--------------------------------------------------
package com.javarush.task.task24.task2407;

import java.util.List;

/* 
Реализация интерфейса используя локальный класс
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
----------------------------------------------------------------------------------------------------------------


--------------------------------------------------Cat.java------------------------------------------------------
package com.javarush.task.task24.task2407;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i <= 0, то вывести на экран, что кот спит. Пример, "Васька спит."'
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {
        return null;
    }
}
----------------------------------------------------------------------------------------------------------------


---------------------------------------------------Mouse.java---------------------------------------------------
package com.javarush.task.task24.task2407;

/*
обратите внимание, как именно Mouse отличается от Cat
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
----------------------------------------------------------------------------------------------------------------


---------------------------------------------------Pet.java-----------------------------------------------------
package com.javarush.task.task24.task2407;

public interface Pet {
    public Sayable toSayable(int i);
}
----------------------------------------------------------------------------------------------------------------


----------------------------------------------------Sayable.java------------------------------------------------
package com.javarush.task.task24.task2407;

public interface Sayable {
    String say();
}
----------------------------------------------------------------------------------------------------------------


----------------------------------------------------Util.java---------------------------------------------------
package com.javarush.task.task24.task2407;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает со всеми классами Cat, Mouse. А ведь Mouse отличается от Cat.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Cat("Мурзик"));
        pets.add(new Cat("Васька"));
        pets.add(new Cat("Кошка"));
        pets.add(new Mouse());
        pets.add(new Cat("Томас"));
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
----------------------------------------------------------------------------------------------------------------
*/
