package homework2;

/**
 * @author lizhe
 */
public class ThreadResultByForWhile implements Runnable {

    private int result;

    public int getResult() {
        return result;
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadResultByForWhile myThread = new ThreadResultByForWhile();

        Thread thread = new Thread(myThread);
        thread.start();

        while (myThread.getResult() == 0) {
            System.out.println("循环等待");
        }
        System.out.println(myThread.getResult());
    }


    @Override
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
