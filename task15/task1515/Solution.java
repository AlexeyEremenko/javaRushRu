package com.javarush.task.task15.task1515;

//It is good to not eat meat, drink wine, 
//nor do anything by which your brother stumbles, is offended, or is made weak. (Romans 14:21)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;

    public static final int MIN = min(A, B);
    
    static{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            A = Integer.parseInt(br.readLine());
            B = Integer.parseInt(br.readLine());
        }catch (IOException e) {e.printStackTrace();}
        
        try{
            br.close();
        }catch (IOException e) {e.printStackTrace();}
    }
    
    

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}






/*
Статики-2
1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.
3. Закрыть поток ввода методом close().


Требования:
1. Поле A должно быть статическим.
2. Поле B должно быть статическим.
3. Программа должна считывать данные с клавиатуры в статическом блоке.
4. Программа должна инициализировать поля A и B в статическом блоке согласно введенным с клавиатуры значениям.


*/
