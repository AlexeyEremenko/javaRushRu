
//The same came to him by night, and said to him, "Rabbi, we know that you are a teacher come from God, for no one can do these signs that you do, unless God is with him." (John 3:2)

package com.javarush.task.task38.task3807;

/* 
Предопределенные типы аннотаций (Predefined Annotation Types)
*/

@Deprecated
public class Solution {

    @Deprecated
    private String[] arguments;

    @Deprecated
    @SafeVarargs
    public Solution(String... arguments) {
        this.arguments = arguments;
    }

    @Deprecated
    public void voidMethod() throws Exception {
    }

    @Deprecated
    public static void main(String[] args) throws Exception {
        new Solution().new SubSolution().voidMethod();
    }

    @Deprecated
    class SubSolution extends Solution {

        @Override
        @Deprecated
        public void voidMethod() throws Exception {
            super.voidMethod();
        }
    }
}

/*
Предопределенные типы аннотаций (Predefined Annotation Types)

Расставь в этом классе, везде где только можно, все возможные предопределенные в Java аннотации.

Не должно быть избыточности.





Требования:

1. Класс Solution должен быть отмечен аннотацией @Deprecated.

2. Класс SubSolution должен быть отмечен аннотацией @Deprecated.

3. Поле arguments должно быть отмечено аннотацией @Deprecated.

4. Метод main должен быть отмечен аннотацией @Deprecated.

5. Метод voidMethod класса Solution должен быть отмечен аннотацией @Deprecated.

6. Метод voidMethod класса SubSolution должен быть отмечен аннотациями @Deprecated и @Override.

7. Конструктор класса Solution должен быть отмечен аннотациями @Deprecated и @SafeVarargs.
*/
