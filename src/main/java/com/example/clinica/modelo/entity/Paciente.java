package com.example.clinica.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="paciente")
public class Paciente{

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String dni;

    @Column
    private Timestamp fechaDeAlta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDomicilio", referencedColumnName="idDomicilio", nullable = false)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Turno> turnos;

    @Id
    @SequenceGenerator(name="paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long idPaciente;
}
