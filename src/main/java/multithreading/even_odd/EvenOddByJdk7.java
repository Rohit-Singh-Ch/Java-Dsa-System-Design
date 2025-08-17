package multithreading.even_odd;


/**
 * write a program print even and odd number for a given range using multithreading.
 */
public class EvenOddByJdk7 implements Runnable{

    static final int Max = 10;
    static int counter = 1;
    Object object;

    public EvenOddByJdk7(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (counter <= Max){

            synchronized (object) {
                /**
                 * termination condition for
                 * odd prints 9, increments to 10, calls notify().
                 * even wakes up, prints 10, increments to 11, calls wait().
                 * odd wakes up again, sees 11 % 2 != 0 (still true for odd), prints 11 before checking the while loop condition again.
                 * That's why need to check counter reach max or not
                 */
                if (counter > Max) {
                    object.notifyAll(); // wake other thread before exit
                    break;
                }
                if(counter % 2 != 0 && Thread.currentThread().getName().equals("odd")){
                    System.out.println("current thread:" + Thread.currentThread().getName() + ", value: " + counter);
                    counter++;
                    object.notify();
                }
                if(counter % 2 == 0 && Thread.currentThread().getName().equals("even")){
                    System.out.println("current thread:" + Thread.currentThread().getName() + ", value: " + counter);
                    counter++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread odd = new Thread(new EvenOddByJdk7(object), "odd");
        Thread even = new Thread(new EvenOddByJdk7(object), "even");
        even.start();
        odd.start();
    }
}
