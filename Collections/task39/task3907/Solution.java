
//And she brought forth a man child, who was to rule all nations with a rod of iron: and her child was caught up unto God, and to his throne. (Revelation 12:5)

package com.javarush.task.task39.task3907;

/* 
ISP
*/
public class Solution {
    public static void main(String[] args) {

    }
}

/*
ISP

Из-за того что интерфейс Worker содержит слишком много разноплановых методов, классам которые хотят поддерживать только часть функциональности, необходимо реализовывать и те методы, которые им на самом деле не нужны.

Было бы намного удобнее иметь несколько интерфейсов, каждый из которых описывал бы отдельную функциональность.



Создай интерфейсы Sleeper и Eater в пакете workers, подумай как провести корректный рефакторинг и внеси необходимые изменения.





Требования:

1. В интерфейсе Sleeper должен быть объявлен только метод sleep.

2. В интерфейсе Eater должен быть объявлен только метод eat.

3. В интерфейсе Worker должен остаться только метод work.

4. Класс NormalWorker должен поддерживать интерфейсы Worker, Sleeper, Eater.

5. Класс LazyPerson должен поддерживать только интерфейсы Sleeper, Eater.

6. Класс Robot должен поддерживать только интерфейс Worker.
*/