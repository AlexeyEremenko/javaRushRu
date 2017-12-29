
//At that day ye shall ask in my name: and I say not unto you, that I will pray the Father for you (John 16:26)

package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(new String("test string"));
        objectOutputStream.flush();
        System.out.println(compareMD5(byteArrayOutputStream, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(byteArrayOutputStream.toByteArray());

        byte[] diggit = messageDigest.digest();
        BigInteger bigInteger = new BigInteger(1, diggit);
        String md5HexString = bigInteger.toString(16);
        while( md5HexString.length() < 32 )
            md5HexString = "0" + md5HexString;

        return  md5HexString.equals(md5);
    }
}

/*
Целостность информации

Представь ситуацию, ты выкачал архив с интернета, и в момент скачивания у тебя на несколько секунд пропало соединение.

Нужно убедиться, валидный ли архив ты скачал. Для этого сверим его MD5 хеш.

Прочитать о MD5 на wiki.

Прочитать о MessageDigest.



Реализуй логику метода compareMD5, который должен получать MD5 хеш из переданного ByteArrayOutputStream и сравнивать с эталонным MD5 переданным вторым параметром.

Метод main не участвует в тестировании.





Требования:

1. Класс Solution должен содержать метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5).

2. Метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) должен использовать MessageDigest.

3. Метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) должен возвращать результат сравнения вычисленного MD5 хеша для byteArrayOutputStream с переданным параметром md5.

4. Класс Solution должен содержать метод main.
*/
