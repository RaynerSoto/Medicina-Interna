package com.example.medicinainterna.core.dto.doctor;

import com.example.medicinainterna.core.dto.abstracta.PersonaDto;
import com.example.medicinainterna.core.model.Doctor;
import com.example.medicinainterna.core.model.Especialidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto extends PersonaDto {
    private String especialidad;

    public DoctorDto(Doctor doctor){
        super(doctor.getId(), doctor.getNombre(), doctor.getApellidoPaterno(), doctor.getApellidoPaterno());
        this.especialidad = doctor.getEspecialidad().getNombre();
    }
}
