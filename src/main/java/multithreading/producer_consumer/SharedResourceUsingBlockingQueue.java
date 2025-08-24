package multithreading.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SharedResourceUsingBlockingQueue {

    /**
     * Suing Blocking Queue we do not need to handle wait and notify It will do by Itself
     */
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try{
                for (int i = 0; i < 10; i++) {
//                sharedQueue.add(i);// using blocking specific method otherwise if its full then it will thorw the exception
                    sharedQueue.put(i); //block the thread if queue is full
                    System.out.println("Produced: " + i);
                    Thread.sleep(100);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        });
        Thread consumer = new Thread(() -> {
            try{
              for (int i = 0; i < 10; i++) {
//                 sharedQueue.poll();// return null if queue is empty
                  sharedQueue.take(); //block the thread if queue is empty
                 System.out.println("Consumed: " + i);
                 Thread.sleep(100);
              }
            } catch (InterruptedException  e) {
                //handle exception
            }
        });
        producer.start();
        consumer.start();
        Thread.sleep(1000);
        System.out.println("main thread Complted");
    }


}
