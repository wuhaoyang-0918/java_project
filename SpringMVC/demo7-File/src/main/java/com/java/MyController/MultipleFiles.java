package com.java.MyController;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-17 19:08
 * @PackageName: com.java.MyController
 * @description:
 * @Version 1.0
 */
@Data
public class MultipleFiles {
    private List<String> description;
    private List<MultipartFile> multipartFile;
}
