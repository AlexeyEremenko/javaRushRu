
//And ye also shall bear witness, because ye have been with me from the beginning. (John 15:27)

package com.javarush.task.task29.task2910;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task29.task2910.Constants.*;

public class Game {
    private List<Sportsman> members;
    Sportsman controlSportsman;

    public Game() {
        initializeControlSportsman();
        members = new ArrayList<>();
        for (int i = 0; i < SPORTSMAN_COUNT; i++) {
            members.add(new Sportsman(i + 1));
        }
    }

    private void initializeControlSportsman() {
        controlSportsman = new Sportsman(0);
        controlSportsman.setAverageSpeed(new BigDecimal(20.));
        controlSportsman.setChanceToHit(MAX_CHANCE_TO_HIT_IN_TARGET);
        controlSportsman.setCountHitOutTarget(2);
        controlSportsman.setResultTime(new BigDecimal("3640.00"));
        System.out.println("РЕЗУЛЬТАТ КОНТРОЛЬНО СПОРТСМЕНА:");
        controlSportsman.printResultInfo();
    }

    public void startCompetition() {
        for (int i = 0; i < members.size(); i++) {
            members.get(i).calculateNumberOfMiss();
            BigDecimal timeToRace = controlSportsman.getResultTime().subtract(BigDecimal.valueOf(members.get(i).getCountHitOutTarget() * PENALTY_TIME_PER_ONE_MISS));
            members.get(i).setAverageSpeed(new BigDecimal(RACE_LENGTH / (timeToRace.doubleValue() / 3600)).setScale(4, BigDecimal.ROUND_HALF_UP));
            members.get(i).calculateFullTime();
        }
    }

    public void printAllResults() {
        for (int i = 0; i < members.size(); i++) {
            members.get(i).printResultInfo();
        }
    }

    public void printSportsmanWithEqualTime() {
        for (Sportsman sportsman : getSportsmanWithEqualTime()) {
            sportsman.printResultInfo();
        }
    }

    private List<Sportsman> getSportsmanWithEqualTime() {
        List<Sportsman> result = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getResultTime().equals(controlSportsman.getResultTime())) {
                result.add((members.get(i)));
            }
        }
        return result;
    }
}

/*
Это архаичное слово "Биатлон"

Амиго, представляешь, в 21 веке существовал такой вид спорта – биатлон. Люди ездили на лыжах и стреляли на подготовленных площадках по мишеням. За одну серию стрельбы нужно было закрыть 5 мишеней. Стрельбы происходили как стоя, так и лежа, но не будем вдаваться в подробности. У лучших представителей рода человеческого средняя точность стрельбы достигала 90%, у крепких середнячков – 81,5%.

Я написал программу, которая создает соревнование, добавляет в него 30 спортсменов-биатлонистов. Каждому из них случайным образом выставляется точность (в диапазоне от 0,815 до 0,900). Штраф за каждый промах – плюс 20 секунд к результату. Еще у соревнования задается количество огневых рубежей – 4 и дистанция, которую биатлонисты должны преодолеть – 20 км.



Так же я создал контрольного спортсмена, у которого захардкожены показатели:

Скорость: 20 км/час;

Вероятность попадания: 0,900 (90%);

Количество промахов: 2 (Всего нужно попасть 20 раз. При точности 90 процентов ожидается 2 промаха);

Нужно проехать 20 км со скоростью 20 км/час. Необходимое время - 1 час, то есть 3600 секунд.

Время гонки (с учетом штрафных секунд): 3600 + 2 * 20 = 3640 секунд.

Я хочу определить, с какой скоростью должен ехать каждый спортсмен, при его случайном количестве промахов, чтобы результат в секундах был такой же, как и у контрольного спортсмена. В начале я вывожу результат контрольного спортсмена, потом все результаты. В конце я вывожу всех спортсменов, у которых время такое же, как и у контрольного спортсмена. У некоторых спортсменов за счет округления итоговое время отличается на доли секунды. Такие нам не нужны. У остальных время гонки ровно 3640 секунд, как и у контрольного спортсмена, но они не выводятся в секции "СПОРТСМЕНЫ С ТАКИМ ЖЕ ИТОГОВЫМ ВРЕМЕНЕМ, КАК У КОНТРОЛЬНОГО СПОРТСМЕНА:".



Твоя задача: сделать одно изменение в коде, чтобы исправить найденный баг.

Обрати внимание: все округления правильные, и новых добавлять не нужно!





Требования:

1. Запрещено изменять типы данных констант.

2. Вывод на экран в секции "СПОРТСМЕНЫ С ТАКИМ ЖЕ ИТОГОВЫМ ВРЕМЕНЕМ, КАК У КОНТРОЛЬНОГО СПОРТСМЕНА:" должен содержать всех спортсменов, у которых такое же время, как и у контрольного спортсмена.

3. Сделай одно изменение в классе Game.

4. Класс Constants не изменяй.

5. Класс Solution не изменяй.

6. Класс Sportsman не изменяй.
*/
