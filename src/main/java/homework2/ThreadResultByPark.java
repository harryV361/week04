package homework2;

import java.util.concurrent.locks.LockSupport;

/**
 * @author lizhe
 */
public class ThreadResultByPark {

    private static int result;

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        Runnable task = () -> {
            result = sum();
            LockSupport.unpark(mainThread);
        };

        new Thread(task).start();
        LockSupport.park();
        System.out.println(result);
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
