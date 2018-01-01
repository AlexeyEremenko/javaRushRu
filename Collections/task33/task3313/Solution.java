
//And shall go out to deceive the nations which are in the four quarters of the earth, Gog and Magog, to gather them together to battle: the number of whom is as the sand of the sea. (Revelation 20:8)

public class Event {
    public String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    public Date eventDate;

    public Event(String name) {
        this.name = name;
        eventDate = new Date();
    }
}

/*
Сериализация даты в JSON

Используя аннотацию JsonFormat сделай так, чтобы поле содержащее дату в классе Event сериализировалось в формате (dd-MM-yyyy hh:mm:ss).





Требования:

1. Поле eventDate в классе Event должно быть отмечено аннотацией @JsonFormat.

2. Объекты типа Event должны корректно сериализовываться в JSON в соответствии с условием задачи.

3. В конструкторе класса Event должен быть создан новый объект типа Date без аргументов.

4. Поле eventDate должно быть публичным.
*/
