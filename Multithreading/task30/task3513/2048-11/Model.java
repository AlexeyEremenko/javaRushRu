
//He said to them, "Come, and see." They came and saw where he was staying, and they stayed with him that day. It was about the tenth hour. (John 1:39)

package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {

    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;

    Stack<Tile[][]> previousStates = new Stack<>();
    Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    int maxTile = 2;
    int score = 0;


    public Model() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        resetGameTiles();
    }

    private void addTile() {
        List<Tile> listForChanges = getEmptyTiles();
        if (listForChanges != null && listForChanges.size() != 0) {
            listForChanges.get((int) (listForChanges.size() * Math.random())).value =
                    (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTileList = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTileList.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTileList;
    }

    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value != 0 && (tiles[i].value == tiles[i + 1].value)) {
                if (tiles[i].value + tiles[i + 1].value > maxTile) {
                    maxTile = tiles[i].value + tiles[i + 1].value;
                }
                tiles[i].value = tiles[i].value + tiles[i + 1].value;
                score += tiles[i].value;
                tiles[i + 1].value = 0;
                changes = true;
                compressTiles(tiles);
            }
        }
        return changes;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value == 0 && i < tiles.length - 1 && tiles[i + 1].value != 0) {
                Tile temp = tiles[i];
                tiles[i] = tiles[i + 1];
                tiles[i + 1] = temp;
                i = -1;
                changes = true;
            }
        }
        return changes;
    }

    public void left() {

        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
            }
        }
    }

    public void rotate() {
        for (int k = 0; k < 2; k++) {
            for (int j = k; j < 3 - k; j++) {
                Tile alternative = gameTiles[k][j];
                gameTiles[k][j] = gameTiles[j][3 - k];
                gameTiles[j][3 - k] = gameTiles[3 - k][3 - j];
                gameTiles[3 - k][3 - j] = gameTiles[3 - j][k];
                gameTiles[3 - j][k] = alternative;
            }
        }
    }

    public void up() {
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void down() {
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 0; i < gameTiles.length - 1; i++) {
                if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tileForStack = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tileForStack[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tileForStack);
        int scoreForStack = score;
        previousScores.push(scoreForStack);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty()) {
            gameTiles = (Tile[][]) previousStates.pop();
        }
        if (!previousScores.isEmpty()) {
            score = (int)previousScores.pop();
        }
    }
}

/*
2048 (11)

Отличная работа! На этом этапе у нас уже есть полнофункциональное приложение, но ведь нет предела совершенству, давай еще поработаем.



Если ты успел какое-то время поиграть в 2048, то заметил, что порой очень хочется иметь возможность отменить последний ход.



Давай создадим в классе Model два стека, в одном будем хранить предыдущие состояния игрового поля, а в другом предыдущие счета. Назовем их previousStates и previousScores. Инициализировать можешь прямо в строке объявления или в конструкторе. Используй стандартную реализацию стека (java.util.Stack).



Добавим boolean поле isSaveNeeded = true, оно нам понадобится в будущем.



Хранилище состояний у нас есть, теперь реализуем два метода для работы с ними.

1. Приватный метод saveState с одним параметром типа Tile[][] будет сохранять текущее

игровое состояние и счет в стеки с помощью метода push и устанавливать флаг isSaveNeeded равным false.

2. Публичный метод rollback будет устанавливать текущее игровое состояние равным последнему находящемуся в стеках с помощью метода pop.



Обрати внимание на то, что при сохранении массива gameTiles необходимо создать новый массив и заполнить его новыми объектами типа Tile перед сохранением в стек.



В методе rollback достаточно просто выполнить присваивание (gameTiles = previousStates.pop()) и то же для счета, нет необходимости в глубоком копировании.



Перед восстановлением игрового состояния с помощью метода rollback не забудь проверить что стеки не пусты, чтобы избежать возникновения исключения EmptyStackException.





Требования:

1. В классе Model должны быть объявлены и инициализированы приватные поля previousStates, previousScores, isSaveNeeded.

2. Метод saveState должен сохранять в стек previousStates новый объект типа Tile[][] с помощью метода push.

3. После вызова метода saveState веса плиток в массиве который находится на вершине стека должны совпадать с весами плиток массива полученного в качестве параметра.

4. Метод saveState должен сохранять в стек previousScores текущее значение поля score с помощью метода push.

5. Метод saveState должен устанавливать флаг isSaveNeeded равным false.

6. Метод rollback должен восстанавливать поля score и gameTiles из соответствующих стеков, если они не пусты.

7. Метод rollback не должен модифицировать текущее игровое состояние в случае, если хотя бы один из стеков пуст.

8. Каждый вызов метода saveState должен увеличивать количество элементов в стеках на единицу.

9. Каждый вызов метода rollback должен уменьшать количество элементов в стеках на единицу, до тех пор пока это возможно.


*/
