package async;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    private ExecutorService executorService;
    private CountDownLatch countDownLatch;
    private int parties;

    public static void main(String[] args){
        CountDownLatchExample countDownLatchExample = new CountDownLatchExample(10);
        try {
            countDownLatchExample.example();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public CountDownLatchExample(int parties) {
        executorService = Executors.newFixedThreadPool(parties);
        countDownLatch = new CountDownLatch(parties);
        this.parties = parties;
    }

    public void example() throws InterruptedException {
        for (int i = 0; i < parties; i++) {
            executorService.submit(() -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " gets job done");
                ThreadLocal t = new ThreadLocal();
                countDownLatch.countDown(); // �߳��������֮��countDown
            });
        }
        // �ȴ����е��������
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " reach barrier");
        executorService.shutdown();
    }
}
