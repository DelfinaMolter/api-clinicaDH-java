package com.example.clinica.modelo.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Domicilio {

    @Column
    private String calle;

    @Column
    private Integer numero;

    @Column
    private String localidad;

    @Column
    private String provincia;

    @Id
    @SequenceGenerator(name="domicilio_sequence", sequenceName = "domicilio_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long idDomicilio;


}
