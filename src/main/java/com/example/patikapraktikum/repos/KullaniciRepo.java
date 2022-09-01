package com.example.patikapraktikum.repos;

import com.example.patikapraktikum.entities.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciRepo extends JpaRepository<Kullanici,Long> {
}
