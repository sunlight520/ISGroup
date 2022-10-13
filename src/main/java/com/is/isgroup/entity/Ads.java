package com.is.isgroup.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ads")
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "price")
    Integer price;

    @Column(name = "inform")
    String inform;
    @Column(name = "photo")
    String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ads)) return false;
        Ads ads = (Ads) o;
        return Objects.equals(getId(), ads.getId()) && Objects.equals(getPrice(), ads.getPrice()) && Objects.equals(getInform(), ads.getInform()) && Objects.equals(getPhoto(), ads.getPhoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getInform(), getPhoto());
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", price=" + price +
                ", inform='" + inform + '\'' +
                ", photo='" + photo + '\'' +
                '}';
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
