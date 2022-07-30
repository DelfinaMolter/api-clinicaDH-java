package com.example.clinica.modelo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private LocalDateTime fechaYHora;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;
    private Long idTurno;
}
