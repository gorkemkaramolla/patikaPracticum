package com.example.patikapraktikum.service;

import com.example.patikapraktikum.entities.Kullanici;
import com.example.patikapraktikum.repos.KullaniciRepo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class KullaniciService {
    private final KullaniciRepo kullaniciRepo;
    public KullaniciService(KullaniciRepo kullaniciRepo) {
        this.kullaniciRepo = kullaniciRepo;
    }
    //Yeni kullanıcı ekleme metotu
    public Kullanici kullaniciEkle(Kullanici kullanici) {
        return kullaniciRepo.save(kullanici);
    }



    //Kullanıcılar listesi dönen metot
    public List<Kullanici> getAllKullanici() {
        return kullaniciRepo.findAll();
    }

    public Kullanici getKullaniciById(Long kullaniciId) {
        return kullaniciRepo.findById(kullaniciId).get();
    }
}
