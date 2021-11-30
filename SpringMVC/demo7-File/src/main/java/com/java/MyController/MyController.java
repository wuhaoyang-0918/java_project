package com.java.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author 昊洋
 * @date:2021-08-17 17:19
 * @PackageName: com.java.MyController
 * @description:
 * @Version 1.0
 */
@Controller
@RequestMapping("/upload")
public class MyController {
    /**
     * 单文件上传
     */
    @PostMapping("/singleFile")
    public  String uploadFile(SingleFile singleFile, HttpServletRequest request){
       //判断文件是否为空
        if(!singleFile.getMultipartFile().isEmpty()) {
            // 获取文件上传到具体文件夹的绝对路径(下面两个一样,'/'加不加都可以)
            String upload = request.getSession().getServletContext().getRealPath("/upload");
            String realpath = request.getServletContext().getRealPath("upload");

            String oldName = singleFile.getMultipartFile().getOriginalFilename();//获取文件名(xxx.jpg)
            String suffix = oldName.substring(oldName.lastIndexOf("."));     //2.3 获取文件后缀

            String fileName = UUID.randomUUID().toString().replaceAll("-","") + suffix;
            // 根据路径构建文件对象
            File uploadFile = new File(upload, fileName);//realpath+fileName

            //判断路径是否存在，如果不存在就创建一个
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }
            try {
                singleFile.getMultipartFile().transferTo(uploadFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  "success";
        }else {
            return  "error";
        }

    }
    /**
     * 多文件上传
     */
    @PostMapping("/singleFiles")
    public  String uploadFiles(MultipleFiles multipleFiles, HttpServletRequest request){

        String realPath = request.getServletContext().getRealPath("upload");
        // 构建文件对象
        File uploadDir = new File(realPath);
        // 判断文件夹是否存在，不存在则创建
        if (!uploadDir.exists()) {
            System.out.println("111111");
            uploadDir.mkdir();
        }
        // 获取上传文件列表
        List<MultipartFile> multipartFile = multipleFiles.getMultipartFile();
        // 上传文件
        for (MultipartFile myFile : multipartFile) {
            File targetFile = new File(realPath, myFile.getOriginalFilename());
            try {
                myFile.transferTo(targetFile);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "success";

    }
}
