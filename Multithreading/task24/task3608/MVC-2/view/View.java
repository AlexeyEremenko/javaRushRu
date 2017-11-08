
//Now he said this, signifying by what kind of death he would glorify God. When he had said this, he said to him, "Follow me." (John 21:19)

package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}


/*
MVC (2)
1. Создай пакет controller, в котором создай класс Controller.
Этот класс будет получать запрос от клиента, оповещать Модель об этом, а Модель, в свою очередь, будет обновлять ModelData.

2. Добавь в контроллер поле Model model вместе с сеттером.

3. В контроллере создай публичный метод void onShowAllUsers(), который должен обратиться к модели и инициировать загрузку пользователей.

4. Создай пакет view. В нем создай интерфейс View.

5. В интерфейс View добавь два метода: void refresh(ModelData modelData) и void setController(Controller controller)


Требования:
1. Класс Controller должен быть создан в пакете controller.
2. В классе Controller должно быть создано приватное поле Model model и сеттер для этого поля.
3. В классе Controller должен быть создан публичный метод void onShowAllUsers(), в котором у модели должен вызываться метод loadUsers().
4. Интерфейс View должен быть создан в пакете view.
5. В интерфейсе View должны быть объявлены два метода: void refresh(ModelData modelData) и void setController(Controller controller).
*/
