package 自定义编码解码器改进;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;


public class MyTextLineCodecFactoryII implements ProtocolCodecFactory {

    private Charset charset; // 编码格式


    private String delimiter; // 文本分隔符


    public MyTextLineCodecFactoryII(Charset charset, String delimiter) {

        this.charset = charset;

        this.delimiter = delimiter;

    }


    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {

        return new MyTextLineCodecDecoderII(charset, delimiter);

    }


    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {

        return new MyTextLineCodecEncoderII(charset, delimiter);

    }

}