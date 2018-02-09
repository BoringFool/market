package com.zm.test;
import java.io.*;
public class Iotest{
    public static void main(String[] args)throws Exception{
        File file = new File("C:\\333\\1.jpg");
        if(!file.exists())
            throw new RuntimeException("文件不存在..");
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = 0;
        //存储路径需要精确到3.jpg，这个相当与是重命名了1.jpg并复制
        FileOutputStream fos = new FileOutputStream("C:\\333\\3.jpg");
        while((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        fos.close();
        fis.close();
    }
}