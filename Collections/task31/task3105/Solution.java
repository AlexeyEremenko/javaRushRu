
//When he has come, he will convict the world about sin, about righteousness, and about judgment; (John 16:8)

package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zip = args[1];
        String newFileName = "new" + File.separator + Paths.get(fileName).getFileName().toString();

        Map<ZipEntry, ByteArrayOutputStream> map = new HashMap<>();
        try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(zip))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipReader.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipReader.read(buffer)) != -1)
                    byteArrayOutputStream.write(buffer, 0, count);
                map.put(zipEntry, byteArrayOutputStream);
            }
        }

        FileOutputStream fos = new FileOutputStream(zip);
        ZipOutputStream zos = new ZipOutputStream(fos);

        for(Map.Entry<ZipEntry, ByteArrayOutputStream> entry: map.entrySet()){
            if(!Paths.get(entry.getKey().getName()).equals(Paths.get(newFileName))){
                zos.putNextEntry(new ZipEntry(entry.getKey().getName()));
                zos.write(entry.getValue().toByteArray());
            }
        }

        zos.putNextEntry(new ZipEntry(newFileName));
        File file = new File(fileName);
        Files.copy(file.toPath(), zos);

        zos.close();
        fos.close();
    }
}

/*
Добавление файла в архив

В метод main приходит список аргументов.

Первый аргумент - полный путь к файлу fileName.

Второй аргумент - путь к zip-архиву.

Добавить файл (fileName) внутрь архива в директорию 'new'.

Если в архиве есть файл с таким именем, то заменить его.



Пример входных данных:

C:/result.mp3

C:/pathToTest/test.zip



Файлы внутри test.zip:

a.txt

b.txt



После запуска Solution.main архив test.zip должен иметь такое содержимое:

new/result.mp3

a.txt

b.txt



Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.

Пользоваться файловой системой нельзя.





Требования:

1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.

2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).

3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.

4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.

5. Потоки для работы с архивом должны быть закрыты.
*/
