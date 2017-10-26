
//So the detachment, the commanding officer, and the officers of the Jews, seized Jesus and bound him (John 18:12)

package com.javarush.task.task18.task1823;

import java.util.Map;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = null;
        while (true) {
            string = br.readLine();
            if (string.equals("exit"))
                break;

            ReadThread thread = new ReadThread(string);
            thread.start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private byte thatByte;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();

            try {
                FileInputStream fileInputStream = new FileInputStream(this.fileName);
                while (fileInputStream.available() > 0) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);

                    for (byte b : buffer) {
                        if (map.containsKey(b))
                            map.put(b, map.get(b) + 1);
                        else
                            map.put(b, 1);
                    }
                }
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.getMessage();
            } catch (IOException e) {
                e.getMessage();
            }

            //find byte
            int max = 0;
            for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
                if (max < pair.getValue()) {
                    this.thatByte = pair.getKey();
                    max = pair.getValue();
                }
            }

            synchronized (resultMap) {
                resultMap.put(this.fileName, new Integer(this.thatByte));
            }
        }
    }
}





/*
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.


package com.javarush.task.task18.task1823;

import java.util.HashMap;
import java.util.Map;

* 
Нити и байты
*

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}



*/
