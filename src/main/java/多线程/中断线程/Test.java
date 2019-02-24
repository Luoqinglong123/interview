package 多线程.中断线程;

/**
 * 线程在出现中断异常后，会将isInterrupted标志位设为false
 */
public class Test {
    private static class Task implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            while (!thread.isInterrupted()) {
                System.out.println(thread.getName() + "is running");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(thread.getName() + "出现异常");
                    e.printStackTrace();
                    thread.interrupt();
                }
            }
            System.out.println(thread.getName() + "is down");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread taskThread = new Thread(task);
        taskThread.start();
        Thread.sleep(5000);
        taskThread.interrupt();
    }
}
