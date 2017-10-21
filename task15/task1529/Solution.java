
//Greater love has no one than this, that someone lay down his life for his friends. (John 15:13)

--------------------------------------------------Solution.java---------------------------------------------------------------------
package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) throws Exception {

    }
    
    static {
        reset();
    }

    public static Flyable result;

    public static void reset() {
        
        try{   //add your code here - добавьте код тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();//add your code here - добавьте код тут
        
        if (string.equals("helicopter")) {result = new Helicopter();}
        else if (string.equals("plane")) {
            int passengersCount = Integer.parseInt(br.readLine());
            result = new Plane(passengersCount);
        }
        br.close();
        }catch (Exception e) {e.printStackTrace();}
    }
}
------------------------------------------------------------------------------------------------------------------------------------




---------------------------------------------------Flyable.java---------------------------------------------------------------------
package com.javarush.task.task15.task1529;

public interface Flyable {
    void fly();
}
------------------------------------------------------------------------------------------------------------------------------------



----------------------------------------------------Plane.java----------------------------------------------------------------------
package com.javarush.task.task15.task1529;

public class Plane implements Flyable {

    public Plane(int passengersCount) {
    }

    @Override
    public void fly() {

    }
}
------------------------------------------------------------------------------------------------------------------------------------




----------------------------------------------------Helicopter.java-----------------------------------------------------------------
package com.javarush.task.task15.task1529;

public class Helicopter implements Flyable {
    @Override
    public void fly() {

    }
}
------------------------------------------------------------------------------------------------------------------------------------





/*
Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь конструктор с параметром int — количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String.
3.2. Если параметр равен «helicopter«, то статическому объекту Flyable result присвоить объект класса Helicopter.
3.3. Если параметр равен «plane«, то считать второй параметр типа int(количество пассажиров), статическому объекту Flyable result присвоить объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
5. Закрыть поток ввода методом close().


Требования:
1. Класс Plane должен быть создан в отдельном файле и реализовывать интерфейс Flyable.
2. Класс Helicopter должен быть создан в отдельном файле и реализовывать интерфейс Flyable.
3. Класс Plane должен иметь конструктор с параметром int.
4. В классе Solution должен быть реализован статический метод reset.
5. Метод reset должен считывать строку с клавиатуры.
6. Если введенная строка равна "helicopter", в переменную result должен быть сохранен объект типа Helicopter.
7. Если введенная строка равна "plane", в переменную result должен быть сохранен объект типа Plane.
8. Поле result класса Solution должно быть инициализировано в статическом блоке путем вызова метода reset.


--------------------------------------------------Solution.java---------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------------------




--------------------------------------------------Flyable.java----------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------------------

*/
