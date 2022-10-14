package com.is.isgroup.entity;

import java.util.List;
import java.util.Objects;

public class ListAndNumber {
    private List<Ads> adsList;
    private Integer allAdsNumber;

    @Override
    public String toString() {
        return "ListAndNumber{" +
                "adsList=" + adsList +
                ", allAdsNumber=" + allAdsNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListAndNumber)) return false;
        ListAndNumber that = (ListAndNumber) o;
        return Objects.equals(getAdsList(), that.getAdsList()) && Objects.equals(getAllAdsNumber(), that.getAllAdsNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdsList(), getAllAdsNumber());
    }

    public List<Ads> getAdsList() {
        return adsList;
    }

    public void setAdsList(List<Ads> adsList) {
        this.adsList = adsList;
    }

    public Integer getAllAdsNumber() {
        return allAdsNumber;
    }

    public void setAllAdsNumber(Integer allAdsNumber) {
        this.allAdsNumber = allAdsNumber;
    }
}
