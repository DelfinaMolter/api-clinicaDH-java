package com.example.clinica.modelo.dto;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TurnoDTOTest {
    private TurnoDTO turnoDefault;

    private final LocalDateTime FECHA_Y_HORA_DEFAULT= LocalDateTime.parse("2022-10-10T11:25:00");
    private final OdontologoDTO ODONTOLOGO_DEFAULT = OdontologoDTO.builder()
            .nombre("Florencia")
            .apellido("Varela")
            .matricula("235487")
            .build();;
    private final PacienteDTO PACIENTE_DEFAULT = PacienteDTO.builder()
            .nombre("Delfina")
            .apellido("Molter")
            .dni("359724695")
            .fechaDeAlta("2022-07-05 22:10:52")
            .build();

    @BeforeEach
    void setUpBeforeEach() {
        turnoDefault = new TurnoDTO();
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


}