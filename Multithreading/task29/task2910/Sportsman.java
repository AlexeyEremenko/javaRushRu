
//And ye also shall bear witness, because ye have been with me from the beginning. (John 15:27)

package com.javarush.task.task29.task2910;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.task.task29.task2910.Constants.*;

public class Sportsman {

    private BigDecimal chanceToHit;
    private BigDecimal averageSpeed;
    private BigDecimal resultTime = new BigDecimal("0.");
    private int number;
    private int countHitOutTarget = 0;

    public Sportsman(int number) {
        this.number = number;
        chanceToHit = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(MIN_CHANCE_TO_HIT_IN_TARGET.doubleValue(), MAX_CHANCE_TO_HIT_IN_TARGET.doubleValue()));
    }

    public void calculateFullTime() {
        resultTime = resultTime.add(BigDecimal.valueOf(countHitOutTarget * PENALTY_TIME_PER_ONE_MISS));
        resultTime = resultTime.add(calculateTimeToRace());
    }

    private BigDecimal calculateTimeToRace() {
        return new BigDecimal(RACE_LENGTH / averageSpeed.doubleValue() * 3600).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void calculateNumberOfMiss() {
        for (int i = 0; i < NUMBER_OF_FIRE_LINES * 5; i++) {
            double temp = Math.random();
            if (temp < (1 - chanceToHit.doubleValue())) {
                countHitOutTarget++;
            }
        }
    }

    public void setAverageSpeed(BigDecimal averageSpeed) {
        this.averageSpeed = averageSpeed.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getResultTime() {
        return resultTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCountHitOutTarget() {
        return countHitOutTarget;
    }

    public void setCountHitOutTarget(int countHitOutTarget) {
        this.countHitOutTarget = countHitOutTarget;
    }

    public void setChanceToHit(BigDecimal chanceToHit) {
        this.chanceToHit = chanceToHit;
    }

    public void setResultTime(BigDecimal resultTime) {
        this.resultTime = resultTime;
    }

    public void printResultInfo() {
        System.out.printf("Спортсмен № %02d: Время - %6.2f секунд. Средняя скорость - %2.4f км/час. Количество промахов %d\n", number, resultTime.doubleValue(), averageSpeed, countHitOutTarget);
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
