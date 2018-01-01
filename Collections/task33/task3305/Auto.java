
//But the rest of the dead lived not again until the thousand years were finished. This is the first resurrection. (Revelation 20:5)

package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RaceBike.class, name = "race-bike"),
        @JsonSubTypes.Type(value = Motorbike.class, name = "motorbike"),
        @JsonSubTypes.Type(value = Car.class, name = "car")

})
public abstract class Auto {
    protected String name;
    protected String owner;
    protected int age;
}

/*
Конвертация из одного класса в другой используя JSON

НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1



Расставь JSON аннотации так, чтобы результат выполнения метода main был следующим:

{

"className" : ".Parking",

"name" : "Super Parking",

"city" : "Kyiv",

"autos" : [ {

"className" : "com.javarush.task.task33.task3305.RaceBike",

"name" : "Simba",

"owner" : "Peter",

"age" : 2

}, {

"className" : "com.javarush.task.task33.task3305.Motorbike",

"name" : "Manny",

"owner" : null

}, {

"className" : "com.javarush.task.task33.task3305.Car"

} ]

}



Подсказка: это всего два класса.





Требования:

1. Вывод на экран должен соответствовать условию задачи.

2. Класс Parking должен быть отмечен аннотацией @JsonTypeInfo с подходящим набором параметров.

3. Класс Auto должен быть отмечен аннотацией @JsonTypeInfo с подходящим набором параметров.

4. Класс Auto должен быть отмечен аннотацией @JsonSubTypes с подходящим набором параметров.
*/
