package demo1;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

public class Demo1ServerHandler extends IoHandlerAdapter {

    public static Logger logger = Logger.getLogger(Demo1ServerHandler.class);

 

    @Override

    public void sessionCreated(IoSession session) throws Exception {

        logger.info("服务端与客户端创建连接...");

    }

 

    @Override

    public void sessionOpened(IoSession session) throws Exception {

        logger.info("服务端与客户端连接打开...");

    }

 

    @Override

    public void messageReceived(IoSession session, Object message)

            throws Exception {

        String msg = message.toString();

        logger.info("服务端接收到的数据为：" + msg);

        if ("bye".equals(msg)) { // 服务端断开连接的条件

            session.close();

        }

        Date date = new Date();

        session.write(date);

    }

    @Override

    public void messageSent(IoSession session, Object message) throws Exception {

        logger.info("服务端发送信息成功...");
        //这样就是一个短连接的服务
        //session.close(); //发送成功后主动断开与客户端的连接

    }

    @Override

    public void sessionClosed(IoSession session) throws Exception {

 

    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)

            throws Exception {

        logger.info("服务端进入空闲状态...");

    }

    @Override

    public void exceptionCaught(IoSession session, Throwable cause)

            throws Exception {

        logger.error("服务端发送异常...", cause);

    }

}