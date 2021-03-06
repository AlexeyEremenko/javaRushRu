
//So the disciples went away again to their own homes. (John 20:10)

package com.javarush.task.task23.task2303;

/* 
Запрети создание экземпляров класса
*/
public class Solution {

    public static abstract class Listener {
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
/*
Запрети создание экземпляров класса
Запрети создание экземпляров класса Listener.


Требования:
1. Класс Listener должен быть создан внутри класса Solution.
2. Класс Listener должен быть публичным.
3. Класс Listener должен быть статическим.
4. Должна быть запрещена возможность создавать экземпляры класса Listener.

package com.javarush.task.task23.task2303;

* 
Запрети создание экземпляров класса
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
