package com.example.patikapraktikum.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Kullanici {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String adi;
    @Column(length = 50)
    private String soyAdi;
    @Column(length = 50)
    private String eMail;
    @Column(length = 15)
    private String telNo;

    @OneToMany(mappedBy = "kullanici")
    Set<UrunYorum> yorumlar = new HashSet<>();


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

    public String getSoyAdi() {
        return soyAdi;
    }

    public void setSoyAdi(String soyAdi) {
        this.soyAdi = soyAdi;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Set<UrunYorum> getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(HashSet<UrunYorum> yorumlar) {
        this.yorumlar = yorumlar;
    }

    public Kullanici() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kullanici kullanici = (Kullanici) o;

        if (id != null ? !id.equals(kullanici.id) : kullanici.id != null) return false;
        if (adi != null ? !adi.equals(kullanici.adi) : kullanici.adi != null) return false;
        if (soyAdi != null ? !soyAdi.equals(kullanici.soyAdi) : kullanici.soyAdi != null) return false;
        if (eMail != null ? !eMail.equals(kullanici.eMail) : kullanici.eMail != null) return false;
        if (telNo != null ? !telNo.equals(kullanici.telNo) : kullanici.telNo != null) return false;
        return yorumlar != null ? yorumlar.equals(kullanici.yorumlar) : kullanici.yorumlar == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (adi != null ? adi.hashCode() : 0);
        result = 31 * result + (soyAdi != null ? soyAdi.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (telNo != null ? telNo.hashCode() : 0);
        result = 31 * result + (yorumlar != null ? yorumlar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", soyAdi='" + soyAdi + '\'' +
                ", eMail='" + eMail + '\'' +
                ", telNo='" + telNo + '\'' +
                ", yorumlar=" + yorumlar +
                '}';
    }
}
