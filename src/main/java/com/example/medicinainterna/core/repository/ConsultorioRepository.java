package com.example.medicinainterna.core.repository;

import com.example.medicinainterna.core.model.Consultorio;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

@Hidden
public interface ConsultorioRepository extends JpaRepository<Consultorio,Long> {
}
