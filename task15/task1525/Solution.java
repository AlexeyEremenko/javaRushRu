
//Even as the Father has loved me, I also have loved you. Remain in my love. (John 15:9)

--------------------------------------------------Solution.java----------------------------------------------------------
package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
-------------------------------------------------------------------------------------------------------------------------




---------------------------------------------------Statics.java----------------------------------------------------------
package com.javarush.task.task15.task1525;

public class Statics {
    public static String FILE_NAME = "file.txt"; /* add your path to source file here*/;
}
-------------------------------------------------------------------------------------------------------------------------






/*
Файл в статическом блоке
1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.


Требования:
1. Константа FILE_NAME не должна быть пустой.
2. В статическом блоке все строки из файла с именем FILE_NAME должны быть добавлены по-отдельности в список lines.
3. Поле FILE_NAME НЕ должно быть final.
4. Класс Solution должен содержать список lines.


--------------------------------------------------Solution.java----------------------------------------------------------
package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

* 
Файл в статическом блоке
*

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
-------------------------------------------------------------------------------------------------------------------------




---------------------------------------------------Statics.java----------------------------------------------------------
package com.javarush.task.task15.task1525;

public class Statics {
    public static String FILE_NAME = /* add your path to source file here*/;
}
-------------------------------------------------------------------------------------------------------------------------


*/
