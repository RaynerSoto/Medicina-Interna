package com.example.medicinainterna.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Persona {
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
