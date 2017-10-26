
//and led him to Annas first, for he was father-in-law to Caiaphas, who was high priest that year. (John 18:13)


package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;

        while (true) {
            String fileName = br.readLine();
            try {
                fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                br.close();
                return;
            }
        }
    }
}




/*
Файлы и исключения
Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();


Требования:
1. Программа должна считывать имена файлов с консоли.
2. Для каждого файла нужно создавать поток для чтения.
3. Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
4. После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
5. Потоки для чтения из файла должны быть закрыты.
6. Команду "System.exit();" использовать нельзя.


package com.javarush.task.task18.task1824;

* 
Файлы и исключения
*

public class Solution {
    public static void main(String[] args) {
    }
}

*/
