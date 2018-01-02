
// And from Jesus Christ, [who is] the faithful witness, [and] the first begotten of the dead, and the prince of the kings of the earth. Unto him that loved us, and washed us from our sins in his own blood (Revelation 1:5)

package com.javarush.task.task25.task2515;

public class Rocket extends BaseObject {
    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    public void move() {y--;}

    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'R');
    }
}

/*
Space (11)

Теперь напишем класс Rocket.

Практически совпадает с классом Bomb.

Только:

а) Ракета летит вверх (т.е. y уменьшается на 1);

б) Рисуем не букву "B", а букву "R".





Требования:

1. В классе Rocket конструктор должен принимать координаты, а радиус выставлять всегда равным 1.

2. В классе Rocket напиши метод move(), который уменьшает координату y на единицу.

3. В классе Rocket напиши метод draw(Canvas canvas), который для canvas будет ставить символ 'R' в координатах x, y.
*/
