
//He was in the world, and the world was made by him, and the world knew him not. (John 1:10)

package com.javarush.task.task31.task3110.command;

public class ZipExtractCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        
    }
}

/*
Archiver (5)

Разделим команды на два типа: те, которые работают непосредственно с архивом и вспомогательные

(например EXIT). Все команды первого типа, будут иметь общий функционал, его удобно вынести в какой-то их общий базовый класс. Назовем этот класс ZipCommand. Он, как и все классы команд, должен реализовывать интерфейс Command. Все команды, которые работают с архивом, должны быть унаследованы от класса ZipCommand. Мы не будем создавать объекты класса ZipCommand, поэтому сделаем его абстрактным.



1. Создай абстрактный класс ZipCommand, реализующий интерфейс Command

2. Создай по одному классу для каждой команды. Все перечисленные команды должны быть унаследованы от ZipCommand и содержать пустую реализацию метода execute(), его реализацию мы будем писать для каждой команды отдельно по мере реализации нашего архиватора.

2.1. Команда создания архива (упаковки файлов в архив) - class ZipCreateCommand

2.2. Команда просмотра содержимого архива - class ZipContentCommand

2.3. Команда распаковки архива - class ZipExtractCommand

2.4. Команда добавления файла в архив - class ZipAddCommand

2.5. Команда удаления файла из архива - class ZipRemoveCommand





Требования:

1. В пакете command должен быть создан абстрактный класс ZipCommand реализующий интерфейс Command.

2. В пакете command должен быть создан класс ZipCreateCommand унаследованный от ZipCommand.

3. В пакете command должен быть создан класс ZipContentCommand унаследованный от ZipCommand.

4. В пакете command должен быть создан класс ZipExtractCommand унаследованный от ZipCommand.

5. В пакете command должен быть создан класс ZipAddCommand унаследованный от ZipCommand.

6. В пакете command должен быть создан класс ZipRemoveCommand унаследованный от ZipCommand.
*/
