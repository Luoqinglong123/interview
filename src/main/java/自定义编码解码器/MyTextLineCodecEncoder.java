package 自定义编码解码器;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class MyTextLineCodecEncoder implements ProtocolEncoder {

    private Charset charset = Charset.forName("UTF-8");

    /**
     * 把要编码的数据放进一个IoBuffer中，并在IoBuffer结尾添加\r\n,输出。
     * @param session
     * @param message
     * @param out
     * @throws Exception
     */
    @Override
    public void encode(IoSession session, Object message,

                       ProtocolEncoderOutput out) throws Exception {

        IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);

        CharsetEncoder ce = charset.newEncoder();

        buf.putString(message.toString(),ce);

        //buf.put(message.toString().getBytes(charset));

        buf.put((byte) '\r');

        buf.put((byte) '\n');

        buf.flip();

        out.write(buf);

    }


    @Override
    public void dispose(IoSession session) throws Exception {

 

    }

}