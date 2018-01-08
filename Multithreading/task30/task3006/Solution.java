
//And when the seven thunders had uttered their voices, I was about to write: and I heard a voice from heaven saying unto me, Seal up those things which the seven thunders uttered, and write them not. (Revelation 10:4)

package com.javarush.task.task30.task3006;

/* 
Swap по-новому
*/
public class Solution {
    public static void main(String[] args) {
        /* expected output
        x=4, y=5
        x=5, y=4
         */

        Pair pair = new Pair(4, 5);
        System.out.println(pair);
        pair.swap();
        System.out.println(pair);
    }
}

/*
Swap по-новому

В классе Pair реализуй метод swap, который должен для x, y менять местами их значения.

Можно использовать только операции:

1) Исключающее или.

2) Присваивание.

3) Исключающее или с присваиванием.

Не оставляй комментарии, не меняй остальной код.





Требования:

1. В классе Pair должен присутствовать метод swap().

2. В классе Pair в методе swap() используй только разрешенные операции.

3. Вызов метода swap() должен поменять значения полей x и y.

4. Не изменяй никакой код, кроме метода swap().
*/
