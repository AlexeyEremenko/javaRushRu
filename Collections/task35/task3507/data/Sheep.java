
//And they had tails like unto scorpions, and there were stings in their tails:
//and their power was to hurt men five months. (Revelation 9:10)

package com.javarush.task.task35.task3507.data;

import com.javarush.task.task35.task3507.Animal;

public class Sheep implements Animal {
    private Sheep() {
    }

    public Sheep(Integer integer) {
    }
}

/*
ClassLoader - что это такое?

Реализуй логику метода getAllAnimals.

Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.

Путь не обязательно содержит / в конце.

НЕ все классы наследуются от интерфейса Animal.

НЕ все классы имеют публичный конструктор без параметров.

Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.

Добавить созданные объекты в результирующий сет и вернуть.

Метод main не участвует в тестировании.





Требования:

1. Размер множества возвращаемого методом getAllAnimals должен быть равен количеству классов поддерживающих интерфейс Animal (среди классов расположенных в директории переданной в качестве параметра).

2. В множестве возвращаемом методом getAllAnimals должны присутствовать все классы поддерживающие интерфейс Animal и имеющие публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве параметра).

3. В множестве возвращаемом методом getAllAnimals НЕ должен присутствовать ни один класс не поддерживающий интерфейс Animal (среди классов расположенных в директории переданной в качестве параметра).

4. Метод getAllAnimals должен быть статическим.
*/