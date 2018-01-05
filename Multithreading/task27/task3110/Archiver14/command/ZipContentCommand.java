
//No man hath seen God at any time; the only begotten Son, which is in the bosom of the Father, he hath declared him. (John 1:18)

package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> files = zipFileManager.getFilesList();
        for (FileProperties file : files) {
            ConsoleHelper.writeMessage(file.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}

/*
Archiver (14)

Все готово, чтобы реализовать метод execute() класса ZipContentCommand:

1. Выведи сообщение "Просмотр содержимого архива."

2. Создай объект класса ZipFileManager с помощью метода getZipFileManager()

3. Выведи сообщение "Содержимое архива:"

4. Получи список файлов архива с помощью метода getFilesList()

5. Выведи свойства каждого файла в консоль. Тут нам и пригодится ранее реализованный метод toString() класса FileProperties

6. Выведи сообщение "Содержимое архива прочитано."

7. Запусти программу и проверь, что команда "просмотреть содержимое архива" работает





Требования:

1. В методе execute класса ZipContentCommand нужно получить объект ZipFileManager.

2. В методе execute класса ZipContentCommand у объекта ZipFileManager нужно получить список файлов в архиве.

3. В методе execute класса ZipContentCommand нужно вывести свойства каждого файла в архиве на консоль.
*/
