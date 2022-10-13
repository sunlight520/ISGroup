package com.is.isgroup.service.impl;

import com.is.isgroup.dao.AdsRepository;
import com.is.isgroup.entity.Ads;
import com.is.isgroup.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdsServiceImpl implements AdsService {
    @Autowired
    AdsRepository adsRepository;



    @Override
    public Ads insertAds(String inform, Integer price, String photo,String photoName) {
        Ads ads = new Ads();
        ads.setInform(inform);
        ads.setPrice(price);
        ads.setPhoto(photo);
        ads.setPhotoName(photoName);
        adsRepository.save(ads);
        return ads;
    }

    @Override
    public Ads getAdsById(Integer id) {
        return adsRepository.getAdsById(id);

    }

    @Override
    public void deleteAdsById(Integer id) {
        adsRepository.deleteById(id);
    }

    @Override
    public void updateById(Ads ads) {
        adsRepository.updateById(ads);
    }

    @Override
    public void uploadPhoto(Integer id, String photo) {
//        Ads ads = adsRepository.getAdsById(id);
       System.out.println(adsRepository.updatePhotoById(id,photo));
    }

//    @Override
//    public void updateAdsById(Integer id,Ads ads) {
//        ads.setId(id);
//        adsRepository.save(ads);
//    }
}
