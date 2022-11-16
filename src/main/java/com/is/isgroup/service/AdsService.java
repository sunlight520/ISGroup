package com.is.isgroup.service;

import com.is.isgroup.entity.Ads;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdsService {
        Ads insertAds(String inform, Integer price, String photo,String photoName,String publishName);
        Ads getAdsById(Integer id);
        void deleteAdsById(Integer id);
        Ads updateById(Integer id,String inform, Integer price, String photo,String photoName);
        void uploadPhoto(Integer id,String photo);
        List<Ads> getAllAds();
        List<Ads> findAdsByPageNumber(Integer number);
        Ads updateInformById(Integer id,String inform);


}
