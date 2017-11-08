
//And base things of the world, and things which are despised, has God chosen, yea, and things which are not,
//to bring to nothing things that are (1Cor 1:28)

--------------------------------------------------------Solution.java---------------------------------------------------------------
package com.javarush.task.task25.task2509;

import java.util.concurrent.*;

/* 
Все не так легко, как кажется
*/
public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

    public static void main(String[] args) {
    }
}
------------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------------------SocketTask.java------------------------------------------------------------
package com.javarush.task.task25.task2509;

import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.io.IOException;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        try {               //close all resources here
            socket.close();
        }catch (IOException ignored){ignored.printStackTrace();}
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                try{
                    socket.close();
                }catch (IOException ignored){ignored.printStackTrace();}
                
                finally{super.cancel(mayInterruptIfRunning);}
                
                return true;
            }
        };
    }
}
------------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------------------CancellableTask.java-------------------------------------------------------
package com.javarush.task.task25.task2509;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface CancellableTask<T> extends Callable<T> {
    void cancel();

    RunnableFuture<T> newTask();
}
------------------------------------------------------------------------------------------------------------------------------------
/*
Все не так легко, как кажется
1. Почитать в инете про Socket, ThreadPoolExecutor, RunnableFuture, Callable.
2. Реализуй логику метода cancel в классе SocketTask.
3. Реализуй логику метода cancel для локального класса внутри метода newTask в классе SocketTask.


Требования:
1. Определение класса SocketTask, его поля и сигнатуры методов менять нельзя.
2. Метод cancel в классе SocketTask должен закрывать используемые классом ресурсы.
3. Метод cancel для локального класса внутри метода newTask должен закрывать ресурсы SocketTask и вызвать cancel у родительского класса.
4. Метод у родительского класса должен быть вызван, даже если во время закрытия ресурсов было выкинуто исключение.

--------------------------------------------------------Solution.java---------------------------------------------------------------
package com.javarush.task.task25.task2509;

import java.util.concurrent.*;

/* 
Все не так легко, как кажется
*/
public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

    public static void main(String[] args) {
    }
}
------------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------------------SocketTask.java------------------------------------------------------------
package com.javarush.task.task25.task2509;

import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        //close all resources here
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                return false;
            }
        };
    }
}
------------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------------------CancellableTask.java-------------------------------------------------------
package com.javarush.task.task25.task2509;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface CancellableTask<T> extends Callable<T> {
    void cancel();

    RunnableFuture<T> newTask();
}
------------------------------------------------------------------------------------------------------------------------------------
*/
