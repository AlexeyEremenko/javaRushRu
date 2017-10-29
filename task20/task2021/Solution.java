
//When Pilate therefore heard these words, he brought Jesus out, and sat down on the judgment seat at a place called "The Pavement," but in Hebrew, "Gabbatha." (John 19:13)

package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public void writeObject(ObjectOutputStream out) throws Exception {
            throw new NotSerializableException();
        }
        public void readObject(ObjectInputStream in) throws Exception {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
/*
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.


Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс SubSolution должен быть создан внутри класса Solution.
3. Класс SubSolution должен быть потомком класса Solution.
4. При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
5. При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.

package com.javarush.task.task20.task2021;

import java.io.*;

* 
Сериализация под запретом
*
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
    }

    public static void main(String[] args) {

    }
}
*/
