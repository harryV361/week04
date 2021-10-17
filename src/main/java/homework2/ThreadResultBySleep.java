package homework2;

/**
 * @author lizhe
 */
public class ThreadResultBySleep implements Runnable {

    private int result;

    public int getResult() {
        return result;
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadResultBySleep myThread = new ThreadResultBySleep();

        Thread thread = new Thread(myThread);
        thread.start();
        Thread.sleep(1000);
        System.out.println(myThread.getResult());
    }

    public void run() {
        result = sum();
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
