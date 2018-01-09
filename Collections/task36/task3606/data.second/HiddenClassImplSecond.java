
//Nathanael answered and saith unto him, Rabbi, thou art the Son of God; thou art the King of Israel. (John 1:49)

package com.javarush.task.task36.task3606.data.second;

import com.javarush.task.task36.task3606.HiddenClass;

public class HiddenClassImplSecond implements HiddenClass {
    private HiddenClassImplSecond() {
    }
}

/*
Осваиваем ClassLoader и Reflection

Аргументом для класса Solution является абсолютный путь к пакету.

Имя пакета может содержать File.separator.

В этом пакете кроме скомпилированных классов (.class) могут находиться и другие файлы (например: .java).

Известно, что каждый класс имеет конструктор без параметров и реализует интерфейс HiddenClass.

Считай все классы с файловой системы, создай фабрику - реализуй метод getHiddenClassObjectByKey.

Примечание: в пакете может быть только один класс, простое имя которого начинается с String key без учета регистра.





Требования:

1. Реализуй метод scanFileSystem, он должен добавлять в поле hiddenClasses найденные классы.

2. Реализуй метод getHiddenClassObjectByKey, он должен создавать объект класса согласно условию задачи.

3. Метод main не изменяй.

4. Метод getHiddenClassObjectByKey не должен кидать исключений.
*/
