
//And they asked him, What then? Art thou Elias? And he saith, I am not. Art thou that prophet? And he answered, No. (John 1:21)

package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set{

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

/*
AmigoSet (1)

Давай напишем какую-нибудь коллекцию. Пусть это будет твой собственный Set.

Пусть этот класс позволяет вставку NULL.



1. Создай класс AmigoSet. Пусть этот класс наследуется от AbstractSet.

Этот сэт должен поддерживать интерфейсы Serializable и Cloneable (как же без этого??).

Также очевидно, что он должен реализовывать интерфейс Set.



2. Этот класс должен работать с любыми типами, поэтому сделай его дженериком: добавь тип, например, E.

Стандартные буквы, которые используют для дженериков - это E (element), T (type), K (key), V (value).

Названия не принципиальны, но облегчают чтение кода.



3. Воспользуйся горячими клавишами Идеи и реализуй необходимые методы, оставь реализацию по умолчанию.





Требования:

1. Класс AmigoSet должен быть потомком класса AbstractSet.

2. Класс AmigoSet должен поддерживать интерфейсы Serializable, Cloneable и Set.

3. Класс AmigoSet должен быть дженериком.
*/
