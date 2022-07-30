package com.example.clinica.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="odontologo")
public class Odontologo {
    @Column(name="nombre")
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String matricula;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Turno> turnos;

    @Id
    @SequenceGenerator(name="odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Long idOdontologo;

}
