
//And they had a king over them, which is the angel of the bottomless pit, whose name in the Hebrew tongue is Abaddon,
//but in the Greek tongue hath his name Apollyon. (Revelation 9:11)

package com.javarush.task.task35.task3508;

import java.util.List;

/* 
extends vs super
*/
public abstract class Solution {
    public abstract <T> void one(List<T> destination, List<T> source);

    public abstract <T> void two(List<T> destination, List<? extends T> source);

    public abstract <T> void three(List<? super T> destination, List<T> source);

    public abstract <T> void four(List<? super T> destination, List<? extends T> source);
}

/*
extends vs super

Логика всех методов - добавить source в destination.

!!!Расставь ?, extends и super где необходимо:!!!

1) one - должен работать с одним и тем же типом;

2) two - должен добавлять любых наследников типа T в список, умеющий хранить только тип T;

3) three - должен добавлять объекты типа T в любой список, параметризированный любым родительским классом;

4) four - должен добавлять любых наследников типа T в список, параметризированный любым родительским классом.

Не оставляй закомментированный код.





Требования:

1. Метод one должен быть изменен в соответствии с условием задачи.

2. Метод two должен быть изменен в соответствии с условием задачи.

3. Метод three должен быть изменен в соответствии с условием задачи.

4. Метод four должен быть изменен в соответствии с условием задачи.
*/
