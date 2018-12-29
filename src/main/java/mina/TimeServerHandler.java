package mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

/**
 * @author qinglong.luo
 * @version V1.0.0
 * @time 2018/10/17 12:12
 * @description
 *
 *
 */
public class TimeServerHandler extends IoHandlerAdapter {
    /**
     * exceptionCaught 应该总是在处理器中进行定义，以处理正常的远程连接过程时抛出的异常。如果这一方法没有定义，可能无法正常报告异常。
     * exceptionCaught 方法将会对错误和 session 关闭的 stack trace 进行简单打印。对于更多的程序，这将是常规，除非处理器能够从异常情况下进行恢复。
     * @param session
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause ) throws Exception
    {
        cause.printStackTrace();
    }

    /**
     * messageReceived 方法会从客户端接收数据并将当前时间回写给客户端。如果接收自客户端的消息是单词 "quit"，
     * 那么当前 session 将被关闭。这一方法也会向客户端打印输出当前时间。取决于你所使用的协议编解码器，
     * 传递到这一方法的对象 (第二个参数) 会有所不同，就和你传给 session.write(Object) 方法的对象一样。如果你不定义一个协议编码器，
     * 你很可能会接收到一个 IoBuffer 对象，而且被要求写出一个 IoBuffer 对象。
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception
    {
        String str = message.toString();
        System.out.println("receive  "+str);
        if( str.trim().equalsIgnoreCase("quit") ) {
            session.close();
            return;
        }
        Date date = new Date();
        session.write( date.toString() );
        System.out.println("Message written...");
    }

    /**
     *   一旦 session 保持空闲状态到达 acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );
     *   所定义的时间长度，sessionIdle 方法会被调用。
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception
    {
        System.out.println( "IDLE " + session.getIdleCount( status ));
    }

}
