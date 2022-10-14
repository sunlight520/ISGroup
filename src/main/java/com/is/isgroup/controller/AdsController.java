package com.is.isgroup.controller;

import com.is.isgroup.entity.Ads;
import com.is.isgroup.service.AdsService;
import com.is.isgroup.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ads")
public class AdsController extends BaseController{

    @Autowired
    private AdsService adsService;
    @RequestMapping("insertAds")
    public JsonResult<Ads> insertAds(String inform,Integer price,MultipartFile photo,String publishName)throws IOException{
        File file = new File("");
        String path = file.getCanonicalPath()+"/src/main/resources/static/img/";
//        String path = file.getCanonicalPath()+request.getServletContext().getRealPath("/upload/");
        String fileName = photo.getOriginalFilename();
        String allStr = path + fileName;
        System.out.println(allStr);
        saveFile(photo,path);
        Ads ads = adsService.insertAds(inform,price,path+fileName,fileName,publishName);
        return new JsonResult<Ads>(OK,ads);
    }
    public void saveFile(MultipartFile photo,String path)throws  IOException{
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
    }

    //测试接口
    @RequestMapping("getAdsById")
    public JsonResult<Ads> getAdsById(Integer id){
        Ads ads = adsService.getAdsById(id);
        System.out.println(ads);
        return new JsonResult<Ads>(OK,ads);
    }
    @RequestMapping("getAdsByPageNumber")
    public JsonResult<List<Ads>> getAdsByPageNumber(Integer id){
        int beginId = 2*id;
        List<Ads> adsList = new ArrayList<>();
        for (int i=0;i<3;i++){
            adsList.add(adsService.getAdsById(beginId+i));
        }
        return new JsonResult<List<Ads>>(OK,adsList);
    }
    @RequestMapping("getAllAds")
    public JsonResult<List<Ads>> getAllAds(){
        List<Ads> AllAds = adsService.getAllAds();
        return new JsonResult<List<Ads>>(OK,AllAds);
    }
    @RequestMapping("deleteAdsById")
    public JsonResult<Ads> deleteAdsById(Integer id){
        adsService.deleteAdsById(id);
        return new JsonResult<>(OK);
    }
    @RequestMapping("updateById")
    public JsonResult<Ads> updateById(Ads ads){
        adsService.updateById(ads);
        return new JsonResult<Ads>(OK,ads);
    }


}
