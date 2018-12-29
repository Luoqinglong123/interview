package juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author qinglong.luo
 * @version V1.0.0
 * @time 2018/11/21 9:53
 * @description 采用“锁分段”机制  默认分配了16个段  1.8以后底层用cas算法
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        for (int i = 0; i < 10; i++) {
            new Thread(test).start();
        }
    }


}

class ThreadTest implements Runnable {
    //此包装可以将list里面的方法都定位同步
    //private static List<String> list = Collections.synchronizedList(new ArrayList<String>());
    /**
     * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，将集合复制成为一个新的供操作，开销非常的大。并发迭代操作多时可以选择。
     */
    private static List<String> list = new CopyOnWriteArrayList<String>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add("AA");
        }
    }
}
