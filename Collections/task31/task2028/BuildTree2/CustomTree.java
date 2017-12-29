
//Of righteousness, because I go to my Father, and ye see me no more (John 16:10)

package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable{
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }



    public String get(int index) {
        throw new UnsupportedOperationException();
    }



    @Override
    public int size() {
        return 0;
    }


    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}

/*
Построй дерево(2)

Несмотря на то что наше дерево является потомком класса AbstractList, это не список в привычном понимании.

В частности нам недоступны принимающие в качестве параметра индекс элемента.

Такие методы необходимо переопределить и бросить новое исключение типа UnsupportedOperationException.



Вот их список:

public String get(int index)

public String set(int index, String element)

public void add(int index, String element)

public String remove(int index)

public List<String> subList(int fromIndex, int toIndex)

protected void removeRange(int fromIndex, int toIndex)

public boolean addAll(int index, Collection<? extends String> c)





Требования:

1. При попытке вызвать метод get(int index) должно возникать исключение типа UnsupportedOperationException.

2. При попытке вызвать метод set(int index, String element) должно возникать исключение типа UnsupportedOperationException.

3. При попытке вызвать метод add(int index, String element) должно возникать исключение типа UnsupportedOperationException.

4. При попытке вызвать метод String remove(int index) должно возникать исключение типа UnsupportedOperationException.

5. При попытке вызвать метод subList(int fromIndex, int toIndex) должно возникать исключение типа UnsupportedOperationException.

6. При попытке вызвать метод removeRange(int fromIndex, int toIndex) должно возникать исключение типа UnsupportedOperationException.

7. При попытке вызвать метод addAll(int index, Collection c) должно возникать исключение типа UnsupportedOperationException.

Построй дерево(1)

Амиго, похоже ты уже достаточно окреп. Самое время проверить свои навыки в большой задаче!

Сегодня реализуем свое дерево немного нестандартным способом(на базе AbstractList).

Вводную информацию можешь получить используя свой любимый поисковик и текст ниже.



Элементы дерева должны следовать так как показано на картинке:

http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg



Для начала сделаем наше дерево потомком класса AbstractList с параметром типа String, а также

реализуем интерфейсы Cloneable и Serializable.



Реализацию методов get(int index) и size() пока оставь стандартной.
*/
