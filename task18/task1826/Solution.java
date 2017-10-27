
//Simon Peter followed Jesus, as did another disciple. Now that disciple was known to the high priest,
//and entered in with Jesus into the court of the high priest (John 18:15)

package com.javarush.task.task18.task1826;

/* 
Шифровка
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

     encryptDecryptFile(args[1], args[2]);
    }

    public static void encryptDecryptFile(String sourceFileName, String destinationFileName) {
        try (FileInputStream fis = new FileInputStream(sourceFileName);
             FileOutputStream fos = new FileOutputStream(destinationFileName)) {
            while (fis.available() > 0) {
                fos.write(fis.read() ^ 0b11111111);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.


*/
