package com.why.file;

import java.io.*;

/**
 * @author why
 * @date 2021/9/10 13:52
 * @PackageName com.why.file
 * @description
 */
public class Ma1 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("E:\\filedemo\\bb.txt");
// 1.2 指定目的地
        FileOutputStream fos = new FileOutputStream("E:\\filedemo\\aa\\aa.txt");
// 2.读写数据
// 2.1 定义数组
        byte[] b = new byte[1024];
// 2.2 定义长度
        int len;
// 2.3 循环读取
        while ((len = fis.read(b))!=-1) {
// 2.4 写出数据
            fos.write(b, 0 , len);
        }
// 3.关闭资源
        fos.close();
        fis.close();


    }
}
