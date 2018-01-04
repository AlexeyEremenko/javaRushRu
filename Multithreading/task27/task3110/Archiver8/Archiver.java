
//Which were born, not of blood, nor of the will of the flesh, nor of the will of man, but of God. (John 1:13) 

package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(String.format("\t %d - упаковать файлы в архив", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - добавить файл в архив", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - удалить файл из архива", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - распаковать архив", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - просмотреть содержимое архива", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - выход", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }

    public static void main(String[] args) {
/*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a full path for archive");
        String fullPathToArchive;
        ZipFileManager zipFileManager = null;
        try {
            fullPathToArchive = bufferedReader.readLine();
            zipFileManager = new ZipFileManager(Paths.get(fullPathToArchive));
        } catch (IOException e) {
        }

        System.out.println("Enter a full path for file");
        String fullPathToFile;
        try {
            fullPathToFile = bufferedReader.readLine();
            zipFileManager.createZip(Paths.get(fullPathToFile));
        } catch (Exception e) {
        }
        ExitCommand exitCommand = new ExitCommand();
        try {
            exitCommand.execute();
        }catch (Exception e) {}
*/
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != Operation.EXIT);
    }
}

/*
Archiver (8)

Чтобы узнать какую команду сейчас хочет выполнить пользователь, добавим метод Operation

askOperation() в класс Archiver. Этот метод должен вывести в консоль список доступных команд и

попросить выбрать одну из них. Для удобства будем просить ввести номер команды, где номер - это

порядковый номер команды в enum Operation. Получить порядковый номер значения в enum'е можно с помощью метода ordinal().

Теперь все готово чтобы переписать main, используя последние достижения науки и техники, а именно

класс CommandExecutor и метод askOperation().

1. Добавь публичный статический метод Operation askOperation() throws IOException в класс Archiver.

Он должен:

1.1. Использовать методы класса ConsoleHelper

1.2. Запрашивать у пользователя номер операции, которую он хочет совершить.



Подсказка:

чтобы вывести номер операции "Создать архив", используй: Operation.CREATE.ordinal()



1.3. Возвращать выбранную операцию.



Пример вывода метода askOperation():

Выберите операцию:

0 - упаковать файлы в архив

1 - добавить файл в архив

2 - удалить файл из архива

3 - распаковать архив

4 - просмотреть содержимое архива

5 - выход

2. Перепиши метод main():

2.1. Объяви локальную переменную типа Operation

2.2. В цикле запрашивай новое значение для переменной п.2.1. с помощью метода askOperation() и вызывай выполнение операции с помощью CommandExecutor.execute()

2.3. Обеспечь выход из цикла, если пользователь выбрал операцию Operation.EXIT

2.4. Оберни вызов askOperation() и execute(operation) в блок try-catch. Если произойдет исключение WrongZipFileException выведи сообщение "Вы не выбрали файл архива или выбрали неверный файл." с помощью ConsoleHelper, при любых других исключениях выводи "Произошла ошибка. Проверьте введенные данные.".

2.5. Проследи, чтобы программа продолжила свою работу (перешла на новый шаг цикла), после обработки исключений.

3. Запусти программу и проверь, что команда "выход" работает.





Требования:

1. В классе Archiver нужно создать публичный статический метод Operation askOperation().

2. Метод askOperation должен вывести в консоль все возможные операции и их номер.

3. Метод askOperation должен считать с клавиатуры номер выбранной операции и вернуть ее.

4. Перепиши метод main согласно заданию.
*/
