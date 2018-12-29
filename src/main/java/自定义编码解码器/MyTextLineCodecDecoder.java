package 自定义编码解码器;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;


public class MyTextLineCodecDecoder implements ProtocolDecoder {

    private Charset charset = Charset.forName("UTF-8");


    IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);

    /**
     * decode方法的参数IoBuffer是建立连接后接收数据的字节数组；我们不断的从它里面读数据，
     * 直到遇上\r\n就停止读取数据，把上面累加的所有数据转换为一个字符串，输出！
     * @param session
     * @param in
     * @param out
     * @throws Exception
     */
    @Override
    public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)

            throws Exception {

        while (in.hasRemaining()) {

            byte b = in.get();

            buf.put(b);

            if (b == '\n') {

                buf.flip();

                byte[] msg = new byte[buf.limit()];

                buf.get(msg);

                String message = new String(msg, charset);

                //解码成功，把buf重置

                buf = IoBuffer.allocate(100).setAutoExpand(true);

                out.write(message);

            }

        }


    }


    @Override
    public void dispose(IoSession session) throws Exception {

    }


    @Override
    public void finishDecode(IoSession session, ProtocolDecoderOutput out)

            throws Exception {

    }

}