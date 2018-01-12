
//Marvel not that I said unto thee, Ye must be born again. (John 3:7)

package com.javarush.task.task38.task3812;

//import org.powermock.core.classloader.annotations.PrepareForTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@PrepareForTest
public @interface PrepareMyTest {
	Class<?>[] value() default Solution.class;

	String[] fullyQualifiedNames() default "";
}

/*
Обработка аннотаций

В классе Solution необходимо реализовать простейшую обработку аннотаций.



В методы printFullyQualifiedNames и printValues приходит класс. Если этот класс отмечен аннотацией PrepareMyTest, необходимо вывести на экран fullyQualifiedNames и values в соответствующих методах и вернуть true. Если же аннотация PrepareMyTest отсутствует - вернуть false.



Для вывода на экран классов из массива value используй сокращенное имя (getSimpleName).





Требования:

1. Метод printFullyQualifiedNames должен возвращать false в случае, если переданный в качестве параметра класс не отмечен аннотацией @PrepareMyTest.

2. Метод printValues должен возвращать false в случае, если переданный в качестве параметра класс не отмечен аннотацией @PrepareMyTest.

3. Метод printFullyQualifiedNames должен выводить на экран все элементы массива fullyQualifiedValues, и возвращать true, если полученный класс отмечен аннотацией @PrepareMyTest.

4. Метод printValues должен выводить на экран все элементы массива value используя их сокращенное имя, и возвращать true, если полученный класс отмечен аннотацией @PrepareMyTest.
*/
