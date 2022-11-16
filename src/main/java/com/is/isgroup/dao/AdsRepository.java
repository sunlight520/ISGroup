package com.is.isgroup.dao;

import com.is.isgroup.entity.Ads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "adsRepository")
public interface AdsRepository extends JpaRepository<Ads,Integer> {
    Ads getAdsById(Integer id);
    void deleteById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE t_ads  SET inform =:#{#ads.inform},photo_name=:#{#ads.photoName},photo=:#{#ads.photo} ,price =:#{#ads.price},publish_name =:#{#ads.publishName} where id=:#{#ads.id}",nativeQuery = true)
    void updateById( @Param("ads") Ads ads);
    @Modifying
    @Transactional
    @Query(value = "UPDATE t_ads  SET inform =:#{#ads.inform} where id=:#{#ads.id}",nativeQuery = true)
    void updateInformById( @Param("ads") Ads ads);
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM t_ads LIMIT 3 offset (:number-1)*3 ",nativeQuery = true)
    List<Ads> findAdsByPageNumber(@Param("number") Integer number);
    @Override
    List<Ads> findAll();
    @Modifying
    @Transactional
    @Query(value = "UPDATE t_ads  SET photo=:#{#photo} where id=:#{#aid}",nativeQuery = true)
    Ads updatePhotoById(@Param("aid") Integer id,String photo);
}
