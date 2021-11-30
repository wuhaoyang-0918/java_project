package com.java.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;

/**
 * @author 昊洋
 * @date:2021-08-17 23:00
 * @PackageName: com.java.MyController
 * @description:
 * @Version 1.0
 */
@Controller
public class DownloadController {
    @RequestMapping("/showDownloadFiles")
    public String showDownloadFiles(Model model, HttpServletRequest request) {
        // 获取下载的文件路径
        String realPath = request.getServletContext().getRealPath("upload");
        // 获得文件对象
        File dir = new File(realPath);
        // 获取文件夹中的所有文件(包含目录)
        File[] files = dir.listFiles();
        // 获取所有文件的文件名
        ArrayList<String> fileNames = new ArrayList<>();
        for (File file : files) {
            if (file.isFile()) { // 排除文件夹
                fileNames.add(file.getName());
            }
        }
        model.addAttribute("fileNames", fileNames);
        return "download";
    }
    /**
     * 执行下载
     *
     * @param filename
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public String downloadFile(@RequestParam String filename, HttpServletRequest request,
                               HttpServletResponse response) {
        // 获取下载的文件路径
        String uploadFilePath = request.getServletContext().getRealPath("upload");
        // 设置下载文件时的响应报头
        response.setHeader("Content-Type", "application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename=" + toUTF8String(filename));

        try {
            // 获取文件输入流
            FileInputStream in = new FileInputStream(new File(uploadFilePath, filename));

            // 获得响应对象的输出流，用于向客户端输出二进制数据
            ServletOutputStream out = response.getOutputStream();
            out.flush();

            int aRead = 0;
            byte[] b = new byte[1024];
            // 写到响应输出流
            while ((aRead = in.read(b)) != -1 && in != null) {
                out.write(b, 0, aRead);
            }
            out.flush();
            // 关闭IO对象
            in.close();
            out.close();

        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 下载时保存中文文件名的字符编码转换方法
     */
    public String toUTF8String(String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            // 取出字符串中的每个字符
            char c = str.charAt(i);
            // Unicode码值为0-255时，不作处理
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                // 转换成utf-8编码
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                    b = null;
                }
                // 转换为%HH的字符串形式
                for (int value : b) {
                    int k = value;
                    if (k < 0) {
                        k &= 255;
                    }
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
    /**
     * 下载文件
     */
    @RequestMapping("/down")
    public void upload(@RequestParam String filename,HttpSession session, HttpServletResponse response) throws Exception {
        //模拟文件下载
        //1.读取需要下载的文件
        InputStream inputStream = session.getServletContext()
                .getResourceAsStream("/upload/"+filename);

        //2.输出文件
        //设置响应头
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        OutputStream outputStream = response.getOutputStream();

        byte[] buf = new byte[1024];
        int len = 0;
        while( (len = inputStream.read(buf))!=-1 ){
            outputStream.write(buf,0,len);
        }

        //3.关闭资源
        outputStream.close();
        inputStream.close();
    }
}
