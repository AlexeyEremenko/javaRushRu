

//If you remain in me, and my words remain in you, you will ask whatever you desire, and it will be done for you. (John 15:7)

------------------------------------------------Solution.java------------------------------------------------------
package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    protected Solution () {}
    public Solution (int integer) {}
    Solution (double dooble) {}
    private Solution (float flot) {}
    
   
    
    
    public static void main(String[] args) {

    }
}
-------------------------------------------------------------------------------------------------------------------


-------------------------------------------------SubSolution.java--------------------------------------------------
package com.javarush.task.task15.task1523;


public class Subsolution extends Solution {
    
     public Subsolution(int ilove) {
        super(ilove);
    }
    protected Subsolution(double dabbl) {
        super(dabbl);
    }
    Subsolution() {        
    }    
}
-------------------------------------------------------------------------------------------------------------------





/*
Перегрузка конструкторов
1. В классе Solution создай 4 конструктора с разными модификаторами доступа.
2. В отдельном файле создай класс SubSolution и сделай его потомком класса Solution.
3. Внутри класса SubSolution создай конструкторы командой Alt+Insert -> Constructors.
4. Исправь модификаторы доступа конструкторов в SubSolution так, чтобы получилось 3 конструктора с различными модификаторами доступа(все кроме private).


Требования:
1. В классе SubSolution должно содержаться 3 различных конструктора.
2. В классе Solution должно содержаться 4 различных конструктора.
3. В классе Solution должны быть объявлены конструкторы со всеми возможными модификаторами доступа.
4. В классе SubSolution должны быть объявлены конструкторы со всеми возможными модификаторами доступа кроме private.
5. Класс Solution должен быть родителем класса SubSolution.

package com.javarush.task.task15.task1523;

* 
Перегрузка конструкторов
*

public class Solution {
    public static void main(String[] args) {

    }
}




*/
