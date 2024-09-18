package com.example.medicinainterna.core.service;

import com.example.medicinainterna.core.model.Doctor;
import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public interface DoctorService {
    void insertarDoctor(Doctor doctor) throws Exception;

    void modificarDoctor(Doctor doctor) throws Exception;

    void eliminarDoctor(Doctor doctor) throws Exception;
}
