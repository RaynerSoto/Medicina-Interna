package com.example.medicinainterna.core.model;

import com.example.medicinainterna.core.dto.especialidad.EspecialidadDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "especialidades")
public class Especialidad{

    @Id
    @Column(name = "idEspecialidad", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "especialidad_seq")
    @SequenceGenerator(name = "especialidad_seq",sequenceName = "especialidadSequence",initialValue = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "El nombre no puede ser nulo o estar vacío")
    @Column(nullable = false,name = "nombreEspecialidad",length = 255)
    @Size(min = 2,max = 255,message = "EL nombre de tener entre 2 y 255 caracteres")
    private String nombre;

    @OneToMany(mappedBy = "especialidad",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Doctor> doctores;

    public Especialidad(EspecialidadDto especialidadDto) {
        this.id = especialidadDto.getId();
        this.nombre = especialidadDto.getNombre();
    }
}
