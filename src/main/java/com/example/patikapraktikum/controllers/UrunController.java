package com.example.patikapraktikum.controllers;
import com.example.patikapraktikum.entities.Urun;
import com.example.patikapraktikum.service.UrunService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class UrunController {
    private final UrunService urunService;

    public UrunController(UrunService urunService) {
        this.urunService = urunService;
    }
    @GetMapping("/sktgecmisurunler")
    List<Urun> getSktGecmisUrunler() {
        return urunService.sktGecmisUrunler();
    }
    @GetMapping("/sktgecmemisurunler")
    List<Urun> getSktGecmemisUrunler()
    {
        return urunService.sktGecmemisUrunler();
    }
    @PostMapping()
    public Urun postUrun(@RequestBody Urun urun)
    {
        return urunService.postUrun(urun);
    }
}
