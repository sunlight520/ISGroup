package com.is.isgroup.controller;

import com.is.isgroup.entity.Ads;
import com.is.isgroup.service.AdsService;
import com.is.isgroup.util.JsonResult;
import com.is.isgroup.util.Result;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/ads")
public class AdsController {
    public static final int OK = 200;
    @Autowired
    private AdsService adsService;
    @RequestMapping("insertAds")
    public JsonResult<Ads> insertAds(Ads ads){
        adsService.insertAds(ads);
        return new JsonResult<>(OK,ads);
    }
    @RequestMapping("getAdsById")
    public JsonResult<Ads> getAdsById(Integer id){
        Ads ads = adsService.getAdsById(id);
        return new JsonResult<>(OK,ads);
    }
    @RequestMapping("deleteAdsById")
    public JsonResult<Ads> deleteAdsById(Integer id){
        adsService.deleteAdsById(id);
        return new JsonResult<>(OK);
    }

    @RequestMapping("updateById")
    public JsonResult<Ads> updateById(Ads ads){
        adsService.updateById(ads);
        return new JsonResult<>(OK,ads);
    }
    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request)throws IOException{
        File file = new File("");
        String path = file.getCanonicalPath()+"/src/main/resources/static/img/";
        System.out.println(path);
        saveFile(photo,path);
        return "上传成功";
    }
    public void saveFile(MultipartFile photo,String path)throws  IOException{
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
    }

}
