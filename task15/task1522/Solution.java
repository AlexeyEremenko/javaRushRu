
//If a man doesn't remain in me, he is thrown out as a branch, and is withered; and they gather them,
//throw them into the fire, and they are burned. (John 15:6)

/*
![Иллюстрация к проекту](https://github.com/jon/coolproject/raw/master/image/image.png)

![Image alt](https://github.com/{username}/{repository}/raw/{branch}/{path}/image.png)

{username} — ваш ник на ГитХабе;
{repository} — репозиторий где хранятся картинки;
{branch} — ветка репозитория;
{path} — путь к месту нахождения картинки.
*/
----------------------------------------------------Solution.java---------------------------------------------------------------------------
package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) throws Exception {

    }

    public static Planet thePlanet;

    static {//add static block here - добавьте статический блок тут
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try{
                String string = br.readLine();
                if (string.equals(Planet.SUN)) {thePlanet = Sun.getInstance();}
                else if (string.equals(Planet.MOON)) {thePlanet = Moon.getInstance();}
                else if (string.equals(Planet.EARTH)) {thePlanet = Earth.getInstance();}
                else thePlanet = null;
        
            }catch (Exception e) {e.printStackTrace();}
    }        
}
--------------------------------------------------------------------------------------------------------------------------------------------



-----------------------------------------------------Planet.java----------------------------------------------------------------------------
package com.javarush.task.task15.task1522;

public interface Planet {
    static String SUN = "sun";
    static String MOON = "moon";
    static String EARTH = "earth";
}
--------------------------------------------------------------------------------------------------------------------------------------------



-----------------------------------------------------Sun.java-------------------------------------------------------------------------------
package com.javarush.task.task15.task1522;


public class Sun implements Planet {
 
  private static Sun instance;
   
  private Sun(){}
   
  public static Sun getInstance(){
    if(instance == null){
      instance = new Sun();
    }
    return instance;
  }
}
--------------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------Moon.java-----------------------------------------------------------------------------
package com.javarush.task.task15.task1522;


public class Moon implements Planet {
 
  private static Moon instance;
   
  private Moon(){}
   
  public static Moon getInstance(){
    if(instance == null){
      instance = new Moon();
    }
    return instance;
  }
}
--------------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------Earth.java----------------------------------------------------------------------------
package com.javarush.task.task15.task1522;


public class Earth implements Planet {
 
  private static Earth instance;
   
  private Earth(){}
   
  public static Earth getInstance(){
    if(instance == null){
      instance = new Earth();
    }
    return instance;
  }
}
--------------------------------------------------------------------------------------------------------------------------------------------



/*
Закрепляем паттерн Singleton
1. Найти пример реализации паттерна Singleton с ленивой реализацией(lazy initialization). Используй свой любимый поисковик(например google).
2. По образу и подобию в отдельных файлах создай три класса синглтона Sun, Moon, Earth.
3. Реализуй интерфейс Planet в классах Sun, Moon, Earth.
4. В статическом блоке класса Solution вызови метод readKeyFromConsoleAndInitPlanet.
5. Реализуй функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считай один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet, создай соответствующий объект и присвой его Planet thePlanet, иначе обнулить Planet thePlanet.


Требования:
1. Класс Sun не должен позволять создавать объекты своего типа извне класса.
2. Класс Sun должен содержать приватное статическое поле instance типа Sun.
3. В классе Sun должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
4. Метод getInstance в классе Sun должен ВСЕГДА возвращать один и тот же объект.
5. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
6. Класс Moon не должен позволять создавать объекты своего типа извне класса.
7. Класс Moon должен содержать приватное статическое поле instance типа Moon.
8. В классе Moon должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
9. Метод getInstance в классе Moon должен ВСЕГДА возвращать один и тот же объект.
10. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
11. Класс Earth не должен позволять создавать объекты своего типа извне класса.
12. Класс Earth должен содержать приватное статическое поле instance типа Earth.
13. В классе Earth должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
14. Метод getInstance в классе Earth должен ВСЕГДА возвращать один и тот же объект.
15. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
16. Метод readKeyFromConsoleAndInitPlanet должен быть вызван в статическом блоке класса Solution.
17. Метод readKeyFromConsoleAndInitPlanet должен считывать одну строку с клавиатуры.
18. Метод readKeyFromConsoleAndInitPlanet должен корректно обновлять значение переменной thePlanet в соответствии с условием задачи.
19. Классы Sun, Moon и Earth должны быть созданы в отдельных файлах.

-------------------------------------------------Solution.java---------------------------------------------------------

package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
    }
}
-----------------------------------------------------------------------------------------------------------------------


---------------------------------------------------Planet.java---------------------------------------------------------
package com.javarush.task.task15.task1522;

public interface Planet {
    static String SUN = "sun";
    static String MOON = "moon";
    static String EARTH = "earth";
}
-----------------------------------------------------------------------------------------------------------------------


*/
