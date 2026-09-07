package com.lan.controller;

import com.lan.pojo.Result;
import com.lan.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    /**
     * 本地磁盘上传文件
     * @param name
     * @param age
     * @param file
     * @return
     * @throws IOException
     */
    // @PostMapping("/upload")
    // public Result upload(String name, String age, MultipartFile file) throws IOException {
    //     log.info("上传文件: {}, {}, {}", name, age, file);
    //
    //     // 获取原始文件名
    //     String originalFilename = file.getOriginalFilename();
    //     // 新的文件名
    //     String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
    //     String newFileName = UUID.randomUUID().toString() + extension;
    //     file.transferTo(new File("D:/images/" + newFileName));
    //     return Result.success();
    // }

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件: {}", file.getOriginalFilename());
        // 上传文件到OSS
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());

        log.info("上传文件到OSS成功: {}", url);
        return Result.success(url);
    }

}
