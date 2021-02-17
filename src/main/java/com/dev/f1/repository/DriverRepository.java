package com.dev.f1.repository;

import com.dev.f1.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    List<Driver> findByNationality(String nationality);
}
