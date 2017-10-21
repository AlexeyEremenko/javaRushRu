package com.javarush.task.task15.task1527;

// I have spoken these things to you, that my joy may remain in you, and that your joy may be made full. (John 15:11)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url = br.readLine();//add your code here
        int startPoint = 0;
        int checkPointIndex = 0;
        ArrayList<Integer> chckPts = new ArrayList<Integer>();

        for (int i = 0; i < url.length(); i++) {
            if ( url.charAt(i) == ('?') ) {startPoint = i+1;}
            if ( url.charAt(i) == ('&') ) {chckPts.add(checkPointIndex, i); checkPointIndex ++;}
        }

        ArrayList<String> parameters = new ArrayList<String>();
        boolean printObject = false;
        String objProperty = "";
        parameters.add(url.substring(startPoint, chckPts.get(0)));
        for (int i = 0; i < chckPts.size()-1; i++) {
            parameters.add(url.substring(chckPts.get(i)+1,chckPts.get(i+1)));}
        parameters.add(url.substring(chckPts.get(chckPts.size()-1)+1, url.length()));
        int pIndex = 0;
        for (String parameter : parameters) {
            if (parameter.contains("=")) {
                for (int i = 0; i < parameter.length(); i++) {
                    if (parameter.charAt(i) == '=') {
                        if (parameter.substring(0, i).equals("obj")) {
                            objProperty = (parameter.substring(i+1, parameter.length()));
                            //alert(parameter.substring(i+1, parameter.length()));
                            printObject = true; }

                        System.out.print(parameter.substring(0, i) + " " );
                        pIndex ++;
                    }
                }
            }
            else System.out.print(parameter + " ");
            pIndex ++;
        }
        if (!objProperty.equals("") && printObject == true) {
            try {
                alert(Double.parseDouble(objProperty));
            } catch (NumberFormatException e) {
                alert(objProperty);
            }
        }
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}





/*
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) — для чисел (дробные числа разделяются точкой)
alert(String value) — для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Программа должна выводить данные на экран в соответствии с условием.
3. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно преобразовано в число типа double.
4. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть корректно преобразовано в число типа double.

package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

* 
Парсер реквестов
*

public class Solution {
    public static void main(String[] args) {
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

*/
