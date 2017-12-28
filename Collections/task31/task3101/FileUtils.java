
//They shall put you out of the synagogues: yea, the time cometh, that whosoever killeth you will think that he doeth God service. (John 16:2)

package com.javarush.task.task31.task3101;

import java.io.File;

public class FileUtils {

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void renameFile(File source, File destination) {
        if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
    }

    public static boolean isExist(File file) {
        return file.exists();
    }
}

/*
Проход по дереву файлов

1. На вход метода main подаются два параметра.

Первый - path - путь к директории, второй - resultFileAbsolutePath - имя существующего файла, который будет содержать результат.

2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:

2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).

2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:

2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.

2.2.2. Переименовать resultFileAbsolutePath в 'allFilesContent.txt' (используй метод FileUtils.renameFile, и, если понадобится, FileUtils.isExist).

2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. После каждого тела файла записать "\n".

Все файлы имеют расширение txt.

В качестве разделителя пути используй "/".





Требования:

1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.

2. Нужно создать поток для записи в переименованный файл.

3. Пройдись по всем файлам в директории, которая приходит первым параметром в main, и всех ее поддиректориях. Файлы с размером более 50 байт нужно удалить используя метод FileUtils.deleteFile.

4. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.

5. Поток для записи в файл нужно закрыть.
*/