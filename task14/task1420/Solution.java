
//Peace I leave with you. My peace I give to you; not as the world gives, give I to you. 
//Don't let your heart be troubled, neither let it be fearful. (John 14:27)


package com.javarush.task.task14.task1420;

import java.io.*;
/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        if (a <= 0) {
            throw new NumberFormatException();
        }

        int b = Integer.parseInt(bufferedReader.readLine());
        if (b <= 0) {
            throw new NumberFormatException();
        }

        System.out.println(Nod(a, b));
    }

    private static int Nod(int a, int b) {
        if (b == 0) {
            return a;
        }

        return Nod(b, a % b);
    }
}





/*
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.

package com.javarush.task.task14.task1420;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}

*/
