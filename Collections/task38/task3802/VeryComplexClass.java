
//When therefore he was risen from the dead, his disciples remembered that he had said this unto them; and they believed the scripture, and the word which Jesus had said. (John 2:22)

package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        FileReader reader = new FileReader("*.java");
    }

    public static void main(String[] args) {

    }
}

/*
Проверяемые исключения (checked exception)

Напиши реализацию метода veryComplexMethod().

Он должен всегда кидать какое-нибудь проверяемое исключение.

Кинуть исключение (throw) явно нельзя.





Требования:

1. Метод veryComplexMethod класса veryComplexClass не должен использовать ключевое слово throw.

2. Метод veryComplexMethod класса veryComplexClass должен бросать исключение.

3. Брошенное исключение НЕ должно быть исключением времени выполнения(RuntimeException).

4. Метод veryComplexMethod не должен быть приватным.
*/
