package demo04;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;


public class DemoServerHandler extends IoHandlerAdapter {

    public static Logger logger = Logger.getLogger(DemoServerHandler.class);

 

    @Override
    public void messageReceived(IoSession session, Object message)

            throws Exception {

        PhoneMessageDto phoneMes =(PhoneMessageDto) message;

        String sendPhone = phoneMes.getSendPhone();

        String receivePhone = phoneMes.getReceivePhone();

        String mes = phoneMes.getMessage();

        logger.info("发送人手机号码：" + sendPhone);

        logger.info("接受人手机号码：" + receivePhone);

        logger.info("发送信息：" + mes);

 

        // 短信信息存入移动服务端数据库

        // ............


        PhoneMessageDto phoneMes2 = new PhoneMessageDto();
        phoneMes2.setMessage("收到了");
        phoneMes2.setReceivePhone("142545651");
        phoneMes2.setSendPhone("4565");
        session.write(phoneMes2);

    }

 

    @Override

    public void messageSent(IoSession session, Object message) throws Exception {

        //session.close();

    }

    @Override

    public void exceptionCaught(IoSession session, Throwable cause)

            throws Exception {

        logger.error("服务端发送异常...", cause);

    }

}