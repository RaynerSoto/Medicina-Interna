package com.example.medicinainterna.core.repository;

import com.example.medicinainterna.core.model.Especialidad;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Hidden
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
    Optional<Especialidad> findByNombreEqualsIgnoreCase(String nombre);
}
