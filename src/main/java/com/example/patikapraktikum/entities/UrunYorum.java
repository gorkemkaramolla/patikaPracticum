package com.example.patikapraktikum.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class UrunYorum {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String yorum;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "urun_id")
    private Kullanici urun;




    public UrunYorum() {
    }

    @Override
    public String toString() {
        return "UrunYorum{" +
                "id=" + id +
                ", yorum='" + yorum + '\'' +
                ", dateCreated=" + dateCreated +
                ", kullanici=" + kullanici +
                ", urun=" + urun +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UrunYorum urunYorum = (UrunYorum) o;

        if (id != null ? !id.equals(urunYorum.id) : urunYorum.id != null) return false;
        if (yorum != null ? !yorum.equals(urunYorum.yorum) : urunYorum.yorum != null) return false;
        if (dateCreated != null ? !dateCreated.equals(urunYorum.dateCreated) : urunYorum.dateCreated != null)
            return false;
        if (kullanici != null ? !kullanici.equals(urunYorum.kullanici) : urunYorum.kullanici != null) return false;
        return urun != null ? urun.equals(urunYorum.urun) : urunYorum.urun == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (yorum != null ? yorum.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (kullanici != null ? kullanici.hashCode() : 0);
        result = 31 * result + (urun != null ? urun.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Kullanici getUrun() {
        return urun;
    }

    public void setUrun(Kullanici urun) {
        this.urun = urun;
    }
}
