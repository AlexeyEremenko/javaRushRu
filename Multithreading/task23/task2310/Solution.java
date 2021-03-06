
//Jesus said to her, "Don't hold me, for I haven't yet ascended to my Father; but go to my brothers, and tell them, 'I am ascending to my Father and your Father, to my God and your God.'" (John 20:17)

package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void sout() {
        new Solution("sout") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("main").sout();
    }
}
/*
Напряги извилины!
Метод printName должен выводить свое собственное имя, т.е. «sout»
Сделайте минимум изменений.


Требования:
1. Вывод на экран должен соответствовать условию.
2. В классе Solution должен присутствовать метод sout без параметров.
3. В классе Solution должно присутствовать поле name.
4. Модификатор доступа метода getName должен быть расширен.

package com.javarush.task.task23.task2310;

* 
Напряги извилины!
*
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void sout() {
        new Solution("sout") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("main").sout();
    }
}
*/
