
//But these things have I told you, that when the time shall come, ye may remember that I told you of them. And these things I said not unto you at the beginning, because I was with you. (John 16:3)

package com.javarush.task.task31.task3111;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;

    boolean minSizeCheck;
    boolean maxSizeCheck;
    boolean partOfNameCheck;
    boolean partOfContentCheck;
    private int minSize;
    private int maxSize;


    public SearchFileVisitor() {
        this.partOfName = null;
        this.partOfContent = null;
        this.minSize = 0;
        this.maxSize = 0;

        this.minSizeCheck = false;
        this.maxSizeCheck = false;
        this.partOfNameCheck = false;
        this.partOfContentCheck = false;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.minSizeCheck = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.maxSizeCheck = true;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.partOfNameCheck = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.partOfContentCheck = true;
    }

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!attrs.isRegularFile()) return CONTINUE;

        if (partOfNameCheck && file.getFileName().toString().indexOf(this.partOfName) == -1)
            return CONTINUE;

        if (minSizeCheck && attrs.size() < minSize)
            return CONTINUE;

        if (maxSizeCheck && attrs.size() > maxSize)
            return CONTINUE;

        if (partOfContentCheck && new String(Files.readAllBytes(file)).indexOf(partOfContent) == -1)
            return CONTINUE;

        foundFiles.add(file);

        return CONTINUE;
    }
}

/*
Продвинутый поиск файлов

Давай реализуем настраиваемый поиск файлов в директории.

Просмотри интерфейс java.nio.file.FileVisitor и его базовую реализацию java.nio.file.SimpleFileVisitor.

Во время поиска по дереву файлов с помощью метода Files.walkFileTree(Path start, FileVisitor<? super Path> visitor)

мы используем объект FileVisitor для выполнения необходимых операций над найденными объектами и.



Наш класс для поиска будет называться SearchFileVisitor и расширять SimpleFileVisitor.



Поиск можно будет выполнять по таким критериям:

- выражение, встречающееся в названии файла (String);

- выражение, встречающееся в содержимом файла (String);

- максимальный и минимальный размер файла (int).

Можно задавать либо один, либо сразу несколько критериев для поиска.



Я в main написал код, который использует готовый SearchFileVisitor для поиска файлов, тебе осталась совсем легкая задача - выполнить его реализацию.

Подсказка 1: методы get... , set... - это геттеры и сеттеры полей. Основная логика класса по поиску выполняется в методе visitFile(Path file, BasicFileAttributes attrs).

Подсказка 2: для работы с файлами используй только классы из пакета java.nio.





Требования:

1. В классе SearchFileVisitor нужно создать поля partOfName, partOfContent, minSize, maxSize и сеттеры для них.

2. В классе SearchFileVisitor нужно создать поле foundFiles и геттер для него. Поле должно быть сразу инициализировано.

3. Если в SearchFileVisitor задан критерий поиска partOfName, метод visitFile должен добавить файл в foundFiles, если в названии содержится строка partOfName.

4. Если в SearchFileVisitor задан критерий поиска partOfContent, метод visitFile должен добавить файл в foundFiles, если в содержимом встречается строка partOfContent.

5. Если в SearchFileVisitor задан критерий поиска maxSize, метод visitFile должен добавить файл в foundFiles, если размер файла меньше maxSize.

6. Если в SearchFileVisitor задан критерий поиска minSize, метод visitFile должен добавить файл в foundFiles, если размер файла больше minSize.

7. Метод visitFile должен быть реализован так, чтобы учитывать сразу несколько критериев поиска.
*/
