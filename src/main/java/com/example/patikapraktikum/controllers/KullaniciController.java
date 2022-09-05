package com.example.patikapraktikum.controllers;

import com.example.patikapraktikum.entities.Kullanici;
import com.example.patikapraktikum.service.KullaniciService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class KullaniciController {
    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    private final KullaniciService kullaniciService;
    @PostMapping
    public Kullanici kullaniciEkle(@RequestBody Kullanici kullanici)
    {
        return kullaniciService.kullaniciEkle(kullanici);
    }
    @GetMapping
    public List<Kullanici> getAllKullanici()
    {
        return kullaniciService.getAllKullanici();
    }
    @GetMapping("/{kullaniciId}")
    public Kullanici getKullaniciById(@PathVariable Long kullaniciId)
    {
       return kullaniciService.getKullaniciById(kullaniciId);
    }
}
