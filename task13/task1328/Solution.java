
//He who observes the day, observes it to the Lord; and he who does not observe the day, to the Lord he does not observe it.
// who eats, eats to the Lord, for he gives God thanks. He who doesn't eat, to the Lord he doesn't eat, 
//d gives God thanks. (Romans 14:6)

------------------------------------------------Solution.java-----------------------------------------------------------------
package com.javarush.task.task13.task1328;

/* 
Битва роботов
*/

public class Solution {
    public static void main(String[] args) {
        Robot amigo = new Robot("Амиго");
        Robot enemy = new Robot("Сгибальщик-02");

        doMove(amigo, enemy);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
    }

    public static void doMove(AbstractRobot robotFirst, AbstractRobot robotSecond) {
        BodyPart attacked = robotFirst.attack();
        BodyPart defenced = robotFirst.defense();
        System.out.println(String.format("%s атаковал робота %s, атакована %s, защищена %s",
                robotFirst.getName(), robotSecond.getName(), attacked, defenced));
    }
}

------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------AbstractRobot.java------------------------------------------------------------
package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable{
    
    private static int hitCount;
    public abstract String getName();
    
    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount > 3) {
            hitCount = 0;
            attackedBodyPart = BodyPart.CHEST;
        }
        
        return attackedBodyPart;
    }
    
    public BodyPart defense() {
        BodyPart defencedBodyPart = null;
        hitCount = hitCount + 2;

        if (hitCount == 1) {
            defencedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defencedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defencedBodyPart = BodyPart.ARM;
        } else if (hitCount > 3) {
            hitCount = 0;
            defencedBodyPart = BodyPart.CHEST;
        }
        return defencedBodyPart;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------BodyPart.java----------------------------------------------------------------
package com.javarush.task.task13.task1328;

public final class BodyPart {
    final static BodyPart LEG = new BodyPart("нога");
    final static BodyPart HEAD = new BodyPart("голова");
    final static BodyPart ARM = new BodyPart("рука");
    final static BodyPart CHEST = new BodyPart("грудь");

    private String bodyPart;

    private BodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return this.bodyPart;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------Defensable.java--------------------------------------------------------------
package com.javarush.task.task13.task1328;

public interface Defensable {
    BodyPart defense();
}
------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------Attackable.java--------------------------------------------------------------
package com.javarush.task.task13.task1328;

public interface Attackable {
    BodyPart attack();
}

------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------Robot.java-------------------------------------------------------------------
package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot {
    private String name;

    public Robot(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
}

------------------------------------------------------------------------------------------------------------------------------



/*
Битва роботов
1. Разобраться в том, что тут написано.
2. http://info.javarush.ru/uploads/images/00/00/07/2014/08/12/50f3e37f94.png
3. Смириться со своей участью и продолжить разбираться в коде.
4. …
5. Порадоваться, что мы все поняли.
6. Изменить код согласно новой архитектуре и добавить новую логику:
6.1. Сделать класс AbstractRobot абстрактным, вынести логику атаки и защиты из Robot в AbstractRobot.
6.2. Отредактировать класс Robot учитывая AbstractRobot.
6.3. Расширить класс BodyPart новой частью тела BodyPart.CHEST(«грудь«).
6.4. Добавить новую часть тела в реализацию интерфейсов Attackable и Defensable (в классе AbstractRobot).
7. http://info.javarush.ru/uploads/images/00/00/07/2014/08/12/3b9c65580b.png


Требования:
1. Класс AbstractRobot должен быть абстрактным.
2. Класс AbstractRobot должен реализовывать интерфейсы Attackable и Defensable.
3. Класс Robot должен наследоваться от класса AbstractRobot.
4. Логика поведения роботов должна быть вынесена в класс AbstractRobot.
5. В классе BodyPart должна содержаться и быть инициализирована final static переменная CHEST типа BodyPart.
6. Новая часть тела(BodyPart) должна быть добавлена в логику методов attack и defense в классе AbstractRobot.

------------------------------------------------Solution.java-----------------------------------------------------------------
package com.javarush.task.task13.task1328;

/* 
Битва роботов
*/

public class Solution {
    public static void main(String[] args) {
        Robot amigo = new Robot("Амиго");
        Robot enemy = new Robot("Сгибальщик-02");

        doMove(amigo, enemy);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
    }

    public static void doMove(AbstractRobot robotFirst, AbstractRobot robotSecond) {
        BodyPart attacked = robotFirst.attack();
        BodyPart defenced = robotFirst.defense();
        System.out.println(String.format("%s атаковал робота %s, атакована %s, защищена %s",
                robotFirst.getName(), robotSecond.getName(), attacked, defenced));
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------AbstractRobot.java------------------------------------------------------------
package com.javarush.task.task13.task1328;

public class AbstractRobot {
}

------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------BodyPart.java----------------------------------------------------------------
package com.javarush.task.task13.task1328;

public final class BodyPart {
    final static BodyPart LEG = new BodyPart("нога");
    final static BodyPart HEAD = new BodyPart("голова");
    final static BodyPart ARM = new BodyPart("рука");

    private String bodyPart;

    private BodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return this.bodyPart;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------Defensable.java--------------------------------------------------------------
package com.javarush.task.task13.task1328;

public interface Defensable {
    BodyPart defense();
}

------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------Attackable.java--------------------------------------------------------------
package com.javarush.task.task13.task1328;

public interface Attackable {
    BodyPart attack();
}

------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------Robot.java-------------------------------------------------------------------
package com.javarush.task.task13.task1328;

public class Robot implements Attackable, Defensable {
    private static int hitCount;
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            hitCount = 0;
            attackedBodyPart = BodyPart.LEG;
        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defencedBodyPart = null;
        hitCount = hitCount + 2;

        if (hitCount == 1) {
            defencedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defencedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            hitCount = 0;
            defencedBodyPart = BodyPart.ARM;
        }
        return defencedBodyPart;
    }
}
------------------------------------------------------------------------------------------------------------------------------
*/
