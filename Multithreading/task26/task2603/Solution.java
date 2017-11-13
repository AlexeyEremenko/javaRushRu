
//Nathanael said to him, "How do you know me?" Jesus answered him, "Before Philip called you, when you were under the fig tree, I saw you." (John 1:48)

package com.javarush.task.task26.task2603;

/* 
Убежденному убеждать других не трудно
*/

import java.util.Comparator;

public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T>
    {
        private Comparator<T> [] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) {
                    break;
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {

    }
}

/*
Убежденному убеждать других не трудно
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать массив компараторов.
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум один компаратор.


Требования:
1. Класс Solution должен содержать public static компаратор CustomizedComparator.
2. Класс CustomizedComparator должен содержать приватное поле comparators типа Comparator[].
3. Класс CustomizedComparator должен содержать конструктор с параметром vararg компараторов.
4. Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке, соответствующем последовательности компараторов comparators.

package com.javarush.task.task26.task2603;

* 
Убежденному убеждать других не трудно
*
public class Solution {

    public static void main(String[] args) {

    }
}
*/
