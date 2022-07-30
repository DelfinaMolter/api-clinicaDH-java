package com.example.clinica.modelo.dto;

import org.junit.jupiter.api.*;


class PacienteDTOTest {
    private PacienteDTO pacienteDefault;

    private final String NOMBRE_DEFAULT = "Delfina";
    private final String APELLIDO_DEFAULT ="Molter";
    private final String DNI_DEFAULT ="36972449";
    private final String FECHA_DE_ALTA_DEFAULT = "2022-07-05 22:10:52";

    private DomicilioDTO domicilioDTO = new DomicilioDTO();
    private final String CALLE_DEFAULT = "Manuel Ugarte";
    private final Integer NUMERO_DEFAULT = 12365;
    private final String LOCALIDAD_DEFAULT = "Belgrano";
    private final String PROVINCIA_DEFAULT = "Buenos Aires";



    @BeforeEach
    void setUpBeforeEach() {
        pacienteDefault = new PacienteDTO();
    }

    @AfterEach
    void setUpAfterEach() {
        pacienteDefault = null;
    }

    @Test
    @DisplayName("Get Nombre")
    void getNombre() {
        pacienteDefault.setNombre(NOMBRE_DEFAULT);
        Assertions.assertEquals(NOMBRE_DEFAULT, pacienteDefault.getNombre());
    }

    @Test
    @DisplayName("Get Apellido")
    void getApellido() {
        pacienteDefault.setApellido(APELLIDO_DEFAULT);
        Assertions.assertEquals(APELLIDO_DEFAULT, pacienteDefault.getApellido());
    }

    @Test
    @DisplayName("Get DNI")
    void getDni() {
        pacienteDefault.setDni(DNI_DEFAULT);
        Assertions.assertEquals(DNI_DEFAULT, pacienteDefault.getDni());
    }

    @Test
    @DisplayName("Get Fecha de Alta")
    void getFechaDeAlta() {
        pacienteDefault.setFechaDeAlta(FECHA_DE_ALTA_DEFAULT);
        Assertions.assertEquals(FECHA_DE_ALTA_DEFAULT, pacienteDefault.getFechaDeAlta());
    }

    @Test
    @DisplayName("Get Domicilio")
    void getDomicilio() {
        domicilioDTO.setCalle(CALLE_DEFAULT);
        domicilioDTO.setNumero(NUMERO_DEFAULT);
        domicilioDTO.setLocalidad(LOCALIDAD_DEFAULT);
        domicilioDTO.setProvincia(PROVINCIA_DEFAULT);
        pacienteDefault.setDomicilio(domicilioDTO);
        Assertions.assertEquals(domicilioDTO, pacienteDefault.getDomicilio());
    }


    @Test
    @DisplayName("Get ID")
    void getIdPaciente() {
        pacienteDefault.setIdPaciente(1L);
        Assertions.assertEquals(1L, pacienteDefault.getIdPaciente());
    }

    @Test
    @DisplayName("Set Nombre")
    void setNombre() {
        pacienteDefault.setNombre(NOMBRE_DEFAULT);
        Assertions.assertEquals(NOMBRE_DEFAULT, pacienteDefault.getNombre());
    }

    @Test
    @DisplayName("Set Apellido")
    void setApellido() {
        pacienteDefault.setApellido(APELLIDO_DEFAULT);
        Assertions.assertEquals(APELLIDO_DEFAULT, pacienteDefault.getApellido());
    }

    @Test
    @DisplayName("Set DNI")
    void setDni() {
        pacienteDefault.setDni(DNI_DEFAULT);
        Assertions.assertEquals(DNI_DEFAULT, pacienteDefault.getDni());
    }

    @Test
    @DisplayName("Set Fecha de Alta")
    void setFechaDeAlta() {
        pacienteDefault.setFechaDeAlta(FECHA_DE_ALTA_DEFAULT);
        Assertions.assertEquals(FECHA_DE_ALTA_DEFAULT, pacienteDefault.getFechaDeAlta());
    }

    @Test
    @DisplayName("Set Domicilio")
    void setDomicilio() {
        domicilioDTO.setCalle(CALLE_DEFAULT);
        domicilioDTO.setNumero(NUMERO_DEFAULT);
        domicilioDTO.setLocalidad(LOCALIDAD_DEFAULT);
        domicilioDTO.setProvincia(PROVINCIA_DEFAULT);
        pacienteDefault.setDomicilio(domicilioDTO);
        Assertions.assertEquals(domicilioDTO, pacienteDefault.getDomicilio());
    }

    @Test
    @DisplayName("Set ID")
    void setIdPaciente() {
        pacienteDefault.setIdPaciente(1L);
        Assertions.assertEquals(1L, pacienteDefault.getIdPaciente());
    }

}