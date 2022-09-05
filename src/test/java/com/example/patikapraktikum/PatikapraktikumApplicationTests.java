package com.example.patikapraktikum;

import com.example.patikapraktikum.dto.UrunYorumResponse;
import com.example.patikapraktikum.entities.Kullanici;
import com.example.patikapraktikum.entities.Urun;
import com.example.patikapraktikum.entities.UrunYorum;
import com.example.patikapraktikum.service.KullaniciService;
import com.example.patikapraktikum.service.UrunService;
import com.example.patikapraktikum.service.UrunYorumService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PatikapraktikumApplicationTests {

    @Autowired
    private UrunService urunService;
    @Autowired
    private UrunYorumService urunYorumService;

    @Autowired
    private KullaniciService kullaniciService;

    @Test
    public void kullaniciEklemeTest() {
        Kullanici kullanici = new Kullanici();
        kullanici.setSoyAdi("Karamolla");
        kullanici.setAdi("Görkem");
        kullanici.setTelNo("539");
        kullanici.seteMail("gorkemkaramolla@gmail.com");
        kullaniciService.kullaniciEkle(kullanici);


        Kullanici kullanici2 = new Kullanici();
        kullanici2.setSoyAdi("Doe");
        kullanici2.setAdi("John");
        kullanici2.setTelNo("533");
        kullanici2.seteMail("johndoe@gmail.com");
        kullaniciService.kullaniciEkle(kullanici2);
    }

    @Test
    public void sktsiGecmisUrunlerTest() throws ParseException {
        Urun sktsiGecmisUrun = new Urun();
        sktsiGecmisUrun.setAdi("Çay");
        sktsiGecmisUrun.setFiyat(25000.0);
        sktsiGecmisUrun.setSktDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-03"));
        urunService.postUrun(sktsiGecmisUrun);

        Urun sktsiGecmisUrun2 = new Urun();
        sktsiGecmisUrun2.setAdi("Peynir");
        sktsiGecmisUrun2.setFiyat(25000.0);
        sktsiGecmisUrun2.setSktDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-13"));
        urunService.postUrun(sktsiGecmisUrun2);

        List<Urun> sktGecmisUrunler = urunService.sktGecmisUrunler();
        System.out.println(sktGecmisUrunler);

    }
    @Test
    public void sktsiGecmemisUrunlerTest() throws ParseException {

        Urun sktGecmemisUrun = new Urun();
        sktGecmemisUrun.setAdi("Sucuk");
        sktGecmemisUrun.setFiyat(150.25);
        sktGecmemisUrun.setSktDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-1"));
        urunService.postUrun(sktGecmemisUrun);

        Urun sktsizUrun = new Urun();
        sktsizUrun.setId(2L);
        sktsizUrun.setAdi("Huawei notebook");
        sktsizUrun.setFiyat(25000.0);
        urunService.postUrun(sktsizUrun);


        List<Urun> sktGecmemisUrunler = urunService.sktGecmemisUrunler();
        System.out.println(sktGecmemisUrunler);

    }

    @Test
    public void urunYorumlariEklemeTest()
    {

        Urun eklenecekUrun = urunService.getUrunById(1L);
        Kullanici kullanici = kullaniciService.getKullaniciById(1L);
        UrunYorum urunYorum = new UrunYorum();
        urunYorum.setUrun(eklenecekUrun);
        urunYorum.setYorum("Güzel ürün");
        urunYorum.setKullanici(kullanici);
        urunYorumService.uruneYorumEkle(urunYorum);

        Urun urun= urunService.getUrunById(1L);
        Kullanici kullanici2 = kullaniciService.getKullaniciById(2L);
        UrunYorum urunYorum2 = new UrunYorum();
        urunYorum2.setUrun(urun);
        urunYorum2.setYorum("Güzel ürün2");
        urunYorum2.setKullanici(kullanici2);
        urunYorumService.uruneYorumEkle(urunYorum2);


        List<UrunYorumResponse> id1OlanUrununYorumlari = urunYorumService.getCommentsByUrunId(1L);
        List<UrunYorumResponse> id2OlanKullanicininYorumlari= urunYorumService.getCommentsByKullaniciId(2L);

        System.out.println(id1OlanUrununYorumlari);
        System.out.println(id2OlanKullanicininYorumlari);
    }
    @Test
    public void urununYorumlariniListelemeTest()
    {
        List<UrunYorumResponse> urunYorumlari = urunYorumService.getCommentsByUrunId(1L);
        System.out.println(urunYorumlari);
    }
    @Test
    public void kullanicininYorumlariniListelemeTest()
    {
        List<UrunYorumResponse> kullaniciYorumlari = urunYorumService.getCommentsByKullaniciId(1L);
        System.out.println(kullaniciYorumlari);
    }

    @Test
    public  void verilenTarihAraligindaUrununYorumlariniListeleme() throws ParseException {
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-09");
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2025-11-09");
        List<UrunYorumResponse> tarihAraligiYorumlar =urunYorumService.getUrunCommentsInTimeRange(1L,startDate,endDate);
        System.out.println(tarihAraligiYorumlar);
    }
    @Test
    public  void verilenTarihlerAraligindaKullanicininYorumlariniListeleme() throws ParseException {
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-09");
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2025-11-09");
        List<UrunYorumResponse> tarihAraligiYorumlar =urunYorumService.getKullaniciCommentsInTimeRange(1L,startDate,endDate);
        System.out.println(tarihAraligiYorumlar);
    }

}
