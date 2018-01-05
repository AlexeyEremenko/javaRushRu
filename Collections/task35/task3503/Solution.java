
//And there came out of the smoke locusts upon the earth: and unto them was given power, as the scorpions of the earth have power. (John 9:3)

package com.javarush.task.task35.task3503;

/* 
Несколько суперклассов для дженерика
*/
public class Solution<T extends ClassForGenerics & InterfaceForGenerics> {
    public static void main(String[] args) {
        Solution<TestClassGood> testClassSolution = new Solution<>();
        testClassSolution.check(); 
    }

    public void check() {
        System.out.println("Works!");
    }

    public static class TestClassGood extends ClassForGenerics implements InterfaceForGenerics {

    }

    public static class TestClassWrong1 extends ClassForGenerics {

    }

    public static class TestClassWrong2 implements InterfaceForGenerics {

    }

}

/*
Несколько суперклассов для дженерика

Дан класс Solution, параметризированный T.

Ограничьте параметр T.

T должен быть наследником класса ClassForGenerics и одновременно реализовывать интерфейс InterfaceForGenerics.

Менять можно только класс Solution.





Требования:

1. Класс Solution должен быть параметризирован типом который является наследником класса ClassForGenerics и одновременно реализовывать интерфейс InterfaceForGenerics.

2. Интерфейс InterfaceForGenerics не должен расширять другие интерфейсы.

3. Класс ClassForGenerics не должен поддерживать интерфейс InterfaceForGenerics.

4. Класс Solution не должен быть наследником класса ClassForGenerics.
*/
