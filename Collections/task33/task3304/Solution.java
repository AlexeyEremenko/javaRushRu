
//And I saw thrones, and they sat upon them, and judgment was given unto them:
//and I saw the souls of them that were beheaded for the witness of Jesus, and for the word of God,
//and which had not worshipped the beast, neither his image, neither had received his mark upon their foreheads,
//or in their hands; and they lived and reigned with Christ a thousand years. (Revelation 20:4)

public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, one);

        String oneClassName = one.getClass().getSimpleName().toLowerCase();
        String resClassName = resultClassObject.getSimpleName().toLowerCase();
        String replaceStr = stringWriter.toString().replaceFirst(oneClassName, resClassName);

        return objectMapper.readValue(new StringReader(replaceStr), resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}

/*
Конвертация из одного класса в другой используя JSON

НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1



Два класса имеют одинаковые поля, но не имеют общий суперкласс. Пример, классы First и Second.

Реализовать логику метода convertOneToAnother, который должен возвращать объект класса resultClassObject, значения полей которого равны значениям полей в объекте one.

Используй объект типа ObjectMapper.

Известно, что у классов есть JSON аннотация, у которой значение property равно имени класса в нижнем регистре.

На примере класса First, это className="first"

Классы First и Second не участвуют в тестировании, они предоставлены в качестве тестовых данных.





Требования:

1. Метод convertOneToAnother должен возвращать объект класса resultClassObject значения полей которого равны значениям полей объекта one.

2. В методе convertOneToAnother должен быть создан объект типа ObjectMapper.

3. Метод convertOneToAnother должен быть статическим.

4. Метод convertOneToAnother должен быть публичным.
*/
