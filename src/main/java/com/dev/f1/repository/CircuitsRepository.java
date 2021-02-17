package com.dev.f1.repository;

import com.dev.f1.entity.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircuitsRepository extends JpaRepository<Circuit, Integer> {
}
