package com.spring.mvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传控制器
 */
@Controller
public class UploadController{
    /**
     * 上传文件页面
     */
    @RequestMapping("/uploadPage")
    public String uploadPage(){
        return "upload";
    }

    /**
     * 上传文件
     * @param file 入参,注意名称,这里只能用file名称接收否则会拿不到实体对象
     * 问题:1.上传之后文件名称乱码
     *      2.返回页面中文乱码
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(MultipartFile file){
        String filePath = "H:/";
        try{
            FileUtils.writeByteArrayToFile(new File(filePath + file.getOriginalFilename()), file.getBytes());
            return "上传成功";
        }catch(Exception e){
            e.printStackTrace();
            return "上传失败";
        }
    }
}
