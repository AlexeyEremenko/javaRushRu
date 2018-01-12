
//And the temple of God was opened in heaven, and there was seen in his temple the ark of his testament: and there were lightnings,
//and voices, and thunderings, and an earthquake, and great hail. (Revelation 11:19)

package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {

        if (s == null || s.length() == 0)
            return 0;

        ArrayList<Integer> lengths = new ArrayList<>();


        for (int ii = 0; ii < s.length(); ii++) {
            String current = s.substring(ii, s.length());

            StringBuffer sb = new StringBuffer();
            sb.append(current.charAt(0));
            exit:
            for (int i = 1; i < current.length(); i++) {
                for (int j = 0; j < sb.length(); j++)
                    if (sb.charAt(j) == current.charAt(i))
                        break exit;

                sb.append(current.charAt(i));
            }
            lengths.add(sb.toString().length());
        }

        return Collections.max(lengths);
    }
}

/*
Уникальные подстроки

Реализуй метод lengthOfLongestUniqueSubstring таким образом, чтобы он возвращал длину самой длинной подстроки без повторяющихся символов, найденной в строке полученной в качестве параметра.

Например, для строки "a123bcbcqwe" - 6, а для строки "ttttwt" - 2.

Если анализируемая строка пуста или равна null - верни 0.





Требования:

1. Метод lengthOfLongestUniqueSubstring должен возвращать длину подстроки с максимальным количеством уникальных символов.

2. Метод lengthOfLongestUniqueSubstring должен возвращать 0 для пустой строки, или строки равной null.

3. Метод lengthOfLongestUniqueSubstring должен быть публичным.

4. Метод lengthOfLongestUniqueSubstring должен быть статическим.
*/
