
//Jesus answered, Verily, verily, I say unto thee, Except a man be born of water and of the Spirit, he cannot enter into the kingdom of God. (John 3:5)

package com.javarush.task.task38.task3810;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Changelog {
    Revision[] value(); //напиши свой код
}

/*
Реализуй аннотации

Проект должен компилироваться и выводить аннотацию класса Solution.

Класс Solution и его аннотацию не менять.

Аннотация Changelog должна быть видна во время выполнения.





Требования:

1. Вывод на экран должен соответствовать ожидаемому.

2. На экран должна быть выведена аннотация @Changelog класса Solution.

3. Аннотация @Changelog должна быть видна во время выполнения программы.

4. В классе Solution должен быть реализован метод main с одним параметром типа String[].
*/
