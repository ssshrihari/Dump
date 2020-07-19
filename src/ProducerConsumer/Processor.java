package ProducerConsumer;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


@SuppressWarnings("InfiniteLoopStatement")
public class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
   // private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            lock.lock();
                //whenever the thread is notified starts again from the loop
                while (list.size() == LIMIT) {
                    notEmpty.await();// wait() is also true
                }
                list.add(value);

                System.out.println(Thread.currentThread().getId()+ " Producer added: " + value + " queue size is " + list.size());
                value++;
                notFull.signalAll();
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            lock.lock();
                while (list.size() == 0) {
                    notFull.await();
                }

                int value = list.removeFirst();
                System.out.print(Thread.currentThread().getId()+ " Removed value by consumer is: " + value);
                System.out.println(" Now list size is: " + list.size());
                notEmpty.signalAll();
            lock.unlock();
            Thread.sleep(random.nextInt(500)); //force producer fill the queue to LIMIT_SIZE
        }
    }
}