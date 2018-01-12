
//Nicodemus saith unto him, How can a man be born when he is old? can he enter the second time into his mother's womb, and be born? (John 3:4)

package com.javarush.task.task38.task3809;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface LongPositive {
}

/*
Annotation + Reflection

Разберись в коде и исправьте ошибку.

Ориентируйся на ожидаемый вывод.

Сделай минимально возможные изменения.





Требования:

1. Программа должна выводить данные на экран.

2. Вывод на экран должен соответствовать ожидаемому.

3. Аннотация(@interface) LongPositive должна быть отмечена двумя другими аннотациями.

4. Аннотация(@interface) LongPositive должна применяться только к полям.

5. Аннотация(@interface) LongPositive должна быть доступна во время выполнения программы.
*/
