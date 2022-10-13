package com.is.isgroup.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ads")
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "price")
    private Integer price;
    @Column(name = "photo_name")
    private String photoName;
    @Column(name = "inform")
    private String inform;
    @Column(name = "photo")
    private String photo;

    @Column(name = "publish_name")
    private String publishName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ads)) return false;
        Ads ads = (Ads) o;
        return Objects.equals(getId(), ads.getId()) && Objects.equals(getPrice(), ads.getPrice()) && Objects.equals(getPhotoName(), ads.getPhotoName()) && Objects.equals(getInform(), ads.getInform()) && Objects.equals(getPhoto(), ads.getPhoto()) && Objects.equals(getPublishName(), ads.getPublishName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getPhotoName(), getInform(), getPhoto(), getPublishName());
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", price=" + price +
                ", photoName='" + photoName + '\'' +
                ", inform='" + inform + '\'' +
                ", photo='" + photo + '\'' +
                ", publishName='" + publishName + '\'' +
                '}';
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }



    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }
}
