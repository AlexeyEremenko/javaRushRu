
//And I baptized also the household of Stephanas: besides, I know not whether I baptized any other (1Cor 1:16)

package com.javarush.task.task24.task2406;

import java.math.BigDecimal;

/* 
Наследование от внутреннего класса
*/
public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public static void main(String[] args) {

    }
    
    public class Apt3Bedroom extends Building.Apartments {
        public Apt3Bedroom(Building building) {building.super();}
    }
    public class BigHall extends Building.Hall {
        public BigHall(Building building) {building.super(BigDecimal.ONE);}
    }
}

/*
Наследование от внутреннего класса
Внутри класса Solution создай 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуй их от Apartments и Hall.


Требования:
1. Класс Apt3Bedroom должен быть создан внутри класса Solution.
2. Класс BigHall должен быть создан внутри класса Solution.
3. Класс Apt3Bedroom должен быть публичным.
4. Класс BigHall должен быть публичным.
5. Класс Apt3Bedroom должен быть потомком класса Building.Apartments.
6. Класс BigHall должен быть потомком класса Building.Hall.

package com.javarush.task.task24.task2406;

import java.math.BigDecimal;

/* 
Наследование от внутреннего класса
*/
public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public static void main(String[] args) {

    }
}
*/
