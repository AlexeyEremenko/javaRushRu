
//I myself am also persuaded about you, my brothers, that you yourselves are full of goodness, filled with all knowledge, able also to admonish others. (Romans 15:14)

---------------------------------------------Solution.java----------------------------------------------------------------------
package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }
}
--------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------ImageReader.java-------------------------------------------------------------------
package com.javarush.task.task16.task1631.common;

public interface ImageReader {
}
--------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------ImageTypes.java--------------------------------------------------------------------
package com.javarush.task.task16.task1631.common;

public enum ImageTypes {
    BMP,
    JPG,
    PNG
}
--------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------ImageReaderFactory.java-----------------------------------------------------------
package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        if (type == ImageTypes.BMP) {
            return new BmpReader();
        } else if (type == ImageTypes.JPG) {
            return new JpgReader();
        } else if (type == ImageTypes.PNG) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
--------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------JpgReader.java--------------------------------------------------------------------
package com.javarush.task.task16.task1631.common;


public class JpgReader implements ImageReader {
}
--------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------PngReader.java-------------------------------------------------------------------
package com.javarush.task.task16.task1631.common;


public class PngReader implements ImageReader {
}
--------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------BmpReader.java-------------------------------------------------------------------
package com.javarush.task.task16.task1631.common;


public class BmpReader implements ImageReader {
}
--------------------------------------------------------------------------------------------------------------------------------


/*
Factory method pattern
1. Внимательно посмотри, какие классы у тебя есть.
2. В отдельных файлах в пакете common создай классы JpgReader, PngReader, BmpReader, которые реализуют интерфейс ImageReader.
3. В отдельном файле в основном пакете создай класс ImageReaderFactory с одним методом.
3.1. Подумай, как он должен называться.
3.2. Подумай, какие модификаторы должны быть у этого метода.
4. Этот метод должен:
4.1. Для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG — JpgReader;
4.2. Если передан неправильный параметр, то выбрасывать исключение IllegalArgumentException(«Неизвестный тип картинки«).


Требования:
1. Создай в пакете common класс JpgReader, реализующий интерфейс ImageReader.
2. Создай в пакете common класс PngReader, реализующий интерфейс ImageReader.
3. Создай в пакете common класс BmpReader, реализующий интерфейс ImageReader.
4. Создай публичный класс ImageReaderFactory.
5. Добавь в класс ImageReaderFactory открытый статический метод getImageReader с параметром ImageTypes.
6. Метод getImageReader должен создавать и возвращать подходящий Reader.
7. Метод getImageReader должен кидать исключение IllegalArgumentException, если передан неправильный параметр.


---------------------------------------------Solution.java----------------------------------------------------------------------
package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }
}
--------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------ImageReader.java-------------------------------------------------------------------
package com.javarush.task.task16.task1631.common;

public interface ImageReader {
}
--------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------ImageTypes.java--------------------------------------------------------------------
package com.javarush.task.task16.task1631.common;

public enum ImageTypes {
    BMP,
    JPG,
    PNG
}
--------------------------------------------------------------------------------------------------------------------------------

*/
