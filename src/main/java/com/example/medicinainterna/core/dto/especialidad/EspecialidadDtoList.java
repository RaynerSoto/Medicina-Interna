package com.example.medicinainterna.core.dto.especialidad;

import com.example.medicinainterna.core.dto.doctor.DoctorDto;
import com.example.medicinainterna.core.model.Especialidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadDtoList extends EspecialidadDto {
    public List<DoctorDto> doctores;

    public EspecialidadDtoList(Especialidad especialidad) {
        super(especialidad);
        this.doctores = especialidad.getDoctores().stream().map(DoctorDto::new).toList();
    }
}
