
//And the twelve gates were twelve pearls; every several gate was of one pearl: and the street of the city was pure gold, as it were transparent glass. (Revelation 21:21)

package com.javarush.task.task22.task2213;

public class FigureFactory {
    public static Figure createRandomFigure(int x,int y) {
        return new Figure(x, y, new int[x][y]);
    }
}

/*
Тетрис(11)

Теперь создай класс FigureFactory.

С его помощью мы будем создавать фигуры различных форм.

Пока он будет содержать только один статический метод createRandomFigure:

static Figure createRandomFigure(int x,int y)





Требования:

1. Класс FigureFactory должен быть создан в отдельном файле.

2. В классе FigureFactory должен быть создан метод createRandomFigure с двумя параметрами типа int.

3. Метод createRandomFigure должен быть статическим.

4. Должна существовать возможность получить доступ к методу createRandomFigure извне класса FigureFactory.

5. Метод createRandomFigure должен иметь тип возвращаемого значения Figure.
*/
