package 自定义线程池多线程处理客户端请求;/*

 * 自定义线程池

 * 多线程处理客户端请求

 */

import org.apache.log4j.Logger;
import 多线程阻塞服务器.Server02Handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer03 {

    private Logger logger = Logger.getLogger(EchoServer03.class);

 

    private int PORT = 3015;

 

    private ServerSocket serverSocket;

 

    private ThreadPool threadPool; // 线程池

    private ExecutorService executorService; // 线程池

    private final int POOL_SIZE = 4; // 单个CPU时线程池中的工作线程个数

 

    public EchoServer03() throws IOException {

        serverSocket = new ServerSocket(PORT);

        // 创建线程池

        // Runtime的availableProcessors()方法返回当前系统的CPU格式

        // 系统的CPU越多，线程池中工作线程的数目也越多
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime()

                .availableProcessors()

                * POOL_SIZE);
        threadPool = new ThreadPool(Runtime.getRuntime().availableProcessors()

                *POOL_SIZE);

        logger.info("服务端启动....    端口号：" + PORT);

    }

 

    public void service() {

        while (true) {

            Socket socket = null;

            try {

                socket= serverSocket.accept();

                // 把与客户通信的任务交给线程池

                threadPool.execute(new Server02Handler(socket));

            }catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

 

    public static void main(String args[]) throws IOException {

        new EchoServer03().service();

    }

}