package com.example.patikapraktikum.service;

import com.example.patikapraktikum.dto.UrunYorumResponse;
import com.example.patikapraktikum.entities.UrunYorum;
import com.example.patikapraktikum.repos.UrunYorumRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UrunYorumService {
    public UrunYorumService(UrunYorumRepo urunYorumRepo) {

        this.urunYorumRepo = urunYorumRepo;
    }
    private final UrunYorumRepo urunYorumRepo;


    //Ürüne ait yorumları listeyen metot
    public List<UrunYorumResponse> getCommentsByUrunId(Long urunId)
    {

        List<UrunYorum> urunYorumlar =urunYorumRepo.findByUrunId(urunId);
        return urunYorumlar.stream().map(UrunYorumResponse::new).collect(Collectors.toList());


    }
    //Kullanici id ile yorumlara ulaşan metot
    public List<UrunYorumResponse> getCommentsByKullaniciId(Long kullaniciId)
    {
        List<UrunYorum> urunYorumlar =urunYorumRepo.findByKullaniciId(kullaniciId);
        return urunYorumlar.stream().map(UrunYorumResponse::new).collect(Collectors.toList());


    }

    //Verilen Tarih aralıklarında belirli bir ürüne yapılmış olan yorumları listeleyen metot
    public List<UrunYorumResponse> getUrunCommentsInTimeRange(Long urunId,Date startDate, Date endDate) {

        return urunYorumRepo.findByDateCreatedBetweenAndKullaniciId(startDate,endDate,urunId).stream().map(UrunYorumResponse::new).collect(Collectors.toList());
    }
    //Bir Kullanıcının belirli tarihler arasında yapmış olduğu yorumları gösteren bir metot
    public List<UrunYorumResponse> getKullaniciCommentsInTimeRange(Long kullaniciId,Date startDate, Date endDate) {

        return urunYorumRepo.findByDateCreatedBetweenAndKullaniciId(startDate,endDate,kullaniciId).stream().map(UrunYorumResponse::new).collect(Collectors.toList());
    }

    public UrunYorum uruneYorumEkle(UrunYorum urunYorum) {
       return urunYorumRepo.save(urunYorum);
    }
}
