package com.is.isgroup.service;

import com.is.isgroup.entity.Ads;
import com.is.isgroup.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdsServiceTest {
    @Autowired
    AdsService adsService;
    @Test
    public void saveTest(){
        Ads ads = new Ads();
        ads.setPrice(888);
        ads.setInform("啦啦");
        ads.setPhoto("photo.png");
    }
    @Test
    public void getAdsByIdTest(){
        Ads ads = adsService.getAdsById(67);
        System.out.println(ads);
    }
    @Test
    public void getAllAds(){
        List<Ads> adsList = adsService.getAllAds();
        System.out.println(adsList);
    }
    @Test
    public void deleteAdsByIdTest(){
        adsService.deleteAdsById(66);

    }
    @Test
    public void uploadPhotoTest(){
        adsService.uploadPhoto(76,"hhhh");
    }
    @Test
    public void findAdsByPageNumber(){
        List<Ads> adsList = adsService.findAdsByPageNumber(5);
        System.out.println(adsList);
    }
}
