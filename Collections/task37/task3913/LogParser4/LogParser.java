
//Then answered the Jews and said unto him, What sign shewest thou unto us, seeing that thou doest these things? (John 2:18)

package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery {
    private Path logDir;
    public LogParser(Path logDir) {
        this.logDir = logDir;
    }
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }
    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIpSet(null, after, before);
    }
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getIpSet(user, after, before);
    }
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getIpSet(event, after, before);
    }
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getIpSet(status, after, before);
    }

    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (!users.contains(record.getUser())) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && !users.contains(record.getUser())) {
                users.add(record.getUser());
            }
        }
        return users.size();
    }

    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())) {
                if (record.getUser().equals(user)) set.add(record.getEvent());
            }
        }
        return set.size();
    }

    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getIp().equals(ip)) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.LOGIN)) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.WRITE_MESSAGE)) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.SOLVE_TASK)) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getEvent().equals(Event.SOLVE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.DONE_TASK)) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && user.equals(record.getUser()) && record.getEvent().equals(event)) {
                dates.add(record.date);
            }
        }
        return dates;
    }

    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getStatus().equals(Status.FAILED)) {
                dates.add(record.date);
            }
        }
        return dates;
    }

    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getStatus().equals(Status.ERROR)) {
                dates.add(record.date);
            }
        }
        return dates;
    }

    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getUser().equals(user) && record.getEvent().equals(Event.LOGIN)) {
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }

    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.SOLVE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }

    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }

    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.WRITE_MESSAGE)) {
                dates.add(record.date);
            }
        }
        return dates;
    }

    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                dates.add(record.date);
            }
        }
        return dates;
    }

    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())) {
                set.add(record.getEvent());
            }
        }
        return set;
    }

    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getIp().equals(ip)) {
                set.add(record.getEvent());
            }
        }
        return set;
    }

    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getUser().equals(user)) {
                set.add(record.getEvent());
            }
        }
        return set;
    }

    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getStatus().equals(Status.FAILED)) {
                set.add(record.getEvent());
            }
        }
        return set;
    }

    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getStatus().equals(Status.ERROR)) {
                set.add(record.getEvent());
            }
        }
        return set;
    }

    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int i = 0;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getEvent().equals(Event.SOLVE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                i++;
            }
        }
        return i;
    }

    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int i = 0;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                i++;
            }
        }
        return i;
    }

    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> taskSolved = new HashMap<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.SOLVE_TASK)) {
                int task = Integer.parseInt(record.getTaskNumber());
                if (taskSolved.containsKey(task)) {
                    taskSolved.put(task, taskSolved.get(task) + 1);
                } else {
                    taskSolved.put(task, 1);
                }
            }
        }
        return taskSolved;
    }

    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> taskSolved = new HashMap<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.DONE_TASK)) {
                int task = Integer.parseInt(record.getTaskNumber());
                if (taskSolved.containsKey(task)) {
                    taskSolved.put(task, taskSolved.get(task) + 1);
                } else {
                    taskSolved.put(task, 1);
                }
            }
        }
        return taskSolved;
    }

    public Set<Object> execute(String query) {
        Set<Object> res = new HashSet<>();
        if (query == null || query.isEmpty()) return res;
        Pattern p = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                + "( and date between \"(.*?)\" and \"(.*?)\")?");
        Matcher m = p.matcher(query);
        String field1 = null;
        String field2 = null;
        String value1 = null;
        Date dateFrom = null;
        Date dateTo = null;
        if (m.find()) {
            field1 = m.group(1);
            field2 = m.group(3);
            value1 = m.group(4);
            String d1 = m.group(6);
            String d2 = m.group(7);
            try {
                dateFrom = new SimpleDateFormat("d.M.yyyy H:m:s").parse(d1);
            } catch (Exception e) {
                dateFrom = null;
            }
            try {
                dateTo = new SimpleDateFormat("d.M.yyyy H:m:s").parse(d2);
            } catch (Exception e) {
                dateTo = null;
            }
            switch (field1) {
                case "ip": {
                    res.addAll(getAllIps(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "user": {
                    res.addAll(getAllUsers(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "date": {
                    res.addAll(getAllDates(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "event": {
                    res.addAll(getAllEvents(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "status": {
                    res.addAll(getAllStatuses(field2, value1, dateFrom, dateTo));
                    break;
                }
            }
        }
        return res;
    }
    private boolean isFieldMatch(String field, String value, LogRecord record) throws ParseException {
        boolean criteria = false;
        if (field == null) return true;
        if (value == null) return false;
        switch (field) {
            case "ip": {
                criteria = record.getIp().equals(value);
                break;
            }
            case "user": {
                criteria = record.getUser().equals(value);
                break;
            }
            case "date": {
                criteria = record.getDate().equals(new SimpleDateFormat("d.M.yyyy H:m:s").parse(value));
                break;
            }
            case "event": {
                criteria = record.getEvent().equals(Event.valueOf(value));
                break;
            }
            case "status": {
                criteria = record.getStatus().equals(Status.valueOf(value));
                break;
            }
        }
        return criteria;
    }
    private Set<String> getAllIps(String field, String value, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    users.add(record.getIp());
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return users;
    }
    private Set<Date> getAllDates(String field, String value, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    dates.add(record.date);
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return dates;
    }
    private Set<Status> getAllStatuses(String field, String value, Date after, Date before) {
        Set<Status> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    set.add(record.getStatus());
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return set;
    }
    private Set<Event> getAllEvents(String field, String value, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    set.add(record.getEvent());
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return set;
    }
    private Set<String> getAllUsers(String field, String value, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    users.add(record.getUser());
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return users;
    }
    private Set<String> getIpSet(Object recordField, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && isFieldMatch(recordField, record)) {
                ipSet.add(record.getIp());
            }
        }
        return ipSet;
    }
    private List<LogRecord> getParsedRecords(Path logDir) {
        List<LogRecord> recordList = new ArrayList<>();
        try {
            for (File file : logDir.toFile().listFiles()) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".log"))
                    for (String record : Files.readAllLines(file.toPath())) {
                        recordList.add(new LogRecord(record));
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordList;
    }
    private boolean isFieldMatch(Object recordField, LogRecord record) {
        boolean criteria = false;
        if (recordField == null)
            return true;
        if (recordField instanceof String)
            criteria = record.getUser().equals(recordField);
        else if (recordField instanceof Event)
            criteria = record.getEvent().equals(recordField);
        else if (recordField instanceof Status)
            criteria = record.getStatus().equals(recordField);
        return criteria;
    }
    private boolean isDateInside(Date after, Date before, Date currentDate) {
        if (after != null) {
            if (currentDate.getTime() < after.getTime())
                return false;
        }
        if (before != null) {
            if (currentDate.getTime() > before.getTime())
                return false;
        }
        return true;
    }
    private class LogRecord {
        private String ip;
        private String user;
        private Date date;
        private Event event;
        private String taskNumber;
        private Status status;
        public LogRecord(String ip, String user, Date date, Event event, Status status) {
            this.ip = ip;
            this.user = user;
            this.date = date;
            this.event = event;
            this.status = status;
        }
        public LogRecord(String record) {
            String[] strings = record.split("\t");
            this.ip = strings[0].trim();
            this.user = strings[1];
            SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");
            try {
                date = dateFormat.parse(strings[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String eventAndParameter[] = strings[3].split(" ");
            event = Event.valueOf(eventAndParameter[0]);
            if (eventAndParameter.length > 1) taskNumber = eventAndParameter[1];
            status = Status.valueOf(strings[4]);
        }
        public String getIp() {
            return ip;
        }
        public String getUser() {
            return user;
        }
        public Date getDate() {
            return date;
        }
        public Event getEvent() {
            return event;
        }
        public String getTaskNumber() {
            return taskNumber;
        }
        public Status getStatus() {
            return status;
        }
    }
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
