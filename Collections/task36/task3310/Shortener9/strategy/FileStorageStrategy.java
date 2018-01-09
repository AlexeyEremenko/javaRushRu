
//And they of the people and kindreds and tongues and nations shall see their dead bodies three days and an half, and shall not suffer their dead bodies to be put in graves. (Revelation 11:9)

package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = 10000;
    private int size;

    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int) (h ^ (h >>> 7) ^ (h >>> 4));
    }

    public int indexFor(int hash, int length) {
        return hash % (length - 1);
    }

    public Entry getEntry(Long key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    public void transfer(FileBucket[] newTable) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                if (newTable[newIndex] == null) {
                    entry.next = null;
                    newTable[newIndex] = new FileBucket();
                } else {
                    entry.next = newTable[newIndex].getEntry();
                }
                newTable[newIndex].putEntry(entry);
                entry = next;
            }
            table[i].remove();
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;
        if (table[bucketIndex].getFileSize() > bucketSizeLimit)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;

            Entry entry = table[i].getEntry();
            while (entry != null) {
                if (entry.value.equals(value))
                    return true;

                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            addEntry(hash, key, value, index);
        } else {
            createEntry(hash, key, value, index);
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;

            Entry entry = table[i].getEntry();

            while (entry != null) {
                if (entry.value.equals(value))
                    return entry.key;
                entry = entry.next;
            }
        }
        return 0L;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null)
            return entry.value;

        return null;
    }
}

/*
Shortener (9)

Напишем еще одну стратегию, назовем ее FileStorageStrategy. Она будет очень похожа на стратегию OurHashMapStorageStrategy, но в качестве ведер (англ. buckets) будут файлы. Я знаю, ты знаешь о каких buckets идет речь, если нет - повтори внутреннее устройство HashMap.

9.1. Создай класс FileBucket в пакете strategy.

9.2. Добавь в класс поле Path path. Это будет путь к файлу.

9.3. Добавь в класс конструктор без параметров, он должен:

9.3.1. Инициализировать path временным файлом. Файл должен быть размещен в директории для временных файлов и иметь случайное имя.



Подсказка: Files.createTempFile.



9.3.2. Создавать новый файл, используя path. Если такой файл уже есть, то заменять его.

9.3.3. Обеспечивать удаление файла при выходе из программы.



Подсказка: deleteOnExit().



9.4. Добавь в класс методы:

9.4.1. long getFileSize(), он должен возвращать размер файла на который указывает path.

9.4.2. void putEntry(Entry entry) - должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.

9.4.3. Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.

9.4.4. void remove() - удалять файл на который указывает path.

Конструктор и методы не должны кидать исключения.





Требования:

1. В классе FileBucket должно быть создано поле path типа Path.

2. Конструктор без параметров класса FileBucket должен быть реализован в соответствии с условием задачи.

3. Метод getFileSize должен возвращать размер файла на который указывает path.

4. Метод putEntry должен сериализовывать полученный объект типа Entry в файл на который указывает path, чтобы получить OutputStream используй метод Files.newOutputStream.

5. Метод getEntry должен десериализовывать объект типа Entry из файл на который указывает path, чтобы получить InputStream используй метод Files.newInputStream.

6. Метод remove должен удалять файл на который указывает path с помощью метода Files.delete().
*/
