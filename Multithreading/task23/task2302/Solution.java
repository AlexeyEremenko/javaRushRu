
//For as yet they didn't know the Scripture, that he must rise from the dead. (John 20:9)

package com.javarush.task.task23.task2302;

/* 
Запрети переопределение
*/
public class Solution {

    public static class Listener {
        public final void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {

    }
}
/*
Запрети переопределение
Запрети переопределение метода onMouseDown.


Требования:
1. Класс Listener должен быть создан внутри класса Solution.
2. Класс Listener должен быть публичным.
3. Метод onMouseDown должен быть публичным.
4. Должна быть запрещена возможность переопределить метод onMouseDown.

package com.javarush.task.task23.task2302;

* 
Запрети переопределение
*
public class Solution {

    public static class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {

    }
}

*/
