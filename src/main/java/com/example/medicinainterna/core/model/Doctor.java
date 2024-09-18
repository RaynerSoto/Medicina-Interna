package com.example.medicinainterna.core.model;

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
@Table(name = "doctores")
public class Doctor extends Persona{
    @Id
    @Column(name = "idDoctor", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "doctor_seq")
    @SequenceGenerator(name = "doctor_seq",sequenceName = "doctorSequence",initialValue = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nombreEspecialidad")
    private Especialidad especialidad;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Cita> citas;
}
