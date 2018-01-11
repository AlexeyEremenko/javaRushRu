
//Jesus answered and said unto him, Verily, verily, I say unto thee, Except a man be born again, he cannot see the kingdom of God. (John 3:3)

package com.javarush.task.task38.task3808;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@interface Main {

}

/*
Неверные аннотации

Исправь неверные аннотации. Код должен компилироваться без ошибок и предупреждений.



Избегай избыточности. Не нужно писать подряд все знакомые тебе аннотации.





Требования:

1. Аннотация @Main должна использоваться только для аннотирования методов.

2. Метод main класса Solution должен быть отмечен только аннотацией @Main.

3. Метод overriddenMethod класса SubSolution должен быть отмечен только аннотацией @Override.

4. В методе uncheckedCall должны быть подавлены unchecked warnings с помощью аннотации.
*/
