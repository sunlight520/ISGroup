package com.is.isgroup.controller;

import com.is.isgroup.entity.Ads;
import com.is.isgroup.entity.ListAndNumber;
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
//    插入单条广告的接口
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
//    通过Id寻找广告的接口
    @RequestMapping("getAdsById")
    public JsonResult<Ads> getAdsById(Integer id){
        Ads ads = adsService.getAdsById(id);
        System.out.println(ads);
        return new JsonResult<Ads>(OK,ads);
    }
//    获取分页广告的接口
    @RequestMapping("getAdsByPageNumber")
    public JsonResult<ListAndNumber> getAdsByPageNumber(Integer number){
        List<Ads> adsList = adsService.findAdsByPageNumber(number);
        List<Ads> AllAds = adsService.getAllAds();
        Integer allAdsNumber = AllAds.size();
        ListAndNumber listAndNumber = new ListAndNumber();
        listAndNumber.setAdsList(adsList);
        listAndNumber.setAllAdsNumber(allAdsNumber);
        return new JsonResult<>(OK,listAndNumber);
    }
//    获取所有广告的接口
    @RequestMapping("getAllAds")
    public JsonResult<List<Ads>> getAllAds(){
        List<Ads> AllAds = adsService.getAllAds();

        return new JsonResult<List<Ads>>(OK,AllAds);
    }
//    删除广告的接口
    @RequestMapping("deleteAdsById")
    public JsonResult<Ads> deleteAdsById(Integer id){
        adsService.deleteAdsById(id);
        return new JsonResult<>(OK);
    }
//    更新广告的接口
    @RequestMapping("updateById")
    public JsonResult<Ads> updateById(Integer id,String inform, Integer price,String publishName,MultipartFile photo) throws IOException {
        File file = new File("");
        String path = file.getCanonicalPath()+"/src/main/resources/static/img/";
//        String path = file.getCanonicalPath()+request.getServletContext().getRealPath("/upload/");
        String fileName = photo.getOriginalFilename();
        String allStr = path + fileName;
        System.out.println(allStr);
        saveFile(photo,path);
        Ads ads1 = adsService.getAdsById(id);
        ads1.setPhoto(path+fileName);
        ads1.setPhotoName(fileName);
        ads1.setId(id);
        adsService.updateById(id,inform,price,path+fileName,fileName,publishName);
//        Ads ads =   adsService.insertAds(inform,price,path+fileName,fileName,publishName);
        return new JsonResult<Ads>(OK,ads1);
    }


}
