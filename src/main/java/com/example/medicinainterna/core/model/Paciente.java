package com.example.medicinainterna.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pacientes")
public class Paciente extends Persona{
    @Id
    @Column(name = "idPaciente", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "paciente_seq")
    @SequenceGenerator(name = "paciente_seq",sequenceName = "pacienteSequence",initialValue = 1)
    private Long id;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Cita> citas;
}
