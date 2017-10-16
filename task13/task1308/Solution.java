package com.javarush.task.task13.task1308;

//Don't you believe that I am in the Father, and the Father in me? The words that I tell you, I speak not from myself;
//but the Father who lives in me does his works. (John 14:10)

/* 
Эй, ты там живой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
    
    interface Person {
        boolean isAlive();
    }
    
    interface Presentable extends Person {
        
    }
}



/*
Эй, ты там живой?
1. Создай интерфейс Person.
2. Добавь в него метод isAlive(), который проверяет, жив человек или нет.
3. Подумай, какой тип должен возвращать этот метод.
4. Создай интерфейс Presentable.
5. Унаследуй интерфейс Presentable от интерфейса Person.


Требования:
1. В классе Solution должен быть объявлен интерфейс Person.
2. В классе Solution должен быть объявлен интерфейс Presentable.
3. Интерфейс Presentable должен наследоваться от интерфейса Person.
4. В интерфейсе Person должен быть объявлен метод isAlive.
5. Тип возвращаемого значения метода isAlive может иметь только два значения.

package com.javarush.task.task13.task1308;

/* 
Эй, ты там живой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/
