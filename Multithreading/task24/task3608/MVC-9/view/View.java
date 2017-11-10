
//For you are yet carnal: for while there is among you envying, and strife, and divisions, are you not carnal, and walk as men? (1Cor 3:3)

package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
