package com.example.medicinainterna.core.service;

import com.example.medicinainterna.core.model.Especialidad;
import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public interface EspecialidadService {
    void insertarEspecialidad(Especialidad especialidad) throws Exception;

    void actualizarEspecialidad(Especialidad especialidad) throws Exception;

    void eliminarEspecialidad(Long id) throws Exception;
}
