package com.is.isgroup.service;

import com.is.isgroup.entity.Ads;
import org.springframework.stereotype.Service;

@Service
public interface AdsService {
        Ads insertAds(String inform, Integer price, String photo,String photoName,String publishName);
        Ads getAdsById(Integer id);
        void deleteAdsById(Integer id);
        void updateById(Ads ads);
        void uploadPhoto(Integer id,String photo);

}
