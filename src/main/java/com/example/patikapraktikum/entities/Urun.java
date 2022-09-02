package com.example.patikapraktikum.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity

public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adi;
    private Double fiyat;
    @Temporal(TemporalType.DATE)
    @Column()
    private Date sktDate;
    @OneToMany(mappedBy = "urun")
    Set<UrunYorum> yorumlar = new HashSet<>();


    public Urun() {
    }




    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", fiyat=" + fiyat +
                ", skt=" + sktDate +
                ", yorumlar=" + yorumlar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Urun urun = (Urun) o;

        if (id != null ? !id.equals(urun.id) : urun.id != null) return false;
        if (adi != null ? !adi.equals(urun.adi) : urun.adi != null) return false;
        if (fiyat != null ? !fiyat.equals(urun.fiyat) : urun.fiyat != null) return false;
        if (sktDate != null ? !sktDate.equals(urun.sktDate) : urun.sktDate != null) return false;
        return yorumlar != null ? yorumlar.equals(urun.yorumlar) : urun.yorumlar == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (adi != null ? adi.hashCode() : 0);
        result = 31 * result + (fiyat != null ? fiyat.hashCode() : 0);
        result = 31 * result + (sktDate != null ? sktDate.hashCode() : 0);
        result = 31 * result + (yorumlar != null ? yorumlar.hashCode() : 0);
        return result;
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

    public Date getSktDate() {
        return sktDate;
    }

    public void setSktDate(Date skt) {
        this.sktDate = skt;
    }

    public Set<UrunYorum> getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(HashSet<UrunYorum> yorumlar) {
        this.yorumlar = yorumlar;
    }
}
