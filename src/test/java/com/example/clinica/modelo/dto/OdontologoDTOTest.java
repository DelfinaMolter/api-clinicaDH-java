package com.example.clinica.modelo.dto;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDTOTest {
    private OdontologoDTO odontologoDefault;
    private final String NOMBRE_DEFAULT = "Florencia";
    private final String APELLIDO_DEFAULT ="Varela";
    private final String MATRICULA_DEFAULT ="123";

    @BeforeEach
    void setUpBeforeEach() {
        odontologoDefault = new OdontologoDTO();
    }

    @AfterEach
    void setUpAfterEach() {
        odontologoDefault = null;
    }

    @Test
    @DisplayName("Get Nombre")
    void getNombre() {
        odontologoDefault.setNombre(NOMBRE_DEFAULT);
        Assertions.assertEquals(NOMBRE_DEFAULT, odontologoDefault.getNombre());
    }

    @Test
    @DisplayName("Get Apellido")
    void getApellido() {
        odontologoDefault.setApellido(APELLIDO_DEFAULT);
        Assertions.assertEquals(APELLIDO_DEFAULT, odontologoDefault.getApellido());
    }

    @Test
    @DisplayName("Get Matricula")
    void getMatricula() {
        odontologoDefault.setMatricula(MATRICULA_DEFAULT);
        Assertions.assertEquals(MATRICULA_DEFAULT, odontologoDefault.getMatricula());
    }


    @Test
    @DisplayName("Get id")
    void getIdOdontologo() {
        odontologoDefault.setIdOdontologo(1L);
        Assertions.assertEquals(1L, odontologoDefault.getIdOdontologo());
    }
    @Test
    @DisplayName("Set id")
    void setIdOdontologo() {
        odontologoDefault.setIdOdontologo(1L);
        Assertions.assertEquals(1L, odontologoDefault.getIdOdontologo());
    }

    @Test
    @DisplayName("Set Nombre")
    void setNombre() {
        odontologoDefault.setNombre(NOMBRE_DEFAULT);
        Assertions.assertEquals(NOMBRE_DEFAULT, odontologoDefault.getNombre());
    }

    @Test
    @DisplayName("Set Apellido")
    void setApellido() {
        odontologoDefault.setApellido(APELLIDO_DEFAULT);
        Assertions.assertEquals(APELLIDO_DEFAULT, odontologoDefault.getApellido());
    }

    @Test
    @DisplayName("Set Matricula")
    void setMatricula() {
        odontologoDefault.setMatricula(MATRICULA_DEFAULT);
        Assertions.assertEquals(MATRICULA_DEFAULT, odontologoDefault.getMatricula());
    }


}