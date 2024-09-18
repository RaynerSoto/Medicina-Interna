package com.example.medicinainterna.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @Column(name = "idCita", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cita_seq")
    @SequenceGenerator(name = "cita_seq",sequenceName = "citaSequence",initialValue = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idConsultorio", nullable = false)
    private Consultorio consultorio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", nullable = false)
    private Doctor doctor;

    @Column(name = "fechaCita",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
}
