
//So that you come behind in no gift; waiting for the coming of our Lord Jesus Christ: (1Cor 1:7)

package com.javarush.task.task22.task2205;

/* 
МНЕ нравится курс JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }
    public static String getFormattedString() {
        return "%3$2S %4$2s %2$2s %1$2s";
    }
}
/*
МНЕ нравится курс JavaRush
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Параметры должны меняться местами.

Должен быть вывод:
МНЕ нравится курс JavaRush


Требования:
1. Метод getFormattedString должен быть публичным.
2. Метод getFormattedString должен быть статическим.
3. Вывод на экран должен соответствовать условию задачи.
4. Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.

package com.javarush.task.task22.task2205;

* 
МНЕ нравится курс JavaRush
*
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }
    public static String getFormattedString() {
        return "";
    }
}
*/
