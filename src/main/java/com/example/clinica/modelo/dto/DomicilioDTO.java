package com.example.clinica.modelo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
    private Long idDomicilio;
}
