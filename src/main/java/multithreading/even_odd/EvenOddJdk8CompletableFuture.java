package multithreading.even_odd;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddJdk8CompletableFuture {


    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        IntPredicate oddPredicate = x -> x % 2 != 0;
        IntPredicate evenPredicate = x -> x % 2 == 0;


        CompletableFuture.runAsync(() -> printResult(oddPredicate));
        CompletableFuture.runAsync(() -> printResult(evenPredicate));
        Thread.sleep(1000);

//        CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(() -> printResult(oddPredicate));
//        CompletableFuture<Void> evenFuture = CompletableFuture.runAsync(() -> printResult(evenPredicate));
//        CompletableFuture.allOf(oddFuture, evenFuture).join();
    }

    public static void printResult(IntPredicate condition) {
        IntStream.rangeClosed(1,10)
                .filter(condition)
                .forEach(EvenOddJdk8CompletableFuture::execute);
    }

    public static void execute(int val) {
        synchronized (lock){
            System.out.println("current thread:" + Thread.currentThread().getName() + ", value: " + val);
            lock.notify();
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
