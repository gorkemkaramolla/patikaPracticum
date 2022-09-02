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


    public List<Urun> sktGecmisUrunler()  {

        Date todaysDate = new Date(System.currentTimeMillis());

        return urunRepo.findBySktDateBefore(new java.sql.Date(todaysDate.getTime()));

    }

    public List<Urun> sktGecmemisUrunler()  {

        Date todaysDate = new Date(System.currentTimeMillis());

        return urunRepo.findBySktDateAfterOrSktDateNull(new java.sql.Date(todaysDate.getTime()));

    }

    public Urun postUrun(Urun urun) {
        return urunRepo.save(urun);
    }
}
