
//For I will not dare to speak of any things except those which Christ worked through me, for the obedience of the Gentiles, by word and deed (Romans 15:18)


-----------------------------------------------------Solution.java------------------------------------------------
package com.javarush.task.task17.task1710;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        String command = args[0];
        String inputString = "";
        for (int i = 1; i < args.length; i++) {
            inputString += args[i] + " ";
        }
        String[] inputParam = inputString.split(" ");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (command) {
            case "-c": {
                String name = "";
                int count = 0;
                for (int i = 0; i < inputParam.length; i++) {
                    if (!inputParam[i].equals("м") && !inputParam[i].equals("ж")) {
                        name += inputParam[i] + " ";
                        count++;
                    } else break;
                }
                name = name.substring(0, name.length() - 1);

                String sex = inputParam[count];
                Date birthdate = simpleDateFormat.parse(inputParam[count + 1]);
                if (sex.equals("м")) {
                    allPeople.add(Person.createMale(name, birthdate));
                } else if (sex.equals("ж")) {
                    allPeople.add(Person.createFemale(name, birthdate));
                }
            }
            System.out.println(allPeople.size() - 1);
            break;

            case "-u": { //-u id name sex bd
                int id = Integer.parseInt(inputParam[0]);
                String name = "";
                int count = 1;
                for (int i = 1; i < inputParam.length; i++) {
                    if (!inputParam[i].equals("м") && !inputParam[i].equals("ж")) {
                        name += inputParam[i] + " ";
                        count++;
                    } else break;
                }
                name = name.substring(0, name.length() - 1);

                String sex = inputParam[count];
                Date birthdate = simpleDateFormat.parse(inputParam[count + 1]);

                if (sex.equals("м")) {
                    Person p = allPeople.get(id);
                    p.setName(name);
                    p.setSex(Sex.MALE);
                    p.setBirthDay(birthdate);
                } else if (sex.equals("ж")) {
                    Person p = allPeople.get(id);
                    p.setName(name);
                    p.setSex(Sex.FEMALE);
                    p.setBirthDay(birthdate);
                }
            }
            break;
            case "-d": {
                Person p = allPeople.get(Integer.parseInt(inputParam[0]));
                p.setBirthDay(null);
                p.setName(null);
                p.setSex(null);
            }
            break;
            case "-i": { //id: name sex (м/ж) bd (формат 15-Apr-1990)
                int id = Integer.parseInt(inputParam[0]);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                Person p = allPeople.get(id);
                String sex;
                if (p.getSex() == Sex.MALE) {
                    sex = "м";
                } else sex = "ж";
                System.out.println(p.getName() + " " + sex + " " + sdf.format(p.getBirthDay()));

            }
            break;
        }
    }
}
------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Person.java-------------------------------------------------
package com.javarush.task.task17.task1710;

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
------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------Sex.java---------------------------------------------------
package com.javarush.task.task17.task1710;

public enum Sex {
    MALE,
    FEMALE
}
------------------------------------------------------------------------------------------------------------------



/*
CRUD
CrUD — Create, Update, Delete

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u — обновляет данные человека с данным id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.

-----------------------------------------------------Solution.java------------------------------------------------
package com.javarush.task.task17.task1710;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
    }
}
------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Person.java-------------------------------------------------
package com.javarush.task.task17.task1710;

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
------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------Sex.java---------------------------------------------------
package com.javarush.task.task17.task1710;

public enum Sex {
    MALE,
    FEMALE
}
------------------------------------------------------------------------------------------------------------------

*/
