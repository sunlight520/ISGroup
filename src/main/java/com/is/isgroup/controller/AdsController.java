package com.is.isgroup.controller;

import com.is.isgroup.entity.Ads;
import com.is.isgroup.entity.ListAndNumber;
import com.is.isgroup.service.AdsService;
import com.is.isgroup.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/ads")
@CrossOrigin
public class AdsController extends BaseController{
    @Autowired
    private AdsService adsService;
//    插入单条广告的接口
    @PostMapping()
    public JsonResult<Ads> insertAds(String inform,Integer price,MultipartFile photo,HttpSession session)throws IOException{
        String name = getUsernameFromSession(session);
        System.out.println(name);
        File file = new File("");
        String path = file.getCanonicalPath()+"/src/main/resources/static/img/";
//        String path = file.getCanonicalPath()+request.getServletContext().getRealPath("/upload/");
        String fileName = photo.getOriginalFilename();
        String allStr = path + fileName;
        System.out.println(allStr);
        saveFile(photo,path);
//        String publishName = "user";
        Ads ads = adsService.insertAds(inform,price,path+fileName,fileName, name);
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
    @GetMapping("getAdsByPageNumber")
    public JsonResult<ListAndNumber> getAdsByPageNumber(Integer id){
        List<Ads> adsList = adsService.findAdsByPageNumber(id);
        List<Ads> AllAds = adsService.getAllAds();
        Integer allAdsNumber = AllAds.size();
        ListAndNumber listAndNumber = new ListAndNumber();
        listAndNumber.setAdsList(adsList);
        listAndNumber.setAllAdsNumber(allAdsNumber);
        return new JsonResult<>(OK,listAndNumber);
    }
    @GetMapping("getAdsByUsername")
    public JsonResult<ListAndNumber> getAdsByUsername(Integer id,ServletRequest servletRequest, ServletResponse servletResponse, HttpSession session){
        String username = getUsernameFromSession(session);
        List<Ads> adsList = adsService.findAdsByUsername(username);
        int usernameListNumber  = adsList.size();
        List<Ads> newAdsList = new ArrayList<>();
        int all = (int) Math.floor((usernameListNumber-1)/3+1);
        if (id<all){
            newAdsList = adsList.subList(id*3-3,id*3);
        }
        if (id==all){
            newAdsList = adsList.subList(id*3-3,usernameListNumber);
        }
        ListAndNumber listAndNumber = new ListAndNumber();
        listAndNumber.setAdsList(newAdsList);
        listAndNumber.setAllAdsNumber(usernameListNumber);
        return new JsonResult<>(OK,listAndNumber);
    }
//    获取所有广告的接口
    @GetMapping()
    public JsonResult<List<Ads>> getAllAds(){
        List<Ads> AllAds = adsService.getAllAds();
        return new JsonResult<List<Ads>>(OK,AllAds);
    }
//    删除广告的接口
    @DeleteMapping()
    public JsonResult<Ads> deleteAdsById(@RequestParam("id") Integer id){
        adsService.deleteAdsById(id);
        return new JsonResult<>(OK);
    }
//    更新广告的接口
    @PutMapping()
    public JsonResult<Ads> updateById(Integer id,String inform,Integer price,MultipartFile photo,HttpSession session) throws IOException {
        File file = new File("");
        String path = file.getCanonicalPath()+"/src/main/resources/static/img/";
        String fileName = photo.getOriginalFilename();
        String allStr = path + fileName;
        saveFile(photo,path);
        Ads ads1 = adsService.getAdsById(id);
        ads1.setId(id);
        if (Objects.equals(inform, "HELLO")){
            inform = ads1.getInform();
        }
        String prNum = price.toString();
        if (prNum.equals("-1")){
            price = ads1.getPrice();
        }
        if (photo.isEmpty()){
            fileName = ads1.getPhotoName();
        }
        adsService.updateById(id,inform,price,path+fileName,fileName);
        return new JsonResult<Ads>(OK,ads1);
    }
}