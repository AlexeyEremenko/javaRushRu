
//When therefore it was evening, on that day, the first day of the week, and when the doors were locked where the disciples were assembled, for fear of the Jews, Jesus came and stood in the midst, and said to them, "Peace be to you." (John 20:19)

---------------------------------------------------Solution.java---------------------------------------------------------------------
package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
    
    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        }.execute();
    }

    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        }.execute();
    }

    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        }.execute();
    }

    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        }.execute();
    }
}
-------------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------AbstractDbSelectExecutor.java----------------------------------------------------
package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDbSelectExecutor<T extends NamedItem> {

    public abstract String getQuery();

    /**
     * It's fake method
     *
     * @return a list of 5 fake items
     */
    public List<T> execute() {
        List<T> result = new ArrayList<>();
        //assert the query is not null
        String query = getQuery();
        if (query == null) return result;

        try {
            //generate 5 fake items
            for (int i = 1; i <= 5; i++) {
                T newItem = getNewInstanceOfGenericType();
                newItem.setId(i);
                newItem.setName(newItem.getClass().getSimpleName() + "-" + i);
                newItem.setDescription("Got by executing '" + query + "'");
                result.add(newItem);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    //reflection
    //you have to know that it is possible to create new instance of T (generic type) class by using its default constructor
    private T getNewInstanceOfGenericType() throws InstantiationException, IllegalAccessException {
        return (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
    }
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\NamedItem.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;

public class NamedItem {
    private int id;
    private String name;
    private String description;

    public NamedItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\User.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;


public class User extends NamedItem {
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\Location.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;


public class Location extends NamedItem {
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\Server.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;


public class Server extends NamedItem {
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\Subject.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;

public class Subject extends NamedItem {
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\Subscription.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;


public class Subscription extends NamedItem {
}
-------------------------------------------------------------------------------------------------------------------------------------



/*
Анонимность иногда так приятна!
1. В пакете vo создайте public классы User, Location, Server, Subject, Subscription, которые наследуются от NamedItem
2. В классе Solution для каждого класса создайте свой метод, который возвращает список экземпляров класса.

Например, для класса User это будет — public List<User> getUsers()
Для класса Location это будет — public List<Location> getLocations()

3. Внутри каждого такого метода создайте анонимный класс от AbstractDbSelectExecutor и вызовите его нужный метод.
Подсказка:
тело метода должно начинаться так: return new AbstractDbSelectExecutor

4. Пример вывода для User и Location:
Id=5, name='User-5', description=Got by executing 'SELECT * FROM USER'
Id=1, name='Location-1', description=Got by executing 'SELECT * FROM LOCATION'

5. Проанализируйте пример вывода и сформируйте правильный query для всех классов.


Требования:
1. В пакете vo должен быть создан public класс User, унаследованный от класса NamedItem.
2. В пакете vo должен быть создан public класс Location, унаследованный от класса NamedItem.
3. В пакете vo должен быть создан public класс Server, унаследованный от класса NamedItem.
4. В пакете vo должен быть создан public класс Subject, унаследованный от класса NamedItem.
5. В пакете vo должен быть создан public класс Subscription, унаследованный от класса NamedItem.
6. В методе getUsers должен быть создан объект класса AbstractDbSelectExecutor с параметром типа User.
7. В методе getUsers должен быть создан объект класса AbstractDbSelectExecutor с параметром типа Location.
8. В методе getUsers должен быть создан объект класса AbstractDbSelectExecutor с параметром типа Server.
9. В методе getUsers должен быть создан объект класса AbstractDbSelectExecutor с параметром типа Subject.
10. В методе getUsers должен быть создан объект класса AbstractDbSelectExecutor с параметром типа Subscription.
11. Метод getUsers должен возвращать корректный список(в соответствии с условием задачи).
12. Метод getLocations должен возвращать корректный список(в соответствии с условием задачи).
13. Метод getServers должен возвращать корректный список(в соответствии с условием задачи).
14. Метод getSubjects должен возвращать корректный список(в соответствии с условием задачи).
15. Метод getSubscriptions должен возвращать корректный список(в соответствии с условием задачи).

---------------------------------------------------Solution.java---------------------------------------------------------------------
package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

* 
Анонимность иногда так приятна!
*
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
-------------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------AbstractDbSelectExecutor.java----------------------------------------------------
package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDbSelectExecutor<T extends NamedItem> {

    public abstract String getQuery();

    /**
     * It's fake method
     *
     * @return a list of 5 fake items
     */
    public List<T> execute() {
        List<T> result = new ArrayList<>();
        //assert the query is not null
        String query = getQuery();
        if (query == null) return result;

        try {
            //generate 5 fake items
            for (int i = 1; i <= 5; i++) {
                T newItem = getNewInstanceOfGenericType();
                newItem.setId(i);
                newItem.setName(newItem.getClass().getSimpleName() + "-" + i);
                newItem.setDescription("Got by executing '" + query + "'");
                result.add(newItem);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    //reflection
    //you have to know that it is possible to create new instance of T (generic type) class by using its default constructor
    private T getNewInstanceOfGenericType() throws InstantiationException, IllegalAccessException {
        return (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
    }
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\NamedItem.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;

public class NamedItem {
    private int id;
    private String name;
    private String description;

    public NamedItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\User.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;


public class User {
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\Location.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;


public class Location {
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\Server.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;


public class Server {
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\Subject.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;


public class Subject {
}
-------------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------\vo\Subscription.java-------------------------------------------------------------
package com.javarush.task.task23.task2309.vo;

public class Subscription {
}
-------------------------------------------------------------------------------------------------------------------------------------



*/
