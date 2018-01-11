
//And needed not that any should testify of man: for he knew what was in man (John 2:25)

package com.javarush.task.task38.task3805;

public class SolutionException extends Exception {
    public SolutionException() {
        super();
    }
    public SolutionException(String message) {
        super(message);
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
