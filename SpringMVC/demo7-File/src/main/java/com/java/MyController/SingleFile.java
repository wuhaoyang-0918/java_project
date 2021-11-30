package com.java.MyController;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 昊洋
 * @date:2021-08-17 17:39
 * @PackageName: com.java.MyController
 * @description:
 * @Version 1.0
 */
@Data
public class SingleFile {
    private String description;
    private MultipartFile multipartFile;
}
