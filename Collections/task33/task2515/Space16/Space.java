
// I was in the Spirit on the Lord's day, and heard behind me a great voice, as of a trumpet (Revelation 1:10)

 for (BaseObject object : new ArrayList<BaseObject>(bombs)) {
            if (!object.isAlive())
                bombs.remove(object);
        }

        for (BaseObject object : new ArrayList<BaseObject>(rockets)) {
            if (!object.isAlive())
                rockets.remove(object);
        }

        for (BaseObject object : new ArrayList<BaseObject>(ufos)) {
            if (!object.isAlive())
                ufos.remove(object);
        }

/*
Space (16)

И еще немного:



Напиши метод createUfo():

Если список НЛО пуст - создай один корабль в центре сверху.



Напиши метод checkBombs():

Надо проверить - не пересеклись между собой какая-нибудь бомба и корабль.

Если пересеклись - корабль и бомба умирают - die().

Если бомба упала за границу экрана y > height бомба тоже умирает.



Напиши метод checkRockets():

Надо проверить - не пересеклись между собой какая-нибудь ракета и НЛО.

Если пересеклись - ракета и нло умирают - die().

Если ракета улетела за границу экрана y < 0, ракета тоже умирает.



Напиши метод removeDead():

В этом методе удали из списков ufos, rockets, bombs все мертвые объекты (isAlive() == false).





Требования:

1. В классе Space реализуй метод createUfo() согласно описанию в задании.

2. В классе Space реализуй метод checkBombs() согласно описанию в задании.

3. В классе Space реализуй метод checkRockets() согласно описанию в задании.

4. В классе Space реализуй метод removeDead() согласно описанию в задании.
*/
