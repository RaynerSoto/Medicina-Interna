package com.example.medicinainterna.core.dto.abstracta;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PersonaDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "El nombre no puede ser nulo o estar vacío")
    @Column(nullable = false,length = 255)
    @Size(min = 2,max = 255,message = "EL nombre de tener entre 2 y 255 caracteres")
    private String nombre;

    @Column(length = 255,nullable = false)
    @Size(min = 2,max = 255,message = "EL apellido paterno de tener entre 2 y 255 caracteres")
    @NotBlank(message = "El apellido paterno no puede ser nulo o estar vacío")
    private String apellidoPaterno;

    @Column(length = 255,nullable = false)
    @Size(min = 2,max = 255,message = "EL apellido materno de tener entre 2 y 255 caracteres")
    @NotBlank(message = "El apellido materno no puede ser nulo o estar vacío")
    private String apellidoMaterno;
}
