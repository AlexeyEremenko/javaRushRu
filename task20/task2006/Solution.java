
//Pilate said to him, "What is truth?" When he had said this, he went out again to the Jews, and said to them, "I find no basis for a charge against him. (John 18:38)

--------------------------------------------------Solution.java--------------------------------------------------------------
package com.javarush.task.task20.task2006;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать?
Сделай так, чтобы сериализация класса Human была возможной.
*/
public class Solution {
    public static class Human implements Serializable{
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) {

    }
}
-----------------------------------------------------------------------------------------------------------------------------



----------------------------------------------------Asset.java---------------------------------------------------------------
package com.javarush.task.task20.task2006;

public class Asset {
    public Asset(String name) {
        this.name = name;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
-----------------------------------------------------------------------------------------------------------------------------





/*
Как сериализовать?
Сделай так, чтобы сериализация класса Human была возможной.


Требования:
1. Класс Human должен существовать внутри класса Solution.
2. Класс Human должен быть статическим.
3. Класс Human должен быть публичным.
4. Класс Human должен поддерживать интерфейс Serializable.

--------------------------------------------------Solution.java--------------------------------------------------------------
package com.javarush.task.task20.task2006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

* 
Как сериализовать?
*
public class Solution {
    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) {

    }
}
-----------------------------------------------------------------------------------------------------------------------------



----------------------------------------------------Asset.java---------------------------------------------------------------
package com.javarush.task.task20.task2006;

public class Asset {
    public Asset(String name) {
        this.name = name;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
-----------------------------------------------------------------------------------------------------------------------------
*/
