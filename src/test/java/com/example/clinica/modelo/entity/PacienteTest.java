package com.example.clinica.modelo.entity;

import org.junit.jupiter.api.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {
    private Paciente pacienteDefault;

    private final String NOMBRE_DEFAULT = "Delfina";
    private final String APELLIDO_DEFAULT ="Molter";
    private final String DNI_DEFAULT ="36972449";
    private final Timestamp FECHA_DE_ALTA_DEFAULT = new Timestamp(System.currentTimeMillis());

    private final Domicilio DOMICILIO_DEFAULT = Domicilio.builder()
            .calle("Manuel Ugarte")
            .numero(12365)
            .localidad("Belgrano")
            .provincia("Buenos Aires")
            .build();
    @BeforeEach
    void setUpBeforeEach() {
        pacienteDefault = new Paciente();
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
        pacienteDefault.setDomicilio(DOMICILIO_DEFAULT);
        Assertions.assertEquals(DOMICILIO_DEFAULT, pacienteDefault.getDomicilio());
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
        pacienteDefault.setDomicilio(DOMICILIO_DEFAULT);
        Assertions.assertEquals(DOMICILIO_DEFAULT, pacienteDefault.getDomicilio());
    }

    @Test
    @DisplayName("Set ID")
    void setIdPaciente() {
        pacienteDefault.setIdPaciente(1L);
        Assertions.assertEquals(1L, pacienteDefault.getIdPaciente());
    }

    @Test
    void builder() {
        pacienteDefault = Paciente.builder()
                .nombre("Delfina")
                .apellido("Molter")
                .dni("359724695")
                .fechaDeAlta(new Timestamp(System.currentTimeMillis()))
                .domicilio(DOMICILIO_DEFAULT)
                .idPaciente(1L)
                .build();

        Assertions.assertNotNull(pacienteDefault);
    }

    @Test
    void ToString(){
        String mensaje ="Paciente(nombre=Delfina, apellido=Molter, dni=359724695, fechaDeAlta=2022-07-08 17:51:31.561, domicilio=Domicilio(calle=Manuel Ugarte, numero=12365, localidad=Belgrano, provincia=Buenos Aires, idDomicilio=null), turnos=null, idPaciente=1)";
        pacienteDefault = Paciente.builder()
                .nombre("Delfina")
                .apellido("Molter")
                .dni("359724695")
                .fechaDeAlta(new Timestamp(System.currentTimeMillis()))
                .domicilio(DOMICILIO_DEFAULT)
                .idPaciente(1L)
                .build();

        Assertions.assertNotNull(mensaje, pacienteDefault.toString());
    }
}