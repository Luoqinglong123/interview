package 序列化;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件复制
 */
public class FileCopyDemo {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("D:" + File.separator + "aa.txt");
        FileOutputStream out = new FileOutputStream("D:" + File.separator + "aa23.txt");
        fileCopy(inputStream, out);
    }

    private static void fileCopy(FileInputStream inputStream, FileOutputStream out) throws IOException {
        try {
        byte[] bytes = new byte[1024];
        int length = 0 ;
        while ((length=inputStream.read(bytes))!=-1){
            out.write(bytes,0,length);
            }
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        finally {
            out.close();
            inputStream.close();
        }
    }

    private static void fileCopyNIO(FileInputStream inputStream, FileOutputStream out) throws IOException {
        try {
            FileChannel inChannel = inputStream.getChannel();
            FileChannel outChannel = out.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            while(inChannel.read(allocate)!=-1){
                allocate.flip();
                outChannel.write(allocate);
                allocate.clear();
            }
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        finally {
            out.close();
            inputStream.close();
        }
    }
}
