
//And the nations were angry, and thy wrath is come, and the time of the dead, that they should be judged,
//and that thou shouldest give reward unto thy servants the prophets, and to the saints, 
//and them that fear thy name, small and great; and shouldest destroy them which destroy the earth. (Revelation 11:18)

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
            Document doc = Jsoup.connect("http://hh.ua/search/vacancy?text=java+%s&page=%d")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36")
                    .referrer("https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2&area=5")
                    .get();
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
Aggregator (7)

Чтобы Хэдхантер знал, кто к нему коннектится, проставим Request Headers в наш запрос.



Для разработчиков созданы инструменты, которые показывают различную информацию про запросы.

Я расскажу тебе про два инструмента.



***Chrome****

1. В браузере Хром пойди в Меню - Инструменты - Инструменты разработчика, или нажми Ctrl+Shift+I

2. В браузерной строке набери URL http://hh.ua/search/vacancy?text=java+киев

3. Перейди на табу Network(Сеть), запрашиваемый URL должен быть в самом верху.

У него метод отправки данных GET (еще есть POST), статус 200(успешно)

4. Выбери его, откроется информация о страничке.

5. Найди Request Headers(Заголовки запроса)



***FireFox***

1. Для FireFox есть плагин FireBug. Ставь FireBug (Меню - Дополнения - Поиск - FireBug, установить).

2. Правой клавишей мыши - Инспектировать элемент с помощью FireBug. Перейди на табу Net(Сеть), подменю HTML.

3. В браузерной строке набери URL http://hh.ua/search/vacancy?text=java+киев

4. В подменю HTML появился список запросов включая набранный в браузерной строке. Нажми на нем и зайди в меню "Заголовки"

5. Найди Request Headers(Заголовки запроса)



Добавь в коннекшен к урлу Хедхантера userAgent и referrer.





Требования:

1. В методе getVacancies класса HHStrategy после создания коннекшена добавь заголовок userAgent.

2. В методе getVacancies класса HHStrategy после создания коннекшена добавь заголовок referrer.
*/
