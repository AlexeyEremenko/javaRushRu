package com.javarush.task.task13.task1324;

//One man esteems one day as more important. Another esteems every day alike. 
//Let each man be fully assured in his own mind. (Romans 14:5)

import java.awt.*;

/* 
Один метод в классе
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        default Color getColor() {
            return null;
        }

        default Integer getAge(){
            return null;
        }
    }

    public static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}



/*
Один метод в классе
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод — getName.
3. Методы удалять нельзя!


Требования:
1. Интерфейс Animal должен быть реализован в классе Fox.
2. В классе Fox должен быть реализован только один метод(getName).
3. В интерфейсе Animal должен быть объявлен метод getColor.
4. Дополнительные классы или интерфейсы создавать нельзя.

package com.javarush.task.task13.task1324;

import java.awt.*;

/* 
Один метод в классе
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();

        Integer getAge();
    }

    public static class Fox {
        public String getName() {
            return "Fox";
        }
    }
}

*/
