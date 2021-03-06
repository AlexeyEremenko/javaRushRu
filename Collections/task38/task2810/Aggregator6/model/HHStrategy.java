
//And no man hath ascended up to heaven, but he that came down from heaven, even the Son of man which is in heaven. (John 3:13)

package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Jesus Lord Almighty
 * at 12.01.18
 */

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {

        try {
            Document doc = Jsoup.connect("http://hh.ua/search/vacancy?text=java+%s&page=%d").get();
        }


        catch (IOException e) {
            e.printStackTrace();
        }


        return Collections.EMPTY_LIST;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format("%s?text=%s&page=%s",URL_FORMAT, searchString, page);
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .timeout(5000)
                .referrer("http://google.ru")
                .get();
    }
}

/*
Aggregator (6)

1. Слева в панеле Project найди снизу External Libraries. В jsoup найди пакет examples, посмотри классы в этом пакете.



2. По аналогии с реализацией в примерах кода jsoup - реализуй коннекшен к урлу ХэдХантера методом GET.



Это нужно сделать в методе getVacancies класса HHStrategy.



Подсказка: получится объект класса Document.



3. Поставь брекпоинт сразу после коннекшена. Запусти программу в дебаг моде.



Скопируй полученное значение document.html() в буфер.



4. Создай файл с расширением html где-то в корне проекта.



Вставь содержимое буфера в этот файл и отформатируй его Ctrl+Alt+L, IDEA умеет форматировать HTML.



Ура! Это код страницы HTML :)



5. Реализуй в вакансии (Vacancy) методы equals/hashCode.



Alt+Enter - equals() and hashCode().





Требования:

1. В методе getVacancies класса HHStrategy реализуй коннекшен к урлу ХэдХантера методом GET.

2. Скопируй html код полученной странички себе в файл для дальнейшего анализа (проверка этого требования не выполняется).

3. В классе Vacancy сгенерируй с помощью IDE методы equals() и hashCode().

Aggregator (5)

1. Добавь в интерфейс метод getVacancies(String searchString), который будет возвращать список вакансий.



2. Поправь ошибки в классе HHStrategy.



3. Вернись в метод getJavaVacancies класса Provider, реализуй его логику из расчета, что всех данных хватает.



4. Давай попробуем запустить и посмотреть, как работает наша программа.

В методе main вместо вывода на экран напиши controller.scan();

Воспользуйся подсказкой IDEA и создай метод.

Внутри метода пройдись по всем провайдерам и собери с них все вакансии, добавь их в список. Выведи количество вакансий в консоль.



5. Исправь NPE, если появляется это исключение (поставь заглушку).



Aggregator (4)

Открой сайт ХэдХантер - http://hh.ua/ или http://hh.ru/

В строке поиска набери "java Киев", снизу перейди на вторую страницу, т.к. урлы часто отличаются на первой странице и далее.

У меня получилась такая ссылка:

http://hh.ua/search/vacancy?text=java+Киев&page=1

Из этого следует, что

1) если тебе нужно будет фильтровать по городу, то ты добавишь его после слова java, разделив их знаком "+",

2) нумерация страниц начинается с 0.



Итак, ссылка будет примерно такой:

http://hh.ua/search/vacancy?text=java+ADDITIONAL_VALUE&page=PAGE_VALUE



1. Из полученной ссылки в HHStrategy создай приватную строковую константу URL_FORMAT, которая будет передаваться в String.format.

String.format(URL_FORMAT, "Kiev", 3) должно равняться

"http://hh.ua/search/vacancy?text=java+Kiev&page=3"

или

"http://hh.ru/search/vacancy?text=java+Kiev&page=3"

Для этого скопируйте ссылку в код и нажмите на ней нужную комбинацию клавиш.

Ctrl+Alt+C(Constant) - создание констант,

Ctrl+Alt+M(Method) - создание методов,

Ctrl+Alt+V(Variable) - создание переменных.



2. Тебе нужно программно получить исходный код страницы. Это HTTP запрос. Тебе понадобится Java HTML Parser.

Хороший парсер jsoup, будешь использовать его.

Найди сайт jsoup - Java HTML Parser, скачай с него либу версии и 1.9.2 и ее сорцы(sources). Класть их внутрь проекта не нужно!



3. Подключи новые либы:

В IDEA открой Project Structure (в меню File).

Слева выбери Project Settings -> Libraries, в окошке справа сверху нажми "+".

Выбери "Java", если либы еще не нет, либо "Attach Files or Directories", чтоб добавить джарники к существующей либе.

В диалоговом окне открой путь к папке из п.2, открой саму папку и выбери все либы - *.jar файлы.



4. Прочитай дополнительный материал к лекции в Сообществе.



Aggregator (3)

Начиная с этого задании ты начнешь писать логику получения данных с сайта.

Эта логика будет полностью сосредоточена в классах, реализующих Strategy.



Провайдер в данном случае выступает в качестве контекста, если мы говорим о паттерне Стратегия.

В провайдере должен быть метод, который будет вызывать метод стратегии для выполнения главной операции.

Этот метод будет возвращать все java вакансии с выбранного сайта (ресурса).



1. В корне задачи создай пакет vo (value object), в котором создай класс Vacancy.

Этот класс будет хранить данные о вакансии.



2. В Provider создай метод List<Vacancy> getJavaVacancies(String searchString). Оставь пока метод пустым.



3. Что есть у вакансии?

Название, зарплата, город, название компании, название сайта, на котором вакансия найдена, ссылка на вакансию. В классе Vacancy создай соответствующие строковые поля: title, salary, city, companyName, siteName, url.



4. Создай геттеры и сеттеры для всех полей класса Vacancy.



5. В пакете model создай класс HHStrategy от Strategy.

Этот класс будет реализовывать конкретную стратегию работы с сайтом ХэдХантер (http://hh.ua/ и http://hh.ru/).



Aggregator (2)

1. Создай класс Controller, в нем будет содержаться бизнес логика.



2. В Controller добавь паблик конструктор, который будет принимать столько провайдеров, сколько в него передадут для обработки.

Сохрани их в приватное поле providers.

Помнишь, как это делать? Нужно нажать на аргументе конструктора Alt+Enter, выбрать Create Field for Parameter 'providers'.



3. Если провайдеры не переданы в конструктор контроллера, то брось IllegalArgumentException.



4. Создай метод toString в классе Controller (Alt+Insert -> toString()) со стандартной реализацией (должен выводить поле providers).



5. В методе main создай провайдер, а потом создай контроллер с этим провайдером.



6. В методе main выведи в консоль созданный экземпляр Controller-а.



Aggregator (1)

Пришло время немного поработать с информацией в инете. В этом задании ты будешь писать агрегатор java вакансий.

Что у нас должно быть?

Должен быть список сайтов, на которых мы ищем вакансии.

Для начала возьмем http://hh.ua/ и http://hh.ru/, потом уже добавим другие сайты поиска работы.

Это один и тот же сайт, только в разных доменах.



С чего же нужно начать реализацию? Конечно же с метода main : )

1. Создай класс Aggregator с методом main.



2. Создай пакет model, в нем создай класс Provider.

Этот класс будет обобщать способ получения данных о вакансиях.



3. Т.к. для каждого сайта будет выполняться одинаковый сценарий, то будет паттерн Стратегия. Почитай про него в инете на вики.

В пакете model создай интерфейс Strategy.

Он будет отвечать за получение данных с сайта.



4. В класс Provider добавь поле Strategy strategy. Добавь конструктор с этим полем и сеттер.
*/
