
//Of judgment, because the prince of this world is judged (John 16:11)

package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable{
    
    private Entry root;
    
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
    
    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }
}

/*
Построй дерево(3)
Класс описывающий дерево мы создали, теперь нужен класс описывающий тип элементов дерева:
1.  В классе CustomTree создай вложенный статический параметризированный класс Entry<T> с модификатором доступа по умолчанию.
2. Обеспечь поддержку этим классом интерфейса Serializable.
3. Создай такие поля (модификатор доступа по умолчанию):
- String elementName;
- int lineNumber;
- boolean availableToAddLeftChildren, availableToAddRightChildren;
- Entry<T> parent, leftChild, rightChild;
4. Реализуй публичный конструктор с одним параметром типа String:
- установи поле elementName равным полученному параметру;
- установи поле availableToAddLeftChildren равным true;
- установи поле availableToAddRightChildren равным true;
5. Реализуй метод void checkChildren, устанавливающий поле availableToAddLeftChildren в false, если leftChild не равен null и availableToAddRightChildren в false, если rightChild не равен null.
6. Реализуй метод boolean isAvailableToAddChildren, возвращающий дизъюнкцию полей availableToAddLeftChildren и availableToAddRightChildren.

Любое дерево начинается с корня, поэтому не забудь в класс CustomTree добавить поле root типа Entry<String> c модификатором доступа по умолчанию.


Требования:
1. Класс CustomTree.Entry должен быть объявлен с модификатором доступа по умолчанию.
2. Класс CustomTree.Entry должен поддерживать интерфейс Serializable.
3. В классе CustomTree.Entry должно существовать поле elementName типа String.
4. В классе CustomTree.Entry должно существовать поле lineNumber типа int.
5. В классе CustomTree.Entry должно существовать поле availableToAddLeftChildren типа boolean.
6. В классе CustomTree.Entry должно существовать поле availableToAddRightChildren типа boolean.
7. В классе CustomTree.Entry должно существовать поле parent типа Entry.
8. В классе CustomTree.Entry должно существовать поле leftChild типа Entry.
9. В классе CustomTree.Entry должно существовать поле rightChild типа Entry.
10. В классе CustomTree.Entry должен быть корректно реализован конструктор с одним параметром типа String (смотри условие).
11. В классе CustomTree.Entry должен корректно реализован метод checkChildren (смотри условие).
12. В классе CustomTree.Entry должен корректно реализован метод isAvailableToAddChildren (смотри условие).
13. В классе CustomTree должно существовать поле root типа Entry.
*/
