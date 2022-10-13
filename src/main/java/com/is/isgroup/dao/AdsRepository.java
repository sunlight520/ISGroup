package com.is.isgroup.dao;

import com.is.isgroup.entity.Ads;
import org.hibernate.annotations.SQLUpdate;
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

    @Override
    List<Ads> findAll();

    @Modifying
    @Transactional
    @Query(value = "UPDATE t_ads  SET photo=:#{#photo} where id=:#{#aid}",nativeQuery = true)
    Integer updatePhotoById(@Param("aid") Integer id,String photo);
}
