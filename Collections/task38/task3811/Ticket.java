
//That which is born of the flesh is flesh; and that which is born of the Spirit is spirit. (John 3:6)

package com.javarush.task.task38.task3811;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jesus Lord Almighty
 * at 12.01.18
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Ticket {

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    Priority priority() default Priority.MEDIUM;

    String[] tags() default {};

    String name = "Amigo";
    String createdBy() default name;
}

/*
Тикеты

Реализуй в отдельном файле аннотацию Ticket.



Требования к ней следующие:

1) Должна быть доступна во время выполнения программы.

2) Применяться может только к новым типам данных.

3) Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.

4) Приоритет будет задавать свойство priority - по умолчанию Priority.MEDIUM.

5) Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.

6) Свойство createdBy будет строкой - по умолчанию Amigo.





Требования:

1. Аннотация Ticket должна быть доступна во время выполнения программы.

2. Аннотация Ticket должна применяться только к новым типам данных.

3. Аннотация Ticket должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.

4. Аннотация Ticket должна содержать свойство priority - по умолчанию Priority.MEDIUM.

5. Аннотация Ticket должна содержать свойство tags - массив строк, пустой по умолчанию.

6. Аннотация Ticket должна содержать свойство createdBy - строку, равную "Amigo" по умолчанию.
*/
