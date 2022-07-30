package com.example.clinica.modelo.entity;

import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {
    private Turno turnoDefault;

    private final LocalDateTime FECHA_Y_HORA_DEFAULT= LocalDateTime.parse("2022-10-10T11:25:00");
    private final Odontologo ODONTOLOGO_DEFAULT = Odontologo.builder()
            .nombre("Florencia")
            .apellido("Varela")
            .matricula("235487")
            .idOdontologo(1L)
            .build();

    private final Domicilio DOMICILIO_DEFAULT = Domicilio.builder()
            .calle("Manuel Ugarte")
            .numero(12365)
            .localidad("Belgrano")
            .provincia("Buenos Aires")
            .idDomicilio(1L)
            .build();

    private final Paciente PACIENTE_DEFAULT = Paciente.builder()
            .nombre("Delfina")
            .apellido("Molter")
            .dni("359724695")
            .fechaDeAlta(new Timestamp(System.currentTimeMillis()))
            .domicilio(DOMICILIO_DEFAULT)
            .idPaciente(1L)
            .build();

    @BeforeEach
    void setUpBeforeEach() {
        turnoDefault = new Turno();
    }

    @AfterEach
    void setUpAfterEach() {
        turnoDefault = null;
    }

    @Test
    @DisplayName("Get Fecha y Hora")
    void getFechaYHora() {
        turnoDefault.setFechaYHora(FECHA_Y_HORA_DEFAULT);
        Assertions.assertEquals(FECHA_Y_HORA_DEFAULT, turnoDefault.getFechaYHora());
    }

    @Test
    @DisplayName("Get Odontologo")
    void getOdontologo() {
        turnoDefault.setOdontologo(ODONTOLOGO_DEFAULT);
        Assertions.assertEquals(ODONTOLOGO_DEFAULT, turnoDefault.getOdontologo());
    }

    @Test
    @DisplayName("Get Paciente")
    void getPaciente() {
        turnoDefault.setPaciente(PACIENTE_DEFAULT);
        Assertions.assertEquals(PACIENTE_DEFAULT, turnoDefault.getPaciente());
    }

    @Test
    @DisplayName("Get ID")
    void getIdTurno() {
        turnoDefault.setIdTurno(1L);
        Assertions.assertEquals(1L, turnoDefault.getIdTurno());
    }

    @Test
    @DisplayName("Set Fecha y Hora")
    void setFechaYHora() {
        turnoDefault.setFechaYHora(FECHA_Y_HORA_DEFAULT);
        Assertions.assertEquals(FECHA_Y_HORA_DEFAULT, turnoDefault.getFechaYHora());
    }

    @Test
    @DisplayName("Set Odontologo")
    void setOdontologo() {
        turnoDefault.setOdontologo(ODONTOLOGO_DEFAULT);
        Assertions.assertEquals(ODONTOLOGO_DEFAULT, turnoDefault.getOdontologo());
    }

    @Test
    @DisplayName("Set Paciente")
    void setPaciente() {
        turnoDefault.setPaciente(PACIENTE_DEFAULT);
        Assertions.assertEquals(PACIENTE_DEFAULT, turnoDefault.getPaciente());
    }

    @Test
    @DisplayName("Set ID")
    void setIdTurno() {
        turnoDefault.setIdTurno(1L);
        Assertions.assertEquals(1L, turnoDefault.getIdTurno());
    }

    @Test
    void builder() {
        turnoDefault = Turno.builder()
                .fechaYHora(FECHA_Y_HORA_DEFAULT)
                .odontologo(ODONTOLOGO_DEFAULT)
                .paciente(PACIENTE_DEFAULT)
                .idTurno(1L)
                .build();
        System.out.println(turnoDefault);
        Assertions.assertNotNull(turnoDefault);
    }

    @Test
    void ToString(){
        String mensaje ="Turno(fechaYHora=2022-10-10T11:25, odontologo=Odontologo(nombre=Florencia, apellido=Varela, matricula=235487, turnos=null, idOdontologo=1), paciente=Paciente(nombre=Delfina, apellido=Molter, dni=359724695, fechaDeAlta=2022-07-08 18:00:56.586, domicilio=Domicilio(calle=Manuel Ugarte, numero=12365, localidad=Belgrano, provincia=Buenos Aires, idDomicilio=1), turnos=null, idPaciente=1), idTurno=1)";
        turnoDefault = Turno.builder()
                .fechaYHora(FECHA_Y_HORA_DEFAULT)
                .odontologo(ODONTOLOGO_DEFAULT)
                .paciente(PACIENTE_DEFAULT)
                .idTurno(1L)
                .build();

        Assertions.assertNotNull(mensaje, turnoDefault.toString());
    }
}