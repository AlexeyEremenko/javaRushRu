
//And I heard a loud voice saying in heaven, Now is come salvation, and strength, and the kingdom of our God, 
//and the power of his Christ: for the accuser of our brethren is cast down, which accused them before our God day and night. (Revelation 12:10)

package com.javarush.task.task40.task4001;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* 
POST, а не GET
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.sendPost(new URL("http://requestb.in/1cse9qt1"), "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(URL url, String urlParameters) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(urlParameters.getBytes());
        outputStream.flush();
        outputStream.close();

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseLine;
        StringBuilder response = new StringBuilder();

        while ((responseLine = bufferedReader.readLine()) != null) {
            response.append(responseLine);
        }
        bufferedReader.close();

        System.out.println("Response: " + response.toString());
    }
}

/*
POST, а не GET

Исправь ошибки в методе sendPost, чтобы он отправлял POST-запрос с переданными параметрами.

Примечание: метод main в тестировании не участвует, но чтобы программа корректно работала локально, можешь зайти на сайт http://requestb.in/, создать свой RequestBin и использовать его в main.





Требования:

1. Метод sendPost должен вызвать метод setRequestMethod с параметром "POST".

2. Метод sendPost должен устанавливать флаг doOutput у соединения в true.

3. В OutputStream соединения должны быть записаны переданные в метод sendPost параметры.

4. Метод sendPost должен выводить результат своей работы на экран.
*/
