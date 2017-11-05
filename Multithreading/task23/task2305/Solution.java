
//But Mary was standing outside at the tomb weeping. So, as she wept, she stooped and looked into the tomb (John 20:11)

package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
     Solution[] result = new Solution[2];

        for (int i=0; i<2; i++) {
            result[i] = new Solution();
            result[i].innerClasses[0] = result [i].new InnerClass();
            result[i].innerClasses[1] = result [i].new InnerClass();
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
/*
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.

package com.javarush.task.task23.task2305;

* 
Inner
*
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        return null;
    }

    public static void main(String[] args) {

    }
}
*/
