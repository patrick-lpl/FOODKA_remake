package com.swu.foodka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author liuxiaolin
 */
@Controller
@CrossOrigin
public class PhotoController {

    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoSavePath; // 图标物理存储路径

    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath; //图标映射路径

    @PostMapping("/api/profilePhotoUpload")
    public String profilePhotoUpload(@RequestParam("files")MultipartFile fileUpload, Model model){
        // 获取文件名
        String fileName = fileUpload.getOriginalFilename();
        // 获取文件后缀名，也可以在这里添加判断语句，规定特定格式到图片才能上传，否则拒绝保存
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 为了避免文件发生图片替换，这里用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;
        try {
            // 将图片保存到文件夹里
            fileUpload.transferTo(new File(ProfilePhotoSavePath+fileName));
            model.addAttribute("thps",(ProfilePhotoMapperPath+fileName));
            return "/photoReturn";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/error";
    }
}
