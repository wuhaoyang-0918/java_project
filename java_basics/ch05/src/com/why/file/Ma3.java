package com.why.file;

import java.io.*;

/**
 * @author why
 * @date 2021/9/10 17:10
 * @PackageName com.why.file
 * @description
 */
public class Ma3 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\filedemo\\bb.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\filedemo\\aa\\aa.txt"));
// 2.读写数据
// 2.1 定义数组
        byte[] b = new byte[1024];
// 2.2 定义长度
        int len;
// 2.3 循环读取
        while ((len = bis.read(b))!=-1) {
// 2.4 写出数据
            bos.write(b, 0 , len);
        }
// 3.关闭资源
        bos.close();
        bis.close();

        long end = System.currentTimeMillis();
        System.out.println("缓冲流使用数组复制时间:"+(end-start)+" 毫秒");
    }
}
