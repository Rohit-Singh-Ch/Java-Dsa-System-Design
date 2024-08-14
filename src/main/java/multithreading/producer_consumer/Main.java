package multithreading.producer_consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SharedResource resource = new SharedResource(3);

        //creating producer thread
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 6; i++) {
                try {
                    resource.produce(i);
                } catch (InterruptedException e) {
                    //handler exception here
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 6; i++) {
                try {
                    resource.consume();
                } catch (InterruptedException e) {
                    //handler exception here
                }
            }
        });
        producerThread.start();
        consumerThread.start();
        Thread.sleep(1000);
        System.out.println("main thread Complted");
    }
}
