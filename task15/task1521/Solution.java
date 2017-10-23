
//I am the vine. You are the branches. He who remains in me, and I in him, the same bears much fruit, for apart from me you can do nothing. (John 15:5)

-------------------------------------------------------Solution.java----------------------------------------------------------
package com.javarush.task.task15.task1521;

import java.math.BigDecimal;

/* 
ООП. Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        
        //Блок 2.
        //Вызов для Object
        new Tree().info((Object)new Integer("4"));
        new Tree().info((Object)new Short("4"));
        new Tree().info((Object)new BigDecimal("4"));

        //Блок 3.
        //Вызов для Number
        new Tree().info(new Integer("4"));
        new Tree().info(new Short("4"));
        new Tree().info(new BigDecimal("4"));

        //Блок 4.
        //Вызов для String
        new Tree().info(new String("4"));
        new Tree().info(new Integer("4").toString());
        new Tree().info(new Short("4").toString());
        new Tree().info(new BigDecimal("4").toString());
    }
}

------------------------------------------------------------------------------------------------------------------------------



--------------------------------------------------------Tree.java-------------------------------------------------------------
package com.javarush.task.task15.task1521;

public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.println(String.format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName()));
    }
    
    public void info(Number s) {
        System.out.println(String.format("Дерево № %d , метод Number, параметр %s", number, s.getClass().getSimpleName()));
    }
    
    public void info(String s) {
        System.out.println(String.format("Дерево № %d , метод String, параметр %s", number, s.getClass().getSimpleName()));
    }
}

------------------------------------------------------------------------------------------------------------------------------





/*
ООП. Перегрузка
1. В классе Tree перегрузи метод info(Object s) два раза так, чтобы получилось три метода info(Object s), info(Number s), info(String s).
1.1. Разберись в методе info(Object s). Сделай по аналогии функционал новых методов.
1.2. Например, для метода info(Number s) результат может быть таким «Дерево № 123 , метод Number, параметр Short«.


Требования:
1. В классе Tree должен быть реализован метод info(Object s).
2. В классе Tree должен быть реализован метод info(Number s).
3. В классе Tree должен быть реализован метод info(String s).
4. Метод info(Number s) должен выводить на экран строку аналогичную строке из метода info(Object s), заменив лишь фразу("метод Object" на "метод Number").
5. Метод info(String s) должен выводить на экран строку аналогичную строке из метода info(Object s), заменив лишь фразу("метод Object" на "метод String").



package com.javarush.task.task15.task1521;

import java.math.BigDecimal;

* 
ООП. Перегрузка
*

public class Solution {
    public static void main(String[] args) {
        
        //Блок 2.
        //Вызов для Object
        new Tree().info((Object)new Integer("4"));
        new Tree().info((Object)new Short("4"));
        new Tree().info((Object)new BigDecimal("4"));

        //Блок 3.
        //Вызов для Number
        new Tree().info(new Integer("4"));
        new Tree().info(new Short("4"));
        new Tree().info(new BigDecimal("4"));

        //Блок 4.
        //Вызов для String
        new Tree().info(new String("4"));
        new Tree().info(new Integer("4").toString());
        new Tree().info(new Short("4").toString());
        new Tree().info(new BigDecimal("4").toString());
    }
}

*/