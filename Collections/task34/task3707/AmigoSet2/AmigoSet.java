
//Then said they unto him, Who art thou? that we may give an answer to them that sent us. What sayest thou of thyself? (John 1:22)

package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

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
AmigoSet (2)

Изобретать механизм работы с хешем не будем, он уже реализован во многих коллекциях.



Мы возьмем коллекцию HashMap и воспользуемся ей.



1. Создай приватную константу Object PRESENT, которую инициализируй объектом Object, это будет наша заглушка.



2. Создай private transient поле HashMap<E,Object> map. Список ключей будет нашим сэтом, а вместо значений будем пихать в мапу заглушку PRESENT.



Напомню, нам нужны только ключи, а вместо значений для всех ключей будем вставлять PRESENT. Там же должно что-то быть :)



Посмотрим, что из этого получится :)



Коллекции обычно имеют несколько конструкторов, поэтому:



3. Создай конструктор без параметров, в котором инициализируй поле map.



4. Создай конструктор с одним параметром Collection<? extends E> collection.



Для инициализации поля map воспользуйся конструктором, в который передается Capacity.



Вычисли свою Capacity по такой формуле: максимальное из 16 и (collection.size()/.75f)



Добавь все элементы из collection в нашу коллекцию.



Нужный метод добавления всех элементов у нас есть благодаря тому, что AbstractSet наследуется от AbstractCollection.



5. Напиши свою реализацию для метода метод add(E e): добавь в map элемент 'e' в качестве ключа и PRESENT в качестве значения.



Верни true, если был добавлен новый элемент, иначе верни false.





Требования:

1. В классе AmigoSet должно быть создано и инициализировано private static final поле PRESENT типа Object.

2. В классе AmigoSet должно быть создано private transient поле map типа HashMap.

3. В классе AmigoSet должен быть реализован в соответствии с условием конструктор без параметров.

4. В классе AmigoSet должен быть реализован в соответствии с условием конструктор с одним параметром типа Collection.

5. Метод add должен добавлять новый элемент в map используя полученный параметр в качестве ключа и объект PRESENT в качестве значения.

6. Метод add должен возвращать true в случае, если новый элемент был успешно добавлен, иначе - false
*/
