
//Blessed and holy is he that hath part in the first resurrection: on such the second death hath no power, but they shall be priests of God and of Christ, and shall reign with him a thousand years. (Revelation 20:6)

package com.javarush.task.task33.task3311;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;


public class RealBean {
    protected final int id;
    protected final String name;

    protected Map<String, Object> additionalMap = new HashMap<>();

    @JsonCreator
    public RealBean(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalMap() {
        return additionalMap;
    }

    @JsonAnySetter
    public void setAdditionalMap(String name, Object value) {
        additionalMap.put(name, value);
    }
}

/*
Странная ошибка

НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1



В результате выполнения кода в методе main класса Solution возникает странная ошибка

при сериализации/десериализации в JSON. На экран должна быть выведена строка sampleJsonString,

а выводится не совсем она.



Разберись в чем проблема и исправь. Обрати внимание на класс RealBean.





Требования:

1. Метод getAdditionalMap должен быть отмечен одной подходящей Jackson аннотацией.

2. Сериализация элементов additionalMap в json должна происходить, как сериализация обычных полей класса.

3. Десериализация элементов additionalMap из json должна происходить, как десериализация обычных полей класса.

4. Метод main должен выводить данные на экран.
*/
