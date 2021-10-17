package homework2;

/**
 * @author lizhe
 */
public class ThreadResultByWaitNotify implements Runnable {

    protected static Object lock = new Object();

    private int result;

    public int getResult() {
        return result;
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadResultByWaitNotify task = new ThreadResultByWaitNotify();
        Thread thread = new Thread(task);
        thread.start();

        synchronized (lock) {
            lock.wait();
            System.out.println(task.result);
        }
    }

    public void run() {
        synchronized (lock) {
            result = sum();
            lock.notify();
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
