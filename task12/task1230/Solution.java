package com.javarush.task.task12.task1230;

//Jesus answered him, "Will you lay down your life for me? 
//Most certainly I tell you, the rooster won't crow until you have denied me three times. (John 13:38)

/* 
Попадание в десятку
*/

public class Solution {
    public static void main(String[] args) {
        Integer i = 5;
        int x = transformValue(i);

        System.out.println(x);
    }

    public static int transformValue(int i) {
        return i * i;
    }
    
    public static int transformValue(Integer i) {
        return i + i;
    }
}



/*
Попадание в десятку
Добавь еще один метод, чтобы программа выводила на экран число 10.

Подсказка:
используй перегрузку методов.


Требования:
1. Класс Solution должен содержать три метода.
2. Перегруженный метод transformValue должен удваивать переданное в него число.
3. Тип и значение переменной i менять нельзя.
4. Тип и значение переменной x менять нельзя.
5. Команду вывода на экран менять нельзя.
6. Метод main должен вызывать метод transformValue только один раз.
7. Программа должна вывести на экран число 10.

package com.javarush.task.task12.task1230;

 
Попадание в десятку


public class Solution {
    public static void main(String[] args) {
        Integer i = 5;
        int x = transformValue(i);

        System.out.println(x);
    }

    public static int transformValue(int i) {
        return i * i;
    }
}
*/
