package homework2;

import java.util.concurrent.Semaphore;

/**
 * @author lizhe
 */
public class ThreadResultBySemaphore implements Runnable {

    private static  int result;

    private Semaphore semaphore;

    public ThreadResultBySemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        ThreadResultBySemaphore task = new ThreadResultBySemaphore(semaphore);
        new Thread(task).start();
        while (semaphore.availablePermits() > 0) {

        }
        System.out.println(result);
    }


    @Override
    public void run() {
        try {
            result = sum();
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
