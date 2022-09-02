package com.example.patikapraktikum.service;

import com.example.patikapraktikum.dto.UrunYorumResponse;
import com.example.patikapraktikum.entities.UrunYorum;
import com.example.patikapraktikum.repos.UrunYorumRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<UrunYorumResponse> getCommentsByUrunId(Long urunId)
    {

        List<UrunYorum> urunYorumlar =urunYorumRepo.findByUrunId(urunId);
        return urunYorumlar.stream().map(UrunYorumResponse::new).collect(Collectors.toList());


    }
    public List<UrunYorumResponse> getCommentsByKullaniciId(Long kullaniciId)
    {
        List<UrunYorum> urunYorumlar =urunYorumRepo.findByKullaniciId(kullaniciId);
        return urunYorumlar.stream().map(UrunYorumResponse::new).collect(Collectors.toList());


    }


    public List<UrunYorumResponse> getUrunCommentsInTimeRange(Long urunId,Date startDate, Date endDate) {

        return urunYorumRepo.findByDateCreatedBetweenAndKullaniciId(startDate,endDate,urunId).stream().map(UrunYorumResponse::new).collect(Collectors.toList());
    }
    public List<UrunYorumResponse> getKullaniciCommentsInTimeRange(Long kullaniciId,Date startDate, Date endDate) {

        return urunYorumRepo.findByDateCreatedBetweenAndKullaniciId(startDate,endDate,kullaniciId).stream().map(UrunYorumResponse::new).collect(Collectors.toList());
    }
}
