package com.example.patikapraktikum.service;

import com.example.patikapraktikum.dto.UrunYorumResponse;
import com.example.patikapraktikum.entities.Urun;
import com.example.patikapraktikum.entities.UrunYorum;
import com.example.patikapraktikum.repos.UrunYorumRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UrunYorumService {
    public UrunYorumService(KullaniciService kullaniciService,UrunYorumRepo urunYorumRepo) {
        this.kullaniciService= kullaniciService;
        this.urunYorumRepo = urunYorumRepo;
    }
    private final UrunYorumRepo urunYorumRepo;

    private final KullaniciService kullaniciService;
    public List<UrunYorumResponse> getCommentsByUrunId(Optional<Long> urunId, Optional<Long> kullaniciId)
    {

        if(kullaniciId.isPresent())
        {
            List<UrunYorum> kullaniciYorumlar = urunYorumRepo.findByKullaniciId(kullaniciId.get());
            return kullaniciYorumlar.stream().map(UrunYorumResponse::new).collect(Collectors.toList());
        } else if (urunId.isPresent()) {
            List<UrunYorum> urunYorumlar =urunYorumRepo.findByUrunId(urunId.get());
            return urunYorumlar.stream().map(UrunYorumResponse::new).collect(Collectors.toList());
        }
        else {
           return urunYorumRepo.findAll().stream().map(UrunYorumResponse::new).collect(Collectors.toList());
        }

    }


}
