
//The chief priests of the Jews therefore said to Pilate, "Don't write, 'The King of the Jews,' but, 'he said, I am King of the Jews.'" (John 19:21)

package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<Horse>();
    
    public Hippodrome(List<Horse> list) {
        this.horses = list;
    }
    
    public List<Horse> getHorses() {
        return this.horses;
    }
    public static void main(String[] args) {}
}
/*
Ипподром(3)
Несмотря на то что мы объявили переменную horses, сам список еще не создан (если ты конечно не успел опередить нас).
Создай конструктор класса Hippodrome с одним параметром типа List.
Сохрани в поле horses полученный в качестве параметра список (инициализируй поле horses).


Требования:
1. В классе Hippodrome должен быть создан конструктор с одним параметром типа List.
2. Должна существовать возможность создавать объекты типа Hippodrome извне класса с помощью оператора new.
3. Поле horses должно быть корректно инициализировано в конструкторе класса Hippodrome.

Ипподром(2)
Раз это ипподром, то на нем должны быть лошади.
Значит наш ипподром должен хранить список всех его лошадей.
Добавь поле horses типа List<Horse> в класс Hippodrome.
А чтобы лошадей не украли — сделай это поле приватным.
Добавь getter для этого поля.

Ипподром(1)
Сегодня мы напишем небольшую игру под названием «Ипподром«.
Когда я говорю мы — я имею ввиду тебя. Я же буду работать наставником.

Для начала нам понадобятся классы «ипподром» и «лошадь«.
Создай классы Hippodrome (ипподром), Horse (лошадь).

Также не забудь, что любая программа начинается с метода main.
Добавь его в класс Hippodrome.

package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<Horse>();
    
    public List<Horse> getHorses() {
        return this.horses;
    }
    public static void main(String[] args) {}
}
*/
