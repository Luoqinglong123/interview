package 自定义协议编解码;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;

/*

 * 请求的Java对象

    请求部分是客户端（机顶盒）向服务端发送的请求；协议I的请求只发送了两个个参数：channelID和channel_dec（频道描述信息）

各个参数分析：

a.  descriptortag:请求的唯一标识；         -- 2个字节

b.  descriptorlength:数据区长度；          -- 4个字节

c.  ID：channelID;                          -- 2个字节

d.  channel_dec_len:频道说明信息的字节长度  -- 1个字节

e.  for循环：存放频道说明信息的真实数据（字节数组中）
 */

public class ChannelInfoRequest extends AbstrMessage {

    private Logger logger = Logger.getLogger(ChannelInfoRequest.class);

 

    private String channel_desc;

 

    private int channel_id;

 

    @Override

    public short getTag() {

        return (short) 0x0001;

    }

 

    @Override

    public int getLen(Charset charset) {

        int len = 2 + 1;

        try {

            if (channel_desc != null && !"".equals(channel_desc)) {

                len+= channel_desc.getBytes(charset).length;

            }

        }catch (Exception e) {

            logger.error("频道说明转换为字节码错误...", e);

        }

        return len;

    }

 

    @Override

    public int getDataOffset() {

        int len = 2 + 4 + 2 + 1;

        return len;

    }

 

    public String getChannel_desc() {

        return channel_desc;

    }

 

    public void setChannel_desc(String channel_desc) {

        this.channel_desc = channel_desc;

    }

 

    public int getChannel_id() {

        return channel_id;

    }

 

    public void setChannel_id(int channel_id) {

        this.channel_id = channel_id;

    }

}