package homework2;

/**
 * 使用volatile关键字和t.join()方法
 *
 * @author lizhe
 */
public class ThreadResultByJoin {

    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            int sum = sum();
            result = sum;
        };

        Thread thread = new Thread(task);
        thread.start();
        thread.join();
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
