
//Then answered the Jews and said unto him, What sign shewest thou unto us, seeing that thou doest these things? (John 2:18)

package com.javarush.task.task39.task3913.query;

import com.javarush.task.task39.task3913.Event;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface EventQuery {
    int getNumberOfAllEvents(Date after, Date before);

    Set<Event> getAllEvents(Date after, Date before);

    Set<Event> getEventsForIP(String ip, Date after, Date before);

    Set<Event> getEventsForUser(String user, Date after, Date before);

    Set<Event> getFailedEvents(Date after, Date before);

    Set<Event> getErrorEvents(Date after, Date before);

    int getNumberOfAttemptToSolveTask(int task, Date after, Date before);

    int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before);

    Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before);

    Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before);
}

/*
Парсер логов (4)

Реализуй интерфейс EventQuery у класса LogParser:

4.1. Метод getNumberOfAllEvents() должен возвращать количество событий за указанный период.

4.2. Метод getAllEvents() должен возвращать все события за указанный период.

4.3. Метод getEventsForIP() должен возвращать события, которые происходили с указанного IP.

4.4. Метод getEventsForUser() должен возвращать события, которые инициировал

определенный пользователь.

4.5. Метод getFailedEvents() должен возвращать события, которые не выполнились.

4.6. Метод getErrorEvents() должен возвращать события, которые завершились ошибкой.

4.7. Метод getNumberOfAttemptToSolveTask() должен возвращать количество попыток

решить определенную задачу.

4.8. Метод getNumberOfSuccessfulAttemptToSolveTask() должен возвращать количество

успешных решений определенной задачи.

4.9. Метод getAllSolvedTasksAndTheirNumber() должен возвращать мапу (номер_задачи :

количество_попыток_решить_ее).

4.10. Метод getAllDoneTasksAndTheirNumber() должен возвращать мапу (номер_задачи :

сколько_раз_ее_решили).





Требования:

1. Класс LogParser должен поддерживать интерфейс EventQuery.

2. Метод getNumberOfAllEvents(Date, Date) должен возвращать количество уникальных событий за выбранный период.

3. Метод getAllEvents(Date, Date) должен возвращать множество уникальных событий за выбранный период.

4. Метод getEventsForIP(String, Date, Date) должен возвращать множество уникальных событий, которые происходили с переданного IP адреса за выбранный период.

5. Метод getEventsForUser(String, Date, Date) должен возвращать множество уникальных событий, которые произвел переданный пользователь за выбранный период.

6. Метод getFailedEvents(Date, Date) должен возвращать множество уникальных событий, у которых статус выполнения FAILED за выбранный период.

7. Метод getErrorEvents(Date, Date) должен возвращать множество уникальных событий, у которых статус выполнения ERROR за выбранный период.

8. Метод getNumberOfAttemptToSolveTask(int, Date, Date) должен возвращать количество попыток решить задачу с номером task за выбранный период.

9. Метод getNumberOfSuccessfulAttemptToSolveTask(int, Date, Date) должен возвращать количество успешных решений задачи с номером task за выбранный период.

10. Метод getAllSolvedTasksAndTheirNumber(Date, Date) должен возвращать мапу (номер_задачи : количество_попыток_решить_ее) за выбранный период.

11. Метод getAllDoneTasksAndTheirNumber(Date, Date) должен возвращать мапу (номер_задачи : сколько_раз_ее_решили) за выбранный период.
*/
