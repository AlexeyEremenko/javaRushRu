
//Nicodemus saith unto him, How can a man be born when he is old? can he enter the second time into his mother's womb, and be born? (John 3:4)

package com.javarush.task.task38.task3809;

import java.lang.reflect.Field;

public final class ReflectionAnnotationUtil {
    public static void check(Object someObject) throws IllegalAccessException {
        Class<?> testedClass = someObject.getClass();
        for (Field field : testedClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(LongPositive.class)) {
                processLongPositiveAnnotationField(someObject, testedClass, field);
            }
        }
    }

    private static void processLongPositiveAnnotationField(Object someObject, Class<?> testedClass, Field field) throws
            IllegalAccessException
    {
        field.setAccessible(true);
        Class<?> fieldType = field.getType();

        //assert type is long
        if (!fieldType.equals(long.class)) {
            String msg = String.format("Поле %s в классе %s имеет аннотацию LongPositive, но его тип %s.",
                    field.getName(), testedClass.getSimpleName(), fieldType.getSimpleName());
            System.out.println(msg);
            return;
        }

        //assert value is positive
        long value = (long) field.get(someObject);
        if (value <= 0) {
            String msg = String.format("Поле %s в классе %s имеет аннотацию LongPositive, но его значение не положительное.",
                    field.getName(), testedClass.getSimpleName());
            System.out.println(msg);
        }
    }
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
