
//Jesus answered him, "If I have spoken evil, testify of the evil; but if well, why do you beat me?" (John 18:23)

package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        double max = Double.MIN_VALUE;
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] strs = s.split("[\\s\\t\\n\\x0B\\f\\r]");
            String key = strs[0];
            double value = Double.parseDouble(strs[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(strs[0]) + value);
            } else
                map.put(key, value);
        }
        fileReader.close();

        for (Double a : map.values())
            if (max < a)
                max = a;

        for (Map.Entry<String, Double> pair : map.entrySet())
            if (pair.getValue().equals(max))
                System.out.println(pair.getKey());
    }
}
/*
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.

package com.javarush.task.task19.task1920;

* 
Самый богатый
*

public class Solution {
    public static void main(String[] args) {
    }
}
*/
