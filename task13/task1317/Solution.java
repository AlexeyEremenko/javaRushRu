package com.javarush.task.task13.task1317;

//The night is far gone, and the day is near. Let's therefore throw off the works of darkness,
//and let's put on the armor of light. (Romans 13:12)

/* 
The weather is fine
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FROZEN));
    }

    static class Today implements Weather{
        private String type;

        Today(String type) {
            this.type = type;
        }
        
        @Override
        public String getWeatherType(){return type;}

        @Override
        public String toString() {
            return String.format("%s for today", this.getWeatherType());
        }
    }
}

-------------------------------------------Weather.java-----------------------------------------------------------------

package com.javarush.task.task13.task1317;

public interface Weather extends WeatherType {
    String getWeatherType();
}
------------------------------------------------------------------------------------------------------------------------

-------------------------------------------WeatherType.java-------------------------------------------------------------

package com.javarush.task.task13.task1317;

public interface WeatherType {
    String CLOUDY = "Cloudy";
    String FOGGY = "Foggy";
    String FROZEN = "Frozen";
}

------------------------------------------------------------------------------------------------------------------------




/*
The weather is fine
1. В классе Today реализовать интерфейс Weather.
2. Подумай, как связан параметр type с методом getWeatherType().
3. Интерфейсы Weather и WeatherType уже реализованы в отдельных файлах.


Требования:
1. Интерфейс Weather должен быть реализован в классе Today.
2. В классе Today должен быть реализован метод getWeatherType объявленный в интерфейсе Weather.
3. Тип возвращаемого значения метода getWeatherType должен быть String.
4. Метод getWeatherType должен возвращать значение переменной type.

package com.javarush.task.task13.task1317;

/* 
The weather is fine
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FROZEN));
    }

    static class Today {
        private String type;

        Today(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("%s for today", this.getWeatherType());
        }
    }
}

*/
