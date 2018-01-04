
//The Word became flesh, and lived among us. We saw his glory, such glory as of the one and only Son of the Father,
//full of grace and truth. (John 1:14)

package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path rootPath;
    private List<Path> fileList = new ArrayList<>();

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        collectFileList(rootPath);
    }

    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            Path relativePath = rootPath.relativize(path);
            fileList.add(0, relativePath);
        }

        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path file : directoryStream) {
                    collectFileList(file);
                }
            }
        }
    }

    public List<Path> getFileList() {
        return fileList;
    }

}

/*
Archiver (9)

Теперь займемся другой, не менее важной частью нашего архиватора. Очень часто пользователь хочет

создать архив не из одного файла, а из целой папки. Тогда архивация сводится к поочередному

добавлению элемента ZipEntry для каждого файла в архив.

Нам нужно написать класс FileManager для получения списка всех файлов в какой-то папке. У него должен быть конструктор, который будет принимать путь Path rootPath, указывающий на корень (папку, файлы в которой нас интересуют) и метод List<Path> getFileList(), который должен возвращать список относительных путей всех файлов, которые находятся по пути rootPath, включая файлы в подпапках.

Директория, в которой будем искать, может задаваться только один раз в конструкторе. Поэтому, прямо в конструкторе мы сразу можем сформировать список файлов (их относительных путей), сохранив его в переменную класса List<Path> fileList.

Осталось только решить, как нам собрать все файлы, даже те, которые могут быть в папке, которая в папке, которая в папке, которая в интересующей нас папке. Фух, чуть не вошел рекурсию. Хотя нам-то она и поможет! Сделаем метод collectFileList(Path path), который будет складывать в переменную класса fileList все файлы, обнаруженные внутри переданного пути path, вызывая сам себя для всех объектов, в обнаруженных директориях.



1. Создай класс FileManager с конструктором FileManager(Path rootPath) throws IOException

2. Объяви и проинициализируй приватные переменные класса:

2.1. Path rootPath - корневой путь директории, файлы которой нас интересуют

2.2. List<Path> fileList - список относительных путей файлов внутри rootPath

3. Создай геттер для fileList

4. Реализуй метод void collectFileList(Path path) throws IOException, который должен:

4.1. Проверить, если переданный путь path является обычным файлом (используй метод Files.isRegularFile), то получить его относительный путь относительно rootPath и добавить его в список fileList.

4.2. Если переданный путь path, является директорией (узнать это поможет метод Files.isDirectory), то пройтись по всему содержимому директории и вызвать collectFileList(Path path), передав в path обнаруженные элементы.

Пройтись по всему содержимому директории можно предварительно получив DirectoryStream с помощью метода newDirectoryStream класса Files. Не забудь закрыть созданный DirectoryStream.

5. Добавь вызов метода collectFileList(rootPath) в конструкторе FileManager.

6. Примени все свои знания об инкапсуляции к этому классу.

Выполняя это задание, ты написал алгоритм, который обходит дерево файлов. Но в Java есть специальный интерфейс FileVisitor для этих целей. Очень рекомендую разобраться как им пользоваться.





Требования:

1. В корне задачи должен быть создан класс FileManager c конструктором FileManager(Path rootPath) throws IOException.

2. В классе FileManager должны быть созданы приватные поля Path rootPath и List fileList, которые инициализируются в конструкторе.

3. В классе FileManager должен быть создан getter для поля fileList.

4. В классе FileManager нужно реализовать приватный метод void collectFileList(Path path) throws IOException согласно заданию.

5. Нужно добавить вызов метода collectFileList(rootPath) в конструктор FileManager.


*/
