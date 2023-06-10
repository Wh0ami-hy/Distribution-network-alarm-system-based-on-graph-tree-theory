package com.hy.controller;

import com.hy.util.Result;
import com.hy.util.UserCache;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/upload")
public class UploadController {
    @PostMapping("/picture")
    public Result picture(MultipartFile photo) throws IOException {
        //获取文件名
        System.out.println(photo.getOriginalFilename());
        //取文件类型
        System.out.println(photo.getContentType());

        //获取当前工程路径
        String path = "F:\\JavaWork\\AlarmSystemByTree\\src\\main\\resources\\static\\images\\";
        saveFile(photo,path);
        return Result.ok();
    }
    //保存上传文件至服务器
    public void saveFile(MultipartFile photo, String path) throws IOException {
        File files = new File(path);
        if (files.exists()){
            System.out.println("文件夹已创建");
        }else {
            files.mkdirs();
            System.out.println("文件夹创建成功");
        }
        // 从缓存中获取当前登录到系统中的用户名
        String username = UserCache.get("username");
        File file = new File(path + username + ".jpg");
        if (file.exists()){
            file.delete();
        }
        photo.transferTo(file);
        System.out.println(file);
    }
}
