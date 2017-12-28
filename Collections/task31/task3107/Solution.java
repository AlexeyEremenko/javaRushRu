
//And I saw a new heaven and a new earth: for the first heaven and the first earth were passed away; and there was no more sea. (Revelation 21:1)

package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {

        try {
            Path filePath = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(filePath), Files.isExecutable(filePath),
                    Files.isDirectory(filePath), Files.isWritable(filePath));

        } catch (Exception e) {
            fileData = new NullFileData (e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}

/*
Null Object Pattern
Почитай на вики про паттерн "Null Object".
Используй Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируй поле объектом NullFileData.


Требования:
1. Конструктор Solution должен инициализировать поле fileData объектом ConcreteFileData.
2. Если в конструкторе Solution возникла ошибка, нужно инициализировать поле fileData объектом NullFileData.
3. Конструктор Solution должен корректно устанавливать значение поля hidden у объекта ConcreteFileData.
4. Конструктор Solution должен корректно устанавливать значение поля executable у объекта ConcreteFileData.
5. Конструктор Solution должен корректно устанавливать значение поля directory у объекта ConcreteFileData.
6. Конструктор Solution должен корректно устанавливать значение поля writable у объекта ConcreteFileData.
*/
