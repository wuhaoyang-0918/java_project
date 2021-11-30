package com.why.file;

import java.io.*;

/**
 * @author why
 * @date 2021/9/12 20:24
 * @PackageName com.why.file
 * @description
 */
public class Ma4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\filedemo\\bb.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\filedemo\\aa\\aa.txt"));
        String line;
// 循环取数据
        while ((line = br.readLine()) != null) {
            // 将读取的内容转换成字符串
            bw.write(line);
            bw.newLine();
            bw.flush();

        }
// 关闭流
        bw.close();
        br.close();





    }
}
