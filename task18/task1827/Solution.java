
//But now, I say, I am going to Jerusalem, serving the saints. (Romans 15:25)

package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int maxId = 0;
                List<String> list = new LinkedList<>();
                while ((line = fileReader.readLine()) != null) {
                    list.add(line);

                    if (maxId < Integer.parseInt(line.substring(0, 8).trim())) {
                        maxId = Integer.parseInt(line.substring(0, 8).trim());
                    }
                }
                try (FileOutputStream fos = new FileOutputStream(fileName)) {
                    for (String s : list) {
                        fos.write((String.format("%s%n", s)).getBytes());
                    }

                    fos.write(String.format("%-8s%-30s%-8s%-4s%n", ++maxId, args[1], args[2], args[3]).getBytes());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00 12
198478  Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
4. Товар должен иметь следующий id, после максимального, найденного в файле.
5. Форматирование новой строки товара должно четко совпадать с указанным в задании.
6. Созданные для файлов потоки должны быть закрыты.

package com.javarush.task.task18.task1827;

* 
Прайсы
*

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}

*/
