package com.example.medicinainterna.core.repository;

import com.example.medicinainterna.core.model.Doctor;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

@Hidden
public interface DoctorRespository extends JpaRepository<Doctor, Long> {
}
