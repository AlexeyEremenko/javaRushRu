
//and he looked at Jesus as he walked, and said, "Behold, the Lamb of God!" (John 1:36)

package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    public static Car create(int type, int numberOfPassengers) {
        Car instance;
        if (type == TRUCK) {
            instance = new Truck(numberOfPassengers);
        } else if (type == CABRIOLET) {
            instance = new Cabriolet(numberOfPassengers);
        } else {
            instance = new Sedan(numberOfPassengers);
        }
        return instance;
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) {
        if (numberOfLiters < 0)
            throw new RuntimeException();
        fuel += numberOfLiters;
    }
    
    private boolean canPassengersBeTransferred() {
        if (isDriverAvailable() && fuel > 0) return true;
        return false;
    }
    
    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.before(summerStart) || date.after(summerEnd)) {return false;}
        return true;
    }
    
    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) 
            fastenPassengersBelts();
        fastenDriverBelt();
        
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();  
}

/*
Рефакторинг (12)
12.1. Объединение условных операторов.
12.1.1. Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры
boolean canPassengersBeTransferred() в класс Car. Метод должен возвращать true, если
водитель доступен isDriverAvailable и есть топливо fuel.
12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные
операторы (используй метод canPassengersBeTransferred()).
12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод
startMoving(), чтобы в нем не было повторяющихся вызовов функций.
12.3. Замена магического числа символьной константой. Замени магические числа в методе
getMaxSpeed() на константные переменные метода: MAX_TRUCK_SPEED,
MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
12.4. Замена условного оператора полиморфизмом.
12.4.1. Переопредели метод getMaxSpeed() в подклассах, избавившись от условного оператора.
12.4.2. Метод getMaxSpeed() в классе Car сделай абстрактным.


Требования:
1. Необходимо создать приватный метод boolean canPassengersBeTransferred() в классе Car и реализовать его.
2. Необходимо изменить метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы (используй метод canPassengersBeTransferred()).
3. Необходимо изменить метод startMoving(), чтобы в нем не было повторяющихся вызовов метода fastenDriverBelt().
4. Необходимо переопределить метод getMaxSpeed() в классе Truck. В методе нужно использовать константную переменную метода MAX_TRUCK_SPEED, значение которой равно 80.
5. Необходимо переопределить метод getMaxSpeed() в классе Sedan. В методе нужно использовать константную переменную метода MAX_SEDAN_SPEED, значение которой равно 120.
6. Необходимо переопределить метод getMaxSpeed() в классе Cabriolet. В методе нужно использовать константную переменную метода MAX_CABRIOLET_SPEED, значение которой равно 90.
7. Метод getMaxSpeed() в классе Car необходимо сделать абстрактным.
Рефакторинг (11)
11.1. Замена кода ошибки исключением. Перепиши метод заправиться fill(double
numberOfLiters), чтобы он в случае ошибки кидал исключение Exception.
11.2. Разбиение условного оператора.
11.2.1. Добавь и реализуй метод в классе Car, определяющий относится ли переданная дата к
лету: boolean isSummer(Date date , Date summerStart, Date summerEnd).
11.2.2. Добавь и реализуй метод, рассчитывающий расход топлива зимой: double
getWinterConsumption(int length).
11.2.3. Добавь и реализуй метод, рассчитывающий расход топлива летом: double
getSummerConsumption(int length).
11.2.4. Перепиши метод getTripConsumption(), используя новые методы.

Рефакторинг (10)
Разберись с кодом в пакете car (машина).
10.1. Замена конструктора фабричным методом.
10.1.1. Объяви классы Truck (грузовик), Sedan (седан) и Cabriolet (кабриолет), унаследованные от Car.
10.1.2. Добавь в них конструкторы, принимающие int numberOfPassengers.
10.1.3. Добавь фабричный статический метод Car create(int type, int numberOfPassengers) в класс Car и реализуй его.
10.1.4. Измени область видимости конструктора класса Car.

Рефакторинг (9)
9.1. Самоинкапсуляция поля. Перепиши метод incAverageGrade() используя сеттер и геттер для доступа к averageGrade.
9.2. Замена поля-массива объектом. Замени массив int[] size объектом нового типа Size,
содержащим публичные поля: рост int height и вес int weight. Публичный класс Size объяви
внутри класса Human.
9.3. Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для него.
9.4. Замена кодирования типа классом.
9.4.1. Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
9.4.4. Примени в классе Human новый тип BloodGroup.

Рефакторинг (8)
8.1. Удаление сеттера. Удали метод setId(). Поле id должно устанавливаться только в момент
создания объекта.
8.2. Сокрытие метода (поля). Изменить область видимости поля nextId в соответствии с
областью его использования.
8.3. Замена исключения проверкой условия. Перепиши метод removeStudent(int index), чтобы
он удалял студента из списка студентов только, если он там есть. Метод не должен кидать
исключение.
8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его
работы. В методе не должны использоваться флаги типа found, воспользуйся оператором
break.

Рефакторинг (7)
7.1. Параметризация метода. Замени методы incAverageGradeBy01() и incAverageGradeBy02() одним методом incAverageGrade(double delta).
7.2. Передача всего объекта. Перепиши метод addInfoAboutStudent(), чтобы он в качестве параметра принимал объект типа Student.
7.3. Замена параметра вызовом метода. Перепиши метод printInfoAboutStudent(), чтобы он не требовал в качестве параметра имя студента, а получал его, вызвав соответствующий метод у переданного объекта.
7.4. Замена параметров объектом. Перепиши методы setBeginningOfSession и setEndOfSession,чтобы они вместо набора параметров принимали по одному объекту даты.
*/
