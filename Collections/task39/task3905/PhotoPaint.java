
//And his tail drew the third part of the stars of heaven, and did cast them to the earth: and the dragon stood before the woman which was ready to be delivered, for to devour her child as soon as it was born. (Revelation 12:4)

package com.javarush.task.task39.task3905;

public class PhotoPaint {

    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {

        int x = r;
        int y = c;

        if (y < 0 || x < 0 || y >= image.length || x >= image[0].length)
            return false;

        if (image[y][x] == desiredColor)
            return false;

        Color currentColor = image[y][x];

        paintFill(image, y, x, desiredColor, currentColor);
        return true;
    }

    private void paintFill(Color[][] image, int y, int x, Color desiredColor, Color currentColor) {
        if (y < 0 || x < 0 || y >= image.length || x >= image[0].length)
            return;

        if (image[y][x] != currentColor)
            return;
        else
            image[y][x] = desiredColor;

        paintFill(image, y - 1, x, desiredColor, currentColor);
        paintFill(image, y + 1 , x, desiredColor, currentColor);
        paintFill(image, y, x - 1, desiredColor, currentColor);
        paintFill(image, y, x + 1, desiredColor, currentColor);
    }
}

/*
Залей меня полностью

В процессе разработки новой версии популярного графического редактора возникла необходимость реализовать заливку области картинки определенным цветом.



Реализуй метод paintFill в классе PhotoPaint таким образом, чтобы он возвращал:

- false, если цвет начальной точки (координаты приходят в качестве параметров) совпадает с цветом заливки или если начальные координаты выходят за рамки массива.

- модифицировал входящий массив и возвращал true, если заливка все же может быть выполнена.



Точке с координатами (x, y) соответствует элемент массив с индексом [y][x].



P.S. Если алгоритм работы заливки не очевиден, можешь попрактиковаться в графическом редакторе Paint.





Требования:

1. Метод paintFill должен возвращать false, если переданные координаты выходят за границы изображения.

2. Метод paintFill должен возвращать false, если цвет начальной точки совпадает с цветом заливки.

3. Метод paintFill должен возвращать true и корректно модифицировать изображение, если это возможно.

4. Метод paintFill должен быть публичным.
*/
