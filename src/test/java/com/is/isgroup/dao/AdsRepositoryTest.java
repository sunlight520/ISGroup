package com.is.isgroup.dao;

import com.is.isgroup.entity.Ads;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdsRepositoryTest {
    @Autowired
    AdsRepository adsRepository;
    @Test
    public void addAdsTest(){
        Ads ads = new Ads();
        ads.setPrice(100);
        ads.setInform("第一个广告");
        ads.setPhoto("asd/asd.png");
        ads.setPhotoName("asd");
        ads.setPublishName("w");
        adsRepository.save(ads);
    }

    @Test
    public void getAll(){
        List<Ads> list = adsRepository.findAll();
        System.out.println(list);
    }
//    @Test
//    public void updateAdsTest(){
//        Ads ads = new Ads();
//        ads.setPhoto("asd");
//        ads.setPrice(123);
//        ads.setInform("12ewdsa");
//        System.out.println();
//    }
//
//    @Test
//    public void deleteAdsTest(){
////        adsRepository.deleteById(15);
//    }
    @Test
    public void queryAdsTest(){
//        System.out.println(adsRepository.queryAdsById(69));
    }
    @Test
    public void updateAdsByIdTest(){
        Ads ads = new Ads();
        ads.setInform("更改内容");
        ads.setPhoto("这是一个照片");
        ads.setPrice(9999);
        ads.setId(113);
        ads.setPublishName("名字");
        adsRepository.updateById(ads);
    }
    @Test
    public void updatePhotoTest(){
        String smm = "更改";
        adsRepository.updatePhotoById(87,smm);
    }
    @Test
    public void findAdsByPageNumber(){
        List<Ads> adsList = adsRepository.findAdsByPageNumber(3);
        System.out.println(adsList);
    }
}
