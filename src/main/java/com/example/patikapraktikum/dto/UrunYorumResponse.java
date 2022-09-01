package com.example.patikapraktikum.dto;


import com.example.patikapraktikum.entities.UrunYorum;

public class UrunYorumResponse {

    private Long id;
    private Long urunId;
    private Long kullaniciId;
    private String yorum;


    public UrunYorumResponse(UrunYorum urunYorum) {
        this.id = urunYorum.getId();
        this.urunId = urunYorum.getUrun().getId();
        this.kullaniciId = urunYorum.getKullanici().getId();
        this.yorum = urunYorum.getYorum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUrunId() {
        return urunId;
    }

    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }
}
