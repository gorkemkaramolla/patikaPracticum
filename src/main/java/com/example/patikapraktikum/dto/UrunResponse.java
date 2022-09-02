package com.example.patikapraktikum.dto;

import com.example.patikapraktikum.entities.Urun;

import java.util.Date;

public class UrunResponse {
    private Long id;
    private String adi;
    private Double fiyat;
    private Date skt;


    public UrunResponse(Urun urun) {
        this.id = urun.getId();
        this.adi = urun.getAdi();
        this.fiyat = urun.getFiyat();
        this.skt = urun.getSktDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }

    public Date getSkt() {
        return skt;
    }

    public void setSkt(Date skt) {
        this.skt = skt;
    }
}
