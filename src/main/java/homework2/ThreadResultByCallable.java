package homework2;

import java.util.concurrent.*;

/**
 * 使用Callable接口和ExecutorService
 *
 * @author lizhe
 */
public class ThreadResultByCallable {

    private final static ExecutorService threadPool = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable task = () -> {
            return sum();
        };

        Future submit = threadPool.submit(task);
        System.out.println(submit.get());
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
