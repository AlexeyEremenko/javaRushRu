
//This is he of whom I said, After me cometh a man which is preferred before me: for he was before me (John 1:30)

package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {

    int value;

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        this.value = 0;
    }

    public boolean isEmpty() {
        if (value == 0) {return true;}
     return false;
    }

    public Color getFontColor() {
        if(value < 16) {return new Color(0x776e65);}
        return new Color(0xf9f6f2);
    }

    public Color getTileColor(){
        int result = 0xff0000;
        switch (value){
            case 0 : result = 0xcdc1b4;break;
            case 2 : result = 0xeee4da;break;
            case 4 : result = 0xede0c8;break;
            case 8 : result = 0xf2b179;break;
            case 16 : result = 0xf59563;break;
            case 32 : result = 0xf67c5f;break;
            case 64 : result = 0xf65e3b;break;
            case 128 : result = 0xedcf72;break;
            case 256 : result = 0xedcc61;break;
            case 512 : result = 0xedc850;break;
            case 1024 : result = 0xedc53f;break;
            case 2048 : result = 0xedc22e;break;
        }
        return new Color(result);
    }
}

/*
2048 (2)

В игре 2048 поле состоит из 16 плиток, каждая из которых имеет определенный вес.

Кроме веса у плитки еще будет собственный цвет и цвет текста которым будет отображаться вес плитки.

Цвета плиток находятся в диапазоне от светло-серого до красного, а цвет текста будет зависеть от цвета плитки.



Создадим класс Tile описывающий одну плитку.

В нем нам понадобятся:

1. Поле value типа int, уровень доступа по умолчанию.

2. Конструктор с параметром, инициализирующий поле value.

3. Конструктор без параметров (значение поля value должно быть равно нулю).

4. Метод isEmpty, возвращающий true в случае, если значение поля value равно 0, иначе - false.

5. Метод getFontColor, возвращающий новый цвет(объект типа Color) (0x776e65) в случае, если вес плитки меньше 16, иначе - 0xf9f6f2.

6. Метод getTileColor, возвращающий цвет плитки в зависимости от ее веса в соответствии с нижеприведенными значениями:

0: (0xcdc1b4);

2: (0xeee4da);

4: (0xede0c8);

8: (0xf2b179);

16: (0xf59563);

32: (0xf67c5f);

64: (0xf65e3b);

128: (0xedcf72);

256: (0xedcc61);

512: (0xedc850);

1024: (0xedc53f);

2048: (0xedc22e);



для любых других значений: (0xff0000).



Вышеперечисленные методы не должны быть приватными.





Требования:

1. В классе Tile должно присутствовать поле value типа int с уровнем доступа по умолчанию.

2. Конструктор класса Tile с одним параметром типа int должен инициализировать поле value.

3. После создания объекта типа Tile с помощью конструктора без параметров, значение поля value должно быть равно нулю.

4. Метод isEmpty должен возвращать true в случае, если значение поля value равно 0, иначе - false.

5. Метод getFontColor должен быть реализован в соответствии с условием задачи.

6. Метод getTileColor должен возвращать цвет плитки в зависимости от ее веса.


*/
