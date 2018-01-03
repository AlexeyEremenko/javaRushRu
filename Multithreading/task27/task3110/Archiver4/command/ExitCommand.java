
//That was the true Light, which lighteth every man that cometh into the world. (John 1:9)

package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;

public class ExitCommand implements Command {

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}

/*
Archiver (4)

Каждая команда подразумевает выполнение каких-то действий. Создадим интерфейс Command, с

методом execute() (execute - "выполнить" по-английски). Для каждой команды мы создадим свой собственный класс. Все классы команд должны реализовывать (быть унаследованы) интерфейс Command.

Так как команд будет много, отведем для них отдельный пакет command. Все интерфейсы и реализации команд будем хранить именно в нем.

Самая простая команда - это выход EXIT, с нее и начнем.

1. Создай пакет command

2. В нем объявить интерфейс Command

3. Добавь метод void execute() throws Exception в интерфейс Command

4. Объяви класс ExitCommand, реализующий интерфейс Command

5. Реализуй метод execute() в классе ExitCommand, он должен выводить "До встречи!" с помощью

метода из класса ConsoleHelper

6. В самом конце метода main в класса Archiver добавь код, который создает объект типа ExitCommand и вызывает у него метод execute()

7. Попробуй, как это все работает

Обрати внимание, что все файлы проекта должны быть в кодировке UTF-8. Кодировку в IntelliJ IDEA можно задать через пункты меню Settings -> Editor -> File Encodings. Проверь, что все три поля отвечающие за кодировку выставлены в UTF-8.





Требования:

1. В пакете command должен быть создан интерфейс Command.

2. В Command должен быть объявлен метод void execute() throws Exception.

3. Создай класс ExitCommand в пакете command. Он должен реализовывать Command.

4. Метод execute в классе ExitCommand должен выводить в консоль "“До встречи!”" с использованием ConsoleHelper.

5. В конце main нужно добавить создание объекта ExitCommand и вызов у него метода execute.

Archiver (3)

Как видишь, архивировать оказалось не так уж и сложно. Но наш архиватор получился каким-то уж

слишком примитивным. Настоящий архиватор должен уметь гораздо больше: распаковку архива,

добавление нового файла в существующий архив, удаление файла из архива, просмотр содержимого

архива. Сейчас мы будем улучшать наш архиватор. А для этого придется написать несколько новых

классов. Сначала давай создадим enum Operation, который будет содержать все команды, которые

поддерживает наш архиватор.

Так же было бы удобно использовать ConsoleHelper для работы с консолью, чтобы все что касается

консоли было собрано в одном классе. В дальнейшем, если не указано обратного, то весь ввод и вывод должен происходить через ConsoleHelper.



1. Объяви enum Operation, в него добавить команды:

1.1. Создать архив CREATE

1.2. Добавить файл в архив ADD

1.3. Удалить файл из архива REMOVE

1.4. Извлечь содержимое архива EXTRACT

1.5. Просмотреть содержимое архива CONTENT

1.6. Выйти из программы EXIT

2. Создай класс ConsoleHelper и реализуй в нем статические публичные методы:

2.1. Вывести сообщение в консоль void writeMessage(String message)

2.2. Прочитать строку с консоли String readString()

2.3. Прочитать число с консоли int readInt()

Методы чтения с консоли могут бросать исключение IOException в случае ошибки ввода, учти

это при их объявлении.



Archiver (2)

Сейчас мы напишем реализацию метода createZip(Path source), в котором мы будем архивировать файл, заданный переменной source.

В Java есть специальный класс ZipOutputStream из пакета java.util.zip, который сжимает (архивирует)

переданные в него данные. Чтобы несколько файлов, сжимаемые в один архив, не слиплись вместе, для каждого из них создается специальная сущность - элемент архива ZipEntry. Т.е. в ZipOutputStream мы сначала кладем ZipEntry, а затем уже записываем содержимое файла. При записи файл автоматически сжимается, а при чтении - автоматически восстанавливается. ZipEntry может быть не только файлом, но и папкой.



Чтобы заархивировать файл (создать новый архив и добавить в него файл):

1. Создай новый поток архива ZipOutputStream используя переменную класса zipFile, с помощью метода newOutputStream класса Files.

2. Создай новый элемент архива ZipEntry. В конструктор ZipEntry передай строку, содержащую имя новой записи. Имя нужно получить из полного пути source, взять только имя файла и сконвертировать его в String.

3. Добавь в поток архива созданный элемент архива.

4. Перепиши данные из файла, который архивируем в поток архива. Для этого:

4.1. Создай поток InputStream для добавляемого файла source, используя метод newInputStream класса Files

4.2. Сделай цикл, который будет читать данные из InputStream (созданного в п.4.1), пока они там есть и записывать их в ZipOutputStream (созданный в п.1)

4.3. Закрой InputStream, сделай это с помощью try-with-resources

5. Закрой элемент архива у потока архива

6. Закрой поток архива, сделай это также с помощью try-with-resources

7. Запусти программу и проверь, что файл архивируется



Archiver (1)

Давай напишем архиватор. Архиватор, как минимум, должен уметь архивировать и разархивировать

файлы.



Начнем с первого.

Нам потребуется менеджер архива. Он будет совершать операции над файлом архива (файлом, который будет храниться на диске и иметь расширение zip). Класс, который будет этим заниматься, назовем ZipFileManager. А главный класс приложения "Архиватор" будет называться Archiver.

В программировании и не только, есть понятие полного (абсолютного) и относительного пути. Для начала, разберемся что-же такое путь вообще. Путь (англ. Path) - это набор символов, который показывает, где в операционной системе находится какой-то файл или папка.

Полный или абсолютный путь - это путь, начинающийся с корневой директории. В операционной системе Windows, корневой директорией принято считать диск.

Пример полного пути в Windows: C:userzipsTest1.zip.

Относительный путь - это путь относительно какой-то директории. zipsTest1.zip - это пример

относительного пути файла Test1.zip относительно директории (папки) C:user. Относительный путь,

относительно директории C:userzips будет просто Test1.zip и совпадать с именем файла.

Обрати внимание, что по умолчанию, и полный, и относительный путь к файлу, включают в себя имя

файла.

1. Создай класс менеджер ZipFileManager

2. Добавь в класс приватную переменную Path zipFile. В ней мы будем хранить полный путь к архиву, с которым будем работать.

3. Добавь конструктор ZipFileManager(Path zipFile). Проинициализируй поле класса zipFile.

4. Объяви публичный метод createZip(Path source) throws Exception, пока с пустой реализацией.

Path source - это путь к чему-то, что мы будем архивировать.

5. Создай класс Archiver и добавь в него метод main.

6. В методе main:

6.1 Запроси пользователя ввести полный путь архива с клавиатуры. Не забудь, что имя тоже входит в состав полного пути.

6.2 Создай объект класса ZipFileManager, передав в него имя файла архива. Разберись, как из String получить Path.



Подсказка: изучи метод get() класса Paths.



6.3 Запроси пользователя ввести путь к файлу, который будем архивировать. Не путай это с файлом архива, который мы уже ввели. На этот раз нам нужен файл, который мы будем сжимать, а не в котором хранить сжатые данные.

6.4 Вызови метод createZip у объекта ZipFileManager, передав в него путь для архивации.
*/
