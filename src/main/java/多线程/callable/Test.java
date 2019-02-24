package 多线程.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Test {

    public static void main(String[] args) throws Exception {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            list.add(service.submit(new MyTask((int) (Math.random() * 10))));
        }
        int sum = 0;
        for (Future<Integer> future : list
        ) {
            sum += future.get();
        }
        service.shutdown();
        System.out.println(sum);
    }
}