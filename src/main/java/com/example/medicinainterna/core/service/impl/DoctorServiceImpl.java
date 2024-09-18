package com.example.medicinainterna.core.service.impl;

import com.example.medicinainterna.core.model.Doctor;
import com.example.medicinainterna.core.repository.DoctorRespository;
import com.example.medicinainterna.core.service.DoctorService;
import com.example.medicinainterna.core.utils.Validacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRespository doctorRespository;

    @Autowired
    public DoctorServiceImpl(DoctorRespository doctorRespository) {
        this.doctorRespository = doctorRespository;
    }

    @Override
    public void insertarDoctor(Doctor doctor) throws Exception {
        Validacion.validarUnsupportedOperationException(doctor);
        doctorRespository.save(doctor);
    }

    @Override
    public void modificarDoctor(Doctor doctor) throws Exception {
        Validacion.validarUnsupportedOperationException(doctor);
        if (doctorRespository.existsById(doctor.getId()))
            doctorRespository.save(doctor);
        throw new Exception("El doctor a modificar no existe");
    }

    @Override
    public void eliminarDoctor(Doctor doctor) throws Exception {
        if (doctorRespository.existsById(doctor.getId()))
            doctorRespository.deleteById(doctor.getId());
        throw new Exception("El doctor a eliminar no existe");
    }
}
