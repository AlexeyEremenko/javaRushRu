
//Nevertheless I tell you the truth; It is expedient for you that I go away: for if I go not away, the Comforter will not come unto you; but if I depart, I will send him unto you. (John 16:7)

package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    private static long directoriesCounter;
    private static long filesCounter;
    private static long sizeCounter;


    public static void main(String[] args) throws IOException {
        //System.setOut(new PrintStream(new FileOutputStream("check1.txt")));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathString = reader.readLine();
        Path path = Paths.get(pathString);
        if(Files.isDirectory(path)){
            Files.walkFileTree(path, new GetTreeStatistics());
            System.out.printf("Всего папок - %s%n", directoriesCounter -1);
            System.out.printf("Всего файлов - %s%n", filesCounter);
            System.out.printf("Общий размер - %s%n", sizeCounter);
        }
        else{
            System.out.printf("%s - не папка%n", path);
        }
    }

    public static class GetTreeStatistics extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            directoriesCounter++;
            sizeCounter +=Files.size(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            filesCounter++;
            sizeCounter +=Files.size(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            if(Files.isDirectory(file)){
                directoriesCounter++;}
            else{filesCounter++;}
            sizeCounter +=Files.size(file);
            return FileVisitResult.SKIP_SUBTREE;
        }
    }
}

/*
Что внутри папки?

Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.



Первым делом считай путь к папке с консоли.

Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.

Затем посчитай и выведи следующую информацию:



Всего папок - [количество папок в директории]

Всего файлов - [количество файлов в директории и поддиректориях]

Общий размер - [общее количество байт, которое хранится в директории]



Используй только классы и методы из пакета java.nio.



Квадратные скобки [ ] выводить на экран не нужно.





Требования:

1. Метод main должен считывать путь к папке с консоли.

2. Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.

3. На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории]".

4. На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".

5. На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]".
*/
