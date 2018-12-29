package 基于NIO的阻塞服务器;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class Server05Handler implements Runnable {

    private Logger logger = Logger.getLogger(Server05Handler.class);

 

    private SocketChannel socketChannel;

 

    public Server05Handler(SocketChannel socketChannel) {

        this.socketChannel = socketChannel;

    }

 

    public void run() {

        try {

            Socket socket = socketChannel.socket();

            logger.info("一个新的请求达到并创建  " + socket.getInetAddress() + ":"

                    +socket.getPort());

            InputStream socketIn = socket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(

                    socketIn));

            OutputStream socketOut = socket.getOutputStream();

            PrintWriter pw = new PrintWriter(socketOut, true);

 

            String msg = null;

            while ((msg = br.readLine()) != null) {

                logger.info("服务端受到的信息为：" + msg);

                pw.println(new Date()); // 给客户端响应日期字符串

                if (msg.equals("bye"))

                    break;

            }

        }catch (IOException e) {

            e.printStackTrace();

        }finally {

            try {

                if (socketChannel != null)

                    socketChannel.close();

            }catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

}