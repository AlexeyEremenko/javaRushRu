
//And they asked him, and said unto him, Why baptizest thou then, if thou be not that Christ, nor Elias, neither that prophet? (John 1:25)





still unsolved yet





/*
AmigoSet (5)

Твое собственное множество AmigoSet реализует интерфейс Serializable. Однако, не сериализуется правильно.



1. Реализуй свою логику сериализации и десериализации.

Вспоминай, какие именно приватные методы нужно добавить, чтоб сериализация пошла по твоему сценарию.

Для сериализации:

* сериализуй сет

* сериализуй capacity и loadFactor у объекта map, они понадобятся для десериализации.

Т.к. эти данные ограничены пакетом, то воспользуйся утилитным классом HashMapReflectionHelper, чтобы достать их.



Для десериализации:

* вычитай все данные

* создай мапу используя конструктор с capacity и loadFactor



2. Помнишь, что такое transient?





Требования:

1. В классе AmigoSet должен содержаться private метод writeObject с одним параметром типа ObjectOutputStream.

2. В классе AmigoSet должен содержаться private метод readObject с одним параметром типа ObjectInputStream.

3. Объект сериализованный с помощью метода writeObject должен быть равен объекту десериализованному с помощью метода readObject.

4. В методе writeObject должен быть вызван метод defaultWriteObject на объекте типа ObjectOutputStream полученном в качестве параметра.

5. В методе readObject должен быть вызван метод defaultReadObject на объекте типа ObjectInputStream полученном в качестве параметра.
*/
