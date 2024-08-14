package multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class SharedResource {

    private int bufferSize;
    private Queue<Integer> sharedBuffer;

    public SharedResource(int bufferSize){
        this.bufferSize = bufferSize;
        this.sharedBuffer = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        //if buffer is full, wait for the consumer to consume items
         if(bufferSize == sharedBuffer.size()){
             System.out.println("Buffer is full, Producer is waiting for consumer");
             wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced: " + item);
        //notify  the consumer that  there are item to consume now
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        //if buffer is empty, wait for the producer to produce items
        if(sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, Consumer is waiting for the producer");
            wait();
        }
        Integer item = sharedBuffer.poll();
        System.out.println("Consumed: "+ item);
        //Notify the producer that there are is space in the buffer now
        notify();
        return item;
    }
}
