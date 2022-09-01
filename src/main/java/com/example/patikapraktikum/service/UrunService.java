package com.example.patikapraktikum.service;

import com.example.patikapraktikum.dto.UrunResponse;
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

    public List<Urun> sktGecmisUrunler(Date sktBitis) {
        return urunRepo.findBySkt(sktBitis);

    }

    public Urun postUrun(Urun urun) {
        return urunRepo.save(urun);
    }
}
