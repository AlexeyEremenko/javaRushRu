
//And needed not that any should testify of man: for he knew what was in man (John 2:25)

package com.javarush.task.task38.task3805;

/* 
Улучшения в Java 7 (multiple exceptions)
*/

package com.javarush.task.task38.task3805;

public class ConnectionMock implements Connection {
    @Override
    public void connect() throws WrongDataException, ConnectionException {
    }

    @Override
    public void write(Object data) throws WrongDataException, ConnectionException {
    }

    @Override
    public Object read() throws WrongDataException, ConnectionException {
        return null;
    }

    @Override
    public void disconnect() throws WrongDataException, ConnectionException {

    }
}

/*
Улучшения в Java 7 (multiple exceptions)

Перепиши реализации методов класса Solution.

Используй нововведения (multiple exceptions), касающиеся обработки исключений, которые были добавлены в Java 7.





Требования:

1. В конструкторе класса Solution в одном catch блоке должны быть обработаны исключения WrongDataException и ConnectionException.

2. В методе write в одном catch блоке должны быть обработаны исключения WrongDataException и ConnectionException.

3. В методе read в одном catch блоке должны быть обработаны исключения WrongDataException и ConnectionException.

4. В методе disconnect в одном catch блоке должны быть обработаны исключения WrongDataException и ConnectionException.
*/
