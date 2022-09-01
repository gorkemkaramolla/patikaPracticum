package com.example.patikapraktikum.controllers;

import com.example.patikapraktikum.dto.UrunYorumResponse;
import com.example.patikapraktikum.service.UrunYorumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class UrunYorumController {
    public UrunYorumController(UrunYorumService urunYorumService) {
        this.urunYorumService = urunYorumService;
    }

    private final UrunYorumService urunYorumService;
    @GetMapping("/comments")
    List<UrunYorumResponse> getProducts(@RequestParam Optional<Long> urunId, @RequestParam Optional<Long> kullaniciId)
    {
        return urunYorumService.getCommentsByUrunId(urunId,kullaniciId);
    }
}
