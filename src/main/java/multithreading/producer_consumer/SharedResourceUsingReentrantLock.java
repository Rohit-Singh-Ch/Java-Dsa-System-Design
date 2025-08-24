package multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceUsingReentrantLock {

    private static final int QUEUE_SIZE = 5;
    private static Queue<Integer> sharedBuffer = new LinkedList<>();

    private static final Lock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();

    public static void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (sharedBuffer.size() == QUEUE_SIZE) {
                System.out.println("Buffer is full, Producer is waiting");
                notFull.await();
            }
            sharedBuffer.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signalAll(); // notify consumers
        } finally {
            lock.unlock();
        }
    }

    public static void consume() throws InterruptedException {
        lock.lock();
        try {
            while (sharedBuffer.isEmpty()) {
                System.out.println("Buffer is empty, Consumer is waiting");
                notEmpty.await();
            }
            Integer item = sharedBuffer.poll();
            System.out.println("Consumed: " + item);
            notFull.signalAll(); // notify producers
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    produce(i);
                    Thread.sleep(200); // just to slow down producer
                } catch (InterruptedException ignored) {}
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    consume();
                    Thread.sleep(500); // slow down consumer
                } catch (InterruptedException ignored) {}
            }
        });

        producerThread.start();
        consumerThread.start();
    }

}
