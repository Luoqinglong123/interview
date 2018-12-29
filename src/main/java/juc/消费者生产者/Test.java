package juc.消费者生产者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qinglong.luo
 * @version V1.0.0
 * @time 2018/11/21 15:47
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product product = new Product(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(product, "生产者A").start();
        new Thread(product, "生产者C").start();
        new Thread(product, "生产者D").start();
        new Thread(consumer, "消费者B").start();

    }

}

class Clerk {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int productNum = 0;

    /**
     * 进货
     */
    public void get() {
        lock.lock();
        try {
            if (productNum >= 1) {
                System.out.println("仓库满了");
                //此线程睡眠
                condition.await();
            }

            System.out.println(Thread.currentThread().getName() + " : " + ++productNum);
            //唤醒其它线程
            condition.signalAll();
        } catch (Exception ex) {

        } finally {
            lock.unlock();
        }
    }

    /**
     * 销售
     */
    public void sail() {
        lock.lock();
        try {
            if (productNum <= 0) {
                System.out.println("没货了，需要补仓");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " : " + --productNum);
            condition.signalAll();
        } catch (Exception ex) {

        } finally {
            lock.unlock();
        }
    }

}

/**
 * 生产者
 */
class Product implements Runnable {
    private Clerk clerk;

    public Product(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sail();
        }
    }
}