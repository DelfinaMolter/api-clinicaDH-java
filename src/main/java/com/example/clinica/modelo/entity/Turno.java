package com.example.clinica.modelo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
public class Turno {

    @Column
    private LocalDateTime fechaYHora;

    @ManyToOne
    @JoinColumn(name = "idOdontologo", nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @Id
    @SequenceGenerator(name="turno_sequence", sequenceName = "turno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long idTurno;
}
