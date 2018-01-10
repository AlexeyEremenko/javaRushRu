
//This beginning of miracles did Jesus in Cana of Galilee, and manifested forth his glory; and his disciples believed on him. (John 2:11)

package com.javarush.task.task37.task3713.space.crew;

public abstract class AbstractCrewMember {
    public enum CompetencyLevel {
        NOVICE,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

    protected CompetencyLevel competencyLevel;

    protected AbstractCrewMember nextCrewMember;

    public void setNextCrewMember(AbstractCrewMember nextCrewMember) {
        this.nextCrewMember = nextCrewMember;
    }

    public void handleRequest(CompetencyLevel competencyLevel, String request) {
        if (this.competencyLevel ==  competencyLevel) {
            doTheJob(request);
            return;
        }
        if (this.competencyLevel.ordinal() <  competencyLevel.ordinal()) {
            nextCrewMember.handleRequest(competencyLevel, request);
        }
    }

    protected abstract void doTheJob(String request);
}

/*
Chain of Responsibility

Амиго, у нас проблема! Во время визита на планету #IND893 мы рискнули отдать на аутсорсинг автоматизацию входящих задач для членов команды. В это сложно поверить, но похоже всю работу теперь должен выполнять первый помощник!



Необходимо срочно исправить поведение программы, ведь полы может помыть и юнга, а приказ "к бою!" может дать только капитан.



P.S. Постарайся реализовать метод handleRequest таким образом, чтобы при добавлении новых должностей нам не требовалось вносить в него изменения. Другие методы не трогай.



P.P.S. Все enum поддерживают интерфейс Comparable.





Требования:

1. Запрос должен быть обработан текущим членом команды, если это возможно.

2. Запрос должен быть передан по цепочке выше, если текущий член команды не может его обработать.

3. Классы CabinBoy, Engineer, FirstMate и Captain должны быть потомками класса AbstractCrewMember.

4. Класс AbstractCrewMember должен быть абстрактным.
*/
