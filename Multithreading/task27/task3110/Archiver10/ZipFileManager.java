
//John bare witness of him, and cried, saying, This was he of whom I spake, He that cometh after me is preferred before me: for he was before me. (John 1:15)

package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory))
            Files.createDirectories(zipDirectory);

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                // Добавляем каждый файл в архив
                for (Path fileName : fileNames)
                    addNewZipEntry(zipOutputStream, source, fileName);

            } else if (Files.isRegularFile(source)) {

                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {

                // Если переданный source не директория и не файл, бросаем исключение
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }


}

/*
Archiver (10)

Пришло время отрефакторить класс ZipFileManager. В методе createZip есть код, который нам также понадобится в методах, которые будут добавлять или удалять файл в архив, распаковывать его и т.д. Эти методы мы будем реализовывать позже, но уже сейчас можем вынести общие части кода в отдельные методы.

Кроме того, метод createZip мог создавать архив только из одного файла, а хотелось бы уметь

архивировать всю папку целиком. Создавать отдельный метод для этого не будем, т.к. в createZip(Patsource) можно передавать и директорию и обычный файл.



Задания на сегодня:

1. Реализуй приватный метод void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception в классе ZipFileManager.

Он должен:

1.1. Создавать InputStream, для файла с именем fileName, расположенным в

директории filePath

1.2. Создавать новый элемент архива ZipEntry, в качестве имени используй fileName, преобразовав его в String

1.3. Копировать данные из InputStream (из п.1.1) в переданный zipOutputStream

1.4. Закрывать элемент архива

1.5. Закрывать InputStream, сделай это с помощью try-with-resources

2. Замени часть кода метода createZip вызовом нового метода addNewZipEntry. Передай значение source.getParent() в параметр filePath, а source.getFileName() в filename.

3. Реализуй приватный метод void copyData(InputStream in, OutputStream out) throws Exception. Он должен читать данные из in и записывать в out, пока не вычитает все.

4. Замени часть кода метода addNewZipEntry на вызов метода copyData

5. Вернемся к createZip:

5.1. В начале метода проверь, что существует директория (zipFile.getParent()), в которой мы

будем создавать zipFile, если ее нет, то создай ее.

5.2. Если source является обычным файлом (для проверки используй Files.isRegularFile), то оставим просто вызов addNewZipEntry

5.3. Если source является директорией (для проверки используй Files.isDirectory), то:

5.3.1. Создай объект класса файловый менеджер FileManager, в конструктор передадим source

5.3.2. Получи список файлов у файлового менеджера, сохраним его в переменную fileNames

5.3.3. Для всех элементов fileNames, вызови метод addNewZipEntry(zipOutputStream, source, fileName)

5.4. Если source не является ни папкой, ни файлом, то кинь исключение PathIsNotFoundException.





Требования:

1. В классе ZipFileManager добавь приватный метод void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception.

2. Метод addNewZipEntry должен быть реализован следуя описанию в задании.

3. Замени часть кода метода createZip вызовом нового метода addNewZipEntry.

4. В классе ZipFileManager добавь приватный метод void copyData(InputStream in, OutputStream out) throws Exception.

5. Метод copyData должен читать данные из in и записывать в out, пока не вычитает все байты.

6. Замени часть кода метода addNewZipEntry вызовом нового метода copyData.

7. Метод createZip в классе ZipFileManager должен быть доработан следуя описанию в задании.
*/
