package com.example.clinica.modelo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private String nombre;
    private String apellido;
    private String dni;
    private String fechaDeAlta;
    private DomicilioDTO domicilio;
    private Long idPaciente;
}
