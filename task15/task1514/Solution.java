package com.javarush.task.task15.task1514;

//I am the vine. You are the branches. He who remains in me, and I in him, the same bears much fruit, 
//for apart from me you can do nothing. (John 15:5)

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    
    static {
        for (int i = 0; i<5; i++) {
            String string = "";
            string +=i;
            labels.put((double)i, string);
        }
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}






/*
Статики-1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.


Требования:
1. В классе Solution должен быть только один метод(main).
2. В классе Solution должно быть объявлено статическое поле labels типа Map.
3. Поле labels должно быть заполнен 5 различными парами ключ-значение в статическом блоке.
4. Метод main должен выводить содержимое labels на экран.

*/
