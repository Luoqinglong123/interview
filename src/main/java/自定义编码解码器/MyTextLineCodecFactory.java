package 自定义编码解码器;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class MyTextLineCodecFactory implements ProtocolCodecFactory {

 
    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {

        return new MyTextLineCodecDecoder();

    }


    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {

        return new MyTextLineCodecEncoder();

    }

}