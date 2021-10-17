package homework2;

import java.util.concurrent.CountDownLatch;

/**
 * @author lizhe
 */
public class ThreadResultByCountDownLatch implements Runnable {

    private static int result;

    private CountDownLatch countDownLatch;


    public ThreadResultByCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ThreadResultByCountDownLatch task = new ThreadResultByCountDownLatch(countDownLatch);
        new Thread(task).start();
        countDownLatch.await();
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

    @Override
    public void run() {
        try {
            result = sum();
        } finally {
            countDownLatch.countDown();
        }
    }
}
