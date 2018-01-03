
//And the light shineth in darkness; and the darkness comprehended it not. (John 1:5)

package com.javarush.task.task34.task3413;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AnyObject {

    private Long id;
    private String name;
    private Calendar creationTime = new GregorianCalendar();
    private String additionalDescription;

    public AnyObject(Long id, String name, String additionalDescription) {
        this.id = id;
        if (name != null) {
            this.name = name;
        } else {
            this.name = "AnyObject#" + id;
        }
        if (additionalDescription != null) {
            this.additionalDescription = additionalDescription;
        } else {
            this.additionalDescription = "This is object #" + id;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnyObject that = (AnyObject) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return creationTime.equals(that.creationTime);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + creationTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AnyObject{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", creationTime = " + creationTime.getTime() +
                ", additionalDescription = '" + additionalDescription + '\'' +
                '}';
    }
}

/*
Кеш на основании SoftReference
Реализуй логику методов get, put, remove класса SoftCache:
Метод AnyObject get(Long key) должен возвращать объект типа AnyObject из мапы cacheMap по ключу key. Если такого ключа в cacheMap нет - верни null.
Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value. Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение value по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
Метод AnyObject remove(Long key) должен удалить из мапы cacheMap пару key : value по ключу key. Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение value по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
Не изменяй класс AnyObject.
Метод main не принимает участия в тестировании.
Требования:
1. Класс AnyObject не должен быть изменен.
2. В классе SoftCache должно существовать приватное поле Map> cacheMap.
3. Реализуй метод get согласно условию.
4. Реализуй метод put согласно условию.
5. Реализуй метод remove согласно условию.
*/
