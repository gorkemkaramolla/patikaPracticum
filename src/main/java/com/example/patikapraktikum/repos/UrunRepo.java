package com.example.patikapraktikum.repos;
import com.example.patikapraktikum.entities.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UrunRepo extends JpaRepository<Urun,Long> {
    List<Urun> findBySktDateBefore(Date todaysDate);
    List<Urun> findBySktDateAfterOrSktDateNull(Date todaysDate);
}
