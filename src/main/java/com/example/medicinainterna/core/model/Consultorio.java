package com.example.medicinainterna.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consultorios")
public class Consultorio {

    @Id
    @Column(name = "idConsultorio", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "consultorio_seq")
    @SequenceGenerator(name = "consultorio_seq",sequenceName = "consultorioSequence",initialValue = 1)
    private Long id;

    @Column(unique = true,nullable = false)
    @Size(min = 1,message = "El número del consultorio es mínimo 1")
    private Long numeroConsultorio;

    @Column(nullable = false)
    @Size(min = 1,message = "El número del piso es mínimo 1")
    private int piso;

    @OneToMany(mappedBy = "consultorio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Cita> citas;
}
