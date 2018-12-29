package 传统io;/*

 * 服务端只能一次处理一个客户端的请求

 * 多个请求到达后需要排队

 */

import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class EchoServer01 {

    private Logger logger = Logger.getLogger(EchoServer01.class);

    private int PORT = 3015;


    private ServerSocket serverSocket;


    public EchoServer01() throws IOException {
        // 请求队列最大长度为5
        serverSocket = new ServerSocket(PORT, 5);
        logger.info("服务端启动...   端口号：" + PORT);

    }


    public void service() {

        while (true) {

            Socket socket = null;

            try {

                socket = serverSocket.accept();

                logger.info("一个新的连接到达，地址为：" + socket.getInetAddress() + ":"

                        + socket.getPort());

                // 获得客户端发送信息的输入流

                InputStream socketIn = socket.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(

                        socketIn));

                // 给客户端响应信息的输出流

                OutputStream socketOut = socket.getOutputStream();

                PrintWriter pw = new PrintWriter(socketOut, true);


                String msg = null;

                while ((msg = br.readLine()) != null) {

                    logger.info("服务端接受到的信息为：" + msg);

                    pw.println("响应信息：" + new Date().toString());// 给客户端一个日期字符串

                    if (msg.equals("bye")) {

                        logger.info("客户端请求断开");

                        break;

                    }

                }

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (socket != null)

                    {
                        socket.close();
                    }

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }

    }


    public static void main(String args[]) throws IOException {

        new EchoServer01().service();

    }

}