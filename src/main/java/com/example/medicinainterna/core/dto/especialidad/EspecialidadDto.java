package com.example.medicinainterna.core.dto.especialidad;

import com.example.medicinainterna.core.model.Especialidad;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadDto {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "El nombre no puede ser nulo o estar vacío")
    @Column(nullable = false,name = "nombreEspecialidad",length = 255)
    @Size(min = 2,max = 255,message = "EL nombre de tener entre 2 y 255 caracteres")
    private String nombre;

    public EspecialidadDto(Especialidad especialidad) {
        this.id = especialidad.getId();
        this.nombre = especialidad.getNombre();
    }
}
