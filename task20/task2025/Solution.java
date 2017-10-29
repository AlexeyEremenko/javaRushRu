
//He went out, bearing his cross, to the place called "The Place of a Skull," which is called in Hebrew, "Golgotha" (John 19:17)

package com.javarush.task.task20.task2025;

/* 
Алгоритмы-числа
*/

import java.util.TreeSet;

public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        TreeSet<Long> numbers = new TreeSet<>();

        final int level = 12;                            //  array of levels (степень)
        long[][] pList = new long[level][level];

        
        int[] lst = new int[20];                         // couple of numbers


        label:
        for (long i = 1; i < N; i++) {
            
            //rejecting the numbers in which the sum of the digits is the same
             // receiving the couple of numbers in the form of an array
            long x = i;
            int lengthCounter = 0;
            int current;
            int last = Integer.MAX_VALUE;
            while (x != 0) {
                current = (int) (x % 10);
                if ((current != 0 && last != 0) && last < current)
                    continue label;
                last = current;
                lst[lengthCounter] = current;
                x = x / 10;
                lengthCounter++;
            }

            //counting the degrees, and fill them in the table of degrees
            
            //Find the sum of the digits of the number
            long summa1 = 0;
            for (int j = 0; j < lengthCounter; j++) {
                if (pList[lst[j]][lengthCounter] == 0) {// If the degree array does not already have a value
                    long a1 = lst[j];
                    if (a1 != 0 && a1 != 1) {          // If the digit is 0 or 1, then there is no point in considering the degree
                        long a2 = lst[j];
                        for (int jj = 1; jj < lengthCounter; jj++) //counting degree
                            a1 *= a2;
                    }
                    pList[lst[j]][lengthCounter] = a1;// Add a new value to the array of degrees
                }
                summa1 += pList[lst[j]][lengthCounter];
            }
            

            //receiving the couple of degrees
            
            long xx = summa1;
            lengthCounter = 0;
            while (xx != 0) {
                lst[lengthCounter] = (int) (xx % 10);
                lengthCounter++;
                xx = xx / 10;
            }

            //From the received sum we take the sum of degrees, for check on the number of amstrings
            long summa2 = 0;
            for (int j = 0; j < lengthCounter; j++) {
                if (pList[lst[j]][lengthCounter] == 0) { // If the degree array does not already have a value
                    long a1 = lst[j];
                    if (a1 != 0 && a1 != 1) {          
                        long a2 = lst[j];
                        for (int jj = 1; jj < lengthCounter; jj++) //counting the degree
                            a1 *= a2;
                    }
                    pList[lst[j]][lengthCounter] = a1;// Add a new value to the array of degrees
                }
                summa2 += pList[lst[j]][lengthCounter];
            }

            //adding the result
            if (summa1 == summa2 && summa1 < N)
                numbers.add(summa1);
        }
        result = new long[numbers.size()];

        int count = 0;
        for (Long l : numbers) {
            result[count] = l;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
       
        int n = 999999999;
        long[] lst = getNumbers(n);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i = 0; i < lst.length; i++) {
            System.out.print(lst[i] + ", ");
        }
        System.out.println();
    }
}
/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.


Требования:
1. В классе Solution должен присутствовать метод getNumbers c одним параметром типа long.
2. Метод getNumbers должен быть публичным.
3. Метод getNumbers должен быть статическим.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.

package com.javarush.task.task20.task2025;

* 
Алгоритмы-числа
*
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        return result;
    }

    public static void main(String[] args) {

    }
}
*/
