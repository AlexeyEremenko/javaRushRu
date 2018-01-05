
//And they which were sent were of the Pharisees (John 1:24)

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
        Set<E> keySet = map.keySet();
        return keySet.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return super.remove(o);
    }

    @Override
    public Object clone() {

        AmigoSet dollySheep;

        try {
             dollySheep = (AmigoSet) super.clone();
            dollySheep.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError(e);
        }

        return dollySheep;
    }
}

/*
AmigoSet (4)

Твое собственное множество AmigoSet реализует интерфейс Cloneable. Однако, не клонируется правильно.

Напиши свою реализацию метода Object clone(), сделай поверхностное клонирование.



* Клонируй множество, клонируй map.

* В случае возникновения исключений выбрось InternalError.

* Убери лишнее пробрасывание исключения.



Расширь модификатор доступа до public.





Требования:

1. В классе AmigoSet метод clone должен иметь уровень доступа public.

2. В случае возникновения исключений в процессе клонирования должно быть брошено исключение InternalError.

3. В классе AmigoSet метод clone должен быть реализован в соответствии с условием задачи.
*/
