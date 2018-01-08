
//And the two disciples heard him speak, and they followed Jesus. (John 1:37)

            @author: Captain

package com.javarush.task.task35.task3513;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private static final Color BG_COLOR = new Color(0xbbada0);
    private static final String FONT_NAME = "Arial";
    private static final int TILE_SIZE = 96;
    private static final int TILE_MARGIN = 12;

    private Controller controller;

    boolean isGameWon = false;
    boolean isGameLost = false;

    public View(Controller controller) {
        setFocusable(true);
        this.controller = controller;
        addKeyListener(controller);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(BG_COLOR);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                drawTile(g, controller.getGameTiles()[y][x], x, y);
            }
        }

        g.drawString("Score: " + controller.getScore(), 140, 465);

        if (isGameWon) {
            JOptionPane.showMessageDialog(this, "You've won!");
        } else if(isGameLost) {
            JOptionPane.showMessageDialog(this, "You've lost :(");
        }
    }

    private void drawTile(Graphics g2, Tile tile, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int value = tile.value;
        int xOffset = offsetCoors(x);
        int yOffset = offsetCoors(y);
        g.setColor(tile.getTileColor());
        g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE , 8, 8);
        g.setColor(tile.getFontColor());
        final int size = value < 100 ? 36 : value < 1000 ? 32 : 24;
        final Font font = new Font(FONT_NAME, Font.BOLD, size);
        g.setFont(font);

        String s = String.valueOf(value);
        final FontMetrics fm = getFontMetrics(font);

        final int w = fm.stringWidth(s);
        final int h = -(int) fm.getLineMetrics(s, g).getBaselineOffsets()[2];

        if (value != 0)
            g.drawString(s, xOffset + (TILE_SIZE - w) / 2, yOffset + TILE_SIZE - (TILE_SIZE - h) / 2 - 2);
    }

    private static int offsetCoors(int arg) {
        return arg * (TILE_MARGIN + TILE_SIZE) + TILE_MARGIN;
    }
}

/*
2048 (9)

Ты отлично справляешься! Так хорошо, что я решил тебе немного помочь и уже реализовал класс View.

Он достаточно прост. Наследуемся от класса JPanel, переопределяем метод paint и выводим на экран

текущее состояние модели, полученное через контроллер.



Тебе же, предстоит закончить реализацию класса Controller.



Для начала нам понадобится конструктор, он будет принимать один параметр типа Model, инициализировать поле model, а также сохранять в поле view новый объект типа View с текущим контроллером(this) в качестве параметра конструктора.



Далее, нам нужен метод resetGame, который позволит вернуть игровое поле в начальное состояние. Необходимо обнулить счет, установить флаги isGameWon и isGameLost у представления в false и вызывать метод resetGameTiles у модели.



Добавим приватную константу int WINNING_TILE = 2048. Она будет определять вес плитки при достижении которого игра будет считаться выигранной.



Ну а теперь, самое главное! Для того чтобы иметь возможность обрабатывать пользовательский ввод, необходимо переопределить метод keyPressed с одним параметром типа KeyEvent.



Логика метода должна быть следующей:

1. Если была нажата клавиша ESC - вызови метод resetGame.

2. Если метод canMove модели возвращает false - установи флаг isGameLost в true.

3. Если оба флага isGameLost и isGameWon равны false - обработай варианты движения:

а) для клавиши KeyEvent.VK_LEFT вызови метод left у модели;

б) для клавиши KeyEvent.VK_RIGHT вызови метод right у модели;

в) для клавиши KeyEvent.VK_UP вызови метод up у модели;

г) для клавиши KeyEvent.VK_DOWN вызови метод down у модели.

4. Если поле maxTile у модели стало равно WINNING_TILE, установи флаг isGameWon в true.

5. В самом конце, вызови метод repaint у view.



P.S. Для получения кода нажатой клавиши используй метод getKeyCode класса KeyEvent.





Требования:

1. В классе Controller должна быть создана приватная статическая константа int WINNING_TILE = 2048.

2. Конструктор класса Controller с одним параметром типа Model должен быть реализован в соответствии с условием задачи.

3. Метод resetGame должен возвращать игру в начальное состояние, как описано в условии задачи.

4. Метод keyPressed должен вызывать метод resetGame в случае, если была нажата клавиша ESC.

5. Метод keyPressed должен устанавливать флаг isGameLost в true в случае, если ход невозможен.

6. Метод keyPressed должен вызывать корректные методы перемещения игрового поля, в случае если была нажата подходящая клавиша и оба флага isGameLost и isGameWon равны false.

7. Метод keyPressed должен устанавливать флаг isGameWon равным true в случае, если значения полей model.maxTile и WINNING_TILE стали равны после передвижения.

8. Метод keyPressed должен вызывать метод repaint у объекта сохраненного в поле view.
*/
