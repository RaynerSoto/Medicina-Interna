package com.example.medicinainterna.core.service.impl;

import com.example.medicinainterna.core.model.Especialidad;
import com.example.medicinainterna.core.repository.EspecialidadRepository;
import com.example.medicinainterna.core.service.EspecialidadService;
import com.example.medicinainterna.core.utils.Validacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
    private EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public void insertarEspecialidad(Especialidad especialidad) throws Exception {
        Validacion.validarUnsupportedOperationException(especialidad);
        if (especialidadRepository.findByNombreEqualsIgnoreCase(especialidad.getNombre()).isPresent() == true) {
            throw new Exception("Especialidad ya existe");
        }
        especialidadRepository.save(especialidad);
    }

    @Override
    public void actualizarEspecialidad(Especialidad especialidad) throws Exception {
        Validacion.validarUnsupportedOperationException(especialidad);
        if (especialidadRepository.existsById(especialidad.getId())) {
            especialidadRepository.save(especialidad);
        }
        throw new Exception("Especialidad a modificar no existe");
    }

    @Override
    public void eliminarEspecialidad(Long id) throws Exception {
        if (especialidadRepository.existsById(id)) {
            especialidadRepository.deleteById(id);
        }
        throw new Exception("Especialidad a eliminar no existe");
    }
}
