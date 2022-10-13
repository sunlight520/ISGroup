package com.is.isgroup.service;

import com.is.isgroup.entity.Ads;
import org.springframework.stereotype.Service;

@Service
public interface AdsService {
        void insertAds(Ads ads);
        Ads getAdsById(Integer id);
        void deleteAdsById(Integer id);
        void updateById(Ads ads);

}
