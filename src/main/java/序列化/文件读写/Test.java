package 序列化.文件读写;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
      /**
     * 统计给定文件中给定字符串的出现次数
     *
     * @param filename  文件名
     * @param word 字符串
     * @return 字符串在文件中出现的次数
     */
public class Test {
    public static int countWordInFile(String filename, String word) {
        int cout = 0 ;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine())!=null){
                int index = -1;
                while(line.length()>=word.length()&&(index = line.indexOf(word))>=0){
                    cout++;
                    line = line.substring(index+word.length());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cout;
    }
}
