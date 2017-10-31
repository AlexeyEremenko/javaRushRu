
//Greet one another with a holy kiss. The assemblies of Christ greet you. (Romans 16:16)

-------------------------------------------------------Solution.java----------------------------------------------------------------
package com.javarush.task.task21.task2112;

public class Solution {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
            System.out.println("Entering the body of try block.");
            fakeConnection.usefulOperation();
            fakeConnection.unsupportedOperation();
        } catch (Exception e) {
        }
    }
}
------------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------DBConnectionManager.java-----------------------------------------------------
package com.javarush.task.task21.task2112;

public class DBConnectionManager {
    public FakeConnection getFakeConnection() {
        return new FakeConnection();
    }
}
------------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------FakeConnection.java----------------------------------------------------------
package com.javarush.task.task21.task2112;

public class FakeConnection implements AutoCloseable {

    public FakeConnection() {
        System.out.println("Creating database connection...");
    }

    public void unsupportedOperation() {
        System.out.println("Operation is not supported yet!");
        throw new RuntimeException("UnsupportedOperation!");
    }

    public void usefulOperation() {
        System.out.println("Executing useful operation.");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Closing database connection...");
    }
}
------------------------------------------------------------------------------------------------------------------------------------
/*
AutoCloseable и try-with-resources
В классе FakeConnection реализуй интерфейс AutoCloseable, чтобы объекты этого типа можно было использовать в try-with-resources.
Метод close() должен выводить на экран фразу «Closing database connection…»
В блоке try последовательно вызови методы usefulOperation() и unsupportedOperation().

Вывод на экран должен быть следующим:
Creating database connection...
Entering the body of try block.
Executing useful operation.
Operation is not supported yet!
Closing database connection...

Обрати внимание на то, что ресурсы были освобождены автоматически несмотря на исключение брошенное методом unsupportedOperation.


Требования:
1. Класс FakeConnection должен поддерживать интерфейс AutoCloseable.
2. Метод close класса FakeConnection должен выводить на экран фразу "Closing database connection...".
3. В методе main класса Solution должны быть вызваны методы usefulOperation и unsupportedOperation у объекта класса FakeConnection.
4. Вывод на экран должен соответствовать условию задачи.
5. Метод close класса FakeConnection не должен бывать вызван явно.

-------------------------------------------------------Solution.java----------------------------------------------------------------
package com.javarush.task.task21.task2112;

public class Solution {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
            System.out.println("Entering the body of try block.");
        } catch (Exception e) {
        }
    }
}

------------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------DBConnectionManager.java-----------------------------------------------------
package com.javarush.task.task21.task2112;

public class DBConnectionManager {
    public FakeConnection getFakeConnection() {
        return new FakeConnection();
    }
}
------------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------FakeConnection.java----------------------------------------------------------
package com.javarush.task.task21.task2112;

public class FakeConnection {

    public FakeConnection() {
        System.out.println("Creating database connection...");
    }

    public void unsupportedOperation() {
        System.out.println("Operation is not supported yet!");
        throw new RuntimeException("UnsupportedOperation!");
    }

    public void usefulOperation() {
        System.out.println("Executing useful operation.");
    }
}
------------------------------------------------------------------------------------------------------------------------------------


*/
