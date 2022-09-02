package com.example.patikapraktikum.repos;

import com.example.patikapraktikum.entities.UrunYorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UrunYorumRepo extends JpaRepository<UrunYorum,Long> {
    List<UrunYorum> findByUrunId(Long id);

    List<UrunYorum> findByKullaniciId(Long id);


    List<UrunYorum> findByDateCreatedBetweenAndKullaniciId(Date startDate,Date endDate,Long id);
}
