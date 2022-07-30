package com.example.clinica.service;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.OdontologoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Testeando el Service de Odontologo")
class OdontologoServiceTest {
    @Autowired
    private IOdontologoService odontologoService;

    @Test
    @DisplayName("Creando un Odontologo")
    public void testAgregarOdontologo() throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Florencia");
        odontologoDTO.setApellido("Varela");
        odontologoDTO.setMatricula("123");
        odontologoService.agregar(odontologoDTO);
        OdontologoDTO odontologoFlor = odontologoService.buscarPorId(1L);

        assertTrue(odontologoFlor != null);
    }

}