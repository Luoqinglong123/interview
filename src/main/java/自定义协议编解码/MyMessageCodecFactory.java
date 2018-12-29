package 自定义协议编解码;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageEncoder;


/**
 * 编解码器工厂：
 */
public class MyMessageCodecFactory extends DemuxingProtocolCodecFactory {

    private MessageDecoder decoder;

 

    private MessageEncoder<AbstrMessage> encoder;

    // 注册编解码器

    public MyMessageCodecFactory(MessageDecoder decoder,

            MessageEncoder<AbstrMessage> encoder) {

        this.decoder = decoder;

        this.encoder = encoder;

        addMessageDecoder(this.decoder);

        addMessageEncoder(AbstrMessage.class, this.encoder);

    }

}