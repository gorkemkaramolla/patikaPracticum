package com.example.patikapraktikum.service;
import com.example.patikapraktikum.entities.Urun;
import com.example.patikapraktikum.repos.UrunRepo;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class UrunService {
    private final UrunRepo urunRepo;

    public UrunService(UrunRepo urunRepo) {
        this.urunRepo = urunRepo;
    }

    public Urun  getUrunById(Long id)
    {

        return urunRepo.findById(id).orElse(null);
    }
    //Son kullanma tarihi geçmiş ürünleri listeleyen metot
    public List<Urun> sktGecmisUrunler()  {

        Date todaysDate = new Date(System.currentTimeMillis());

        return urunRepo.findBySktDateBefore(new java.sql.Date(todaysDate.getTime()));

    }
    //Son kullanma tarihi geçmemiş ürünler ve son kullanma tarihi boş olan ürünleri getiren metot
    public List<Urun> sktGecmemisUrunler()  {

        Date todaysDate = new Date(System.currentTimeMillis());

        return urunRepo.findBySktDateAfterOrSktDateNull(new java.sql.Date(todaysDate.getTime()));

    }
    //Ürün eklemek için oluşturulumş metot
    public Urun postUrun(Urun urun) {
        return urunRepo.save(urun);
    }
}
