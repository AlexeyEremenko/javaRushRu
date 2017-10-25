
//in the power of signs and wonders, in the power of God's Spirit; so that from Jerusalem, and around as far as to Illyricum, I have fully preached the Good News of Christ; (Romans 15:19)

--------------------------------------------------Solution.java---------------------------------------------------------------
package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        update(args[i], args[i + 1], args[i + 2]);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        update(getId(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(getId(args[i]));
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        print(getId(args[i]));
                    }
                }
                break;
        }


    }

    public static int getId(String idStr) {
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void print(int id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = allPeople.get(id);
        if (person.getSex() == Sex.MALE) {
            System.out.printf("%s %s %s%n", person.getName(), "м", simpleDateFormat.format(person.getBirthDay()));
        } else {
            System.out.printf("%s %s %s%n", person.getName(), "ж", simpleDateFormat.format(person.getBirthDay()));
        }
    }

    public static void delete(int id) {
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    public static void update(int id, String name, String sex, String date) throws ParseException {
        Person person = allPeople.get(id);
        person.setName(name);
        if (sex.equals("м")) {
            person.setSex(Sex.MALE);
        } else if (sex.equals("ж")) {
            person.setSex(Sex.FEMALE);
        }
        person.setBirthDay(sdf.parse(date));
    }

    public static void update(String name, String sex, String date) throws ParseException {
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, sdf.parse(date)));
        } else if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, sdf.parse(date)));
        }
        System.out.println(allPeople.size() - 1);
    }
}
------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------------Person.java----------------------------------------------------------------
package com.javarush.task.task17.task1711;

import java.util.Date;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay) {
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay) {
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------Sex.java------------------------------------------------------------------
package com.javarush.task.task17.task1711;

public enum Sex {
    MALE,
    FEMALE
}
------------------------------------------------------------------------------------------------------------------------------





/*
CRUD 2
CrUD Batch — multiple Creation, Updates, Deletion

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ... 
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-с — добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u — обновляет соответствующие данные людей с заданными id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке

Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997


Требования:
1. Класс Solution должен содержать public static volatile поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.


-----------------------------------------------Solution.java-----------------------------------------------------------
package com.javarush.task.task17.task1711;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
    }
}
-----------------------------------------------------------------------------------------------------------------------


------------------------------------------------Person.java------------------------------------------------------------
package com.javarush.task.task17.task1711;

import java.util.Date;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay) {
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay) {
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
-----------------------------------------------------------------------------------------------------------------------


------------------------------------------------Sex.java---------------------------------------------------------------
package com.javarush.task.task17.task1711;

public enum Sex {
    MALE,
    FEMALE
}
-----------------------------------------------------------------------------------------------------------------------

*/
