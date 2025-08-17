package multithreading.even_odd;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOddJdk8WithStream {


    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        IntStream.rangeClosed(1,10)
                .forEach(num -> {
                    CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(val -> {
                                if (val % 2 != 0) {
                                    System.out.println("current thread:" + Thread.currentThread().getName() + ", value: " + val);
                                }
                                return num;
                            },executorService);
                    oddCompletableFuture.join();

                    CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(val -> {
                                if (val % 2 == 0) {
                                    System.out.println("current thread:" + Thread.currentThread().getName() + ", value: " + val);
                                }
                                return num;
                            },executorService);
                    evenCompletableFuture.join();

                });
        executorService.shutdown();
    }

}
