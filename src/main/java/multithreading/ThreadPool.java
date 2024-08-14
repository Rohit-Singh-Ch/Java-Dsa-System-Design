package multithreading;

import java.util.concurrent.*;

public class ThreadPool {

    //Executors.defaultThreadFactory()
    //ThreadPoolExecutor.AbortPolicy
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 5,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                new MyCustomThreadFactory(), new MyCustomRejectHandler()
                );
        for (int i=1; i<=4 ;i++){
            executor.submit(() -> {
                try{
                    Thread.sleep(5000);
                }catch (Exception e){
                    //handler exception
                }
                System.out.println("Task processed by:" + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

class MyCustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread();
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false);
        return thread;
    }
}

class MyCustomRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task is rejected" + r.toString());
    }
}