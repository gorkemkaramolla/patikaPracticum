package com.example.patikapraktikum.controllers;
import com.example.patikapraktikum.dto.UrunYorumResponse;
import com.example.patikapraktikum.entities.Urun;
import com.example.patikapraktikum.entities.UrunYorum;
import com.example.patikapraktikum.service.UrunYorumService;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/products/comments")
public class UrunYorumController {
    public UrunYorumController(UrunYorumService urunYorumService) {
        this.urunYorumService = urunYorumService;
    }

    private final UrunYorumService urunYorumService;
    @PostMapping
    private UrunYorum uruneYorumEkle(@RequestBody UrunYorum urunYorum)
    {
        return urunYorumService.uruneYorumEkle(urunYorum);
    }
    @GetMapping("/urun/{urunId}")
    private List<UrunYorumResponse> getCommentsByUrunId(@PathVariable Long urunId)
    {
        return urunYorumService.getCommentsByUrunId(urunId);
    }
    @GetMapping("/kullanici/{kullaniciId}")
    private List<UrunYorumResponse> getCommentsByKullaniciId(@PathVariable Long kullaniciId)
    {
        return urunYorumService.getCommentsByKullaniciId(kullaniciId);
    }
    @GetMapping("/urun/{urunId}/{sdate}/{edate}")
    private List<UrunYorumResponse> getUrunCommentsInTimeRange(@PathVariable Long urunId,@PathVariable String sdate, @PathVariable String edate) throws ParseException {
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(edate);

        return urunYorumService.getUrunCommentsInTimeRange(urunId,startDate,endDate);
    }
    @GetMapping("/kullanici/{kullaniciId}/{sdate}/{edate}")
    private List<UrunYorumResponse> getKullaniciCommentsInTimeRange(@PathVariable Long kullaniciId,@PathVariable String sdate, @PathVariable String edate) throws ParseException {
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(edate);

        return urunYorumService.getKullaniciCommentsInTimeRange(kullaniciId,startDate,endDate);
    }
}
