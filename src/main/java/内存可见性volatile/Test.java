package 内存可见性volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qinglong.luo
 * @version V1.0.0
 * @time 2018/10/23 17:00
 * @description
 */
public class Test {

    public static void main(String[] args) {
        AtomicDemo2 ad = new AtomicDemo2();

        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }

}

class AtomicDemo2 implements Runnable{

private volatile int serialNumber = 0;

   // private AtomicInteger serialNumber = new AtomicInteger(0);

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        System.out.println(getSerialNumber());
    }

    public int getSerialNumber(){
        return serialNumber++;
    }


}


