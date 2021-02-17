package com.dev.f1.repository;

import com.dev.f1.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RacesRepository extends JpaRepository<Race, Integer> {
}
