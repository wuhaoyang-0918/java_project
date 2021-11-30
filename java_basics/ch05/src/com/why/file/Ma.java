package com.why.file;

import java.io.File;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @author why
 * @date 2021/9/10 11:20
 * @PackageName com.why.file
 * @description
 */
public class Ma {
    public static void main(String[] args) throws IOException {

        File file = new File("E:\\filedemo\\aa.txt");
        File file1 = new File("E:\\filedemo\\aa");
       // System.out.println(file.createNewFile());
//        System.out.println(file1.mkdirs());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.isFile());
//        System.out.println(file1.isDirectory());
//        System.out.println(file.exists());
//        System.out.println(file1.getName());
//        System.out.println(file.getPath());
       /* File f2 = new File("ch05\\aa.txt");
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getPath());*/
       /* File f2 = new File("ch05\\aa.txt");
        f2.delete();*/
        //System.out.println(f2.createNewFile());
        File f1 = new File("E:\\filedemo");
        sho(f1);

    }
    public static  void  sho( File file){
        File[] files = file.listFiles();
        if (files != null) {
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    //是目录递归调用
                    sho(file2);
                }else {
                    System.out.println(file2.getAbsolutePath());
                }
            }
        }
    }
}
