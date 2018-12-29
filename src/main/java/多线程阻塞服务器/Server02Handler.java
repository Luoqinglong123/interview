package 多线程阻塞服务器;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Server02Handler implements Runnable {

    private Logger logger = Logger.getLogger(Server02Handler.class);

 

    private Socket socket;

 

    public Server02Handler(Socket socket) {

        this.socket = socket;

    }

 
    @Override
    public void run() {

        try {

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

                if (socket != null)

                    socket.close();

            }catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

}