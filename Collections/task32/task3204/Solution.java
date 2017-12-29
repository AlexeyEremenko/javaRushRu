
//I have spoken these things to you in figures of speech. But the time is coming when 
//I will no more speak to you in figures of speech, but will tell you plainly about the Father. (John 16:25)

package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        String letters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        StringBuffer pwd = new StringBuffer();

        for (int i=0; i<4; i++) {
            pwd.append(letters.charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<2; i++) {
            pwd.append(digits.charAt((int)(Math.random()*10)));
        }
        for (int i=0; i<2; i++) {
            pwd.append(letters.toUpperCase().charAt((int)(Math.random()*26)));
        }

        try {
            output.write(pwd.toString().getBytes());
        } catch (Exception e)
        {

        }

        return output;
    }
}

/*
Генератор паролей

Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.

Требования к паролю:

1) 8 символов.

2) только цифры и латинские буквы разного регистра.

3) обязательно должны присутствовать цифры, и буквы разного регистра.

Все сгенерированные пароли должны быть уникальные.



Пример правильного пароля:

wMh7smNu





Требования:

1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.

2. Длина пароля должна составлять 8 символов.

3. Пароль должен содержать хотя бы одну цифру.

4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.

5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.

6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.

7. Сгенерированные пароли должны быть уникальными.
*/
