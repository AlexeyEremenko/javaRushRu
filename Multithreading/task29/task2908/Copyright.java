
//But this happened so that the word may be fulfilled which was written in their law, 'They hated me without a cause.' (John 15:25)

package com.javarush.task.task29.task2908;

public class Copyright implements Computable<Copyright.Period, String> {
    @Override
    public String compute(Period period) throws InterruptedException {
        return "All rights reserved (c) " + period.firstYear + "-" + period.secondYear;
    }

    public static class Period {
        int firstYear;
        int secondYear;

        public Period(int firstYear, int secondYear) {
            this.firstYear = firstYear;
            this.secondYear = secondYear;
        }

        @Override
        public String toString() {
            return "Period{" +
                    "firstYear=" + firstYear +
                    ", secondYear=" + secondYear +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Period)) return false;

            Period period = (Period) o;

            if (firstYear != period.firstYear) return false;
            if (secondYear != period.secondYear) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = firstYear;
            result = 31 * result + secondYear;
            return result;
        }
    }
}

/*
Кеширование

В CacheComputeManager реализуй логику пустого метода.

Догадайся, что он должен делать по названию метода и по логике класса.





Требования:

1. Метод createFutureTaskForNewArgumentThatHaveToComputeValue должен создавать и возвращать объект типа FutureTask.

2. В методе createFutureTaskForNewArgumentThatHaveToComputeValue должен создаваться объект анонимного класса, реализующего интерфейс Callable.

3. Внутри метода createFutureTaskForNewArgumentThatHaveToComputeValue должна встречаться строка "return computable.compute(arg);".

4. Программа должна выводить текст указанный в комментариях в классе Solution.
*/
