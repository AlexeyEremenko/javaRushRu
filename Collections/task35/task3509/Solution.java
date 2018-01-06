
//And to them it was given that they should not kill them, but that they should be tormented five months: and their torment was as the torment of a scorpion, when he striketh a man. (Revelation 9:5)

package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... entries) {
        ArrayList<T> list = new ArrayList<>();   //напишите тут ваш код
        for (T entry : entries)
            list.add(entry);
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... entries) {
        HashSet<T> set = new HashSet<>();    //напишите тут ваш код
        for (T entry : entries)
            set.add(entry);
        return set;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size())   //напишите тут ваш код
            throw new IllegalArgumentException();

        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}

/*
Collections & Generics

Реализуй вспомогательныe методы в классе Solution, которые должны создавать соответствующую коллекцию и помещать туда переданные объекты.

Методы newArrayList, newHashSet параметризируй типом T.

Метод newHashMap параметризируй типами К(ключ) и V(значение). Аргументы метода newHashMap должны принимать списки, в которых содержатся наследники типов K и V.

Возвращаемые коллекции должны быть такого же типа, что и переданные в метод объекты.



Подсказка: в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по размерам, в противном случае кинь IllegalArgumentException.





Требования:

1. Метод newArrayList должен быть параметризован типом Т.

2. Метод newArrayList должен возвращать ArrayList, который содержит переданные в метод объекты.

3. Метод newHashSet должен быть параметризован типом Т.

4. Метод newHashSet должен возвращать HashSet, который содержит переданные в метод объекты.

5. Метод newHashMap должен быть параметризован типом K и V.

6. Метод newHashMap должен возвращать HashMap, который содержит переданные в метод ключи и значения.

7. Метод newHashMap должен кидать IllegalArgumentException, если списки ключей и значений не совпадают по размеру.
*/
