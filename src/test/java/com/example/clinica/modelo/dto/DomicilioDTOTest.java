package com.example.clinica.modelo.dto;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioDTOTest {
    private DomicilioDTO domicilioDefault;

    private final String CALLE_DEFAULT = "Manuel Ugarte";
    private final Integer NUMERO_DEFAULT = 12365;
    private final String LOCALIDAD_DEFAULT = "Belgrano";
    private final String PROVINCIA_DEFAULT = "Buenos Aires";

    @BeforeEach
    void setUpBeforeEach() {
        domicilioDefault = new DomicilioDTO();
    }

    @AfterEach
    void setUpAfterEach() {
        domicilioDefault = null;
    }

    @Test
    @DisplayName("Get Calle")
    void getCalle() {
        domicilioDefault.setCalle(CALLE_DEFAULT);
        Assertions.assertEquals(CALLE_DEFAULT, domicilioDefault.getCalle());
    }

    @Test
    @DisplayName("Get Numero")
    void getNumero() {
        domicilioDefault.setNumero(NUMERO_DEFAULT);
        Assertions.assertEquals(NUMERO_DEFAULT, domicilioDefault.getNumero());
    }

    @Test
    @DisplayName("Get Localidad")
    void getLocalidad() {
        domicilioDefault.setLocalidad(LOCALIDAD_DEFAULT);
        Assertions.assertEquals(LOCALIDAD_DEFAULT, domicilioDefault.getLocalidad());
    }

    @Test
    @DisplayName("Get Provincia")
    void getProvincia() {
        domicilioDefault.setProvincia(PROVINCIA_DEFAULT);
        Assertions.assertEquals(PROVINCIA_DEFAULT, domicilioDefault.getProvincia());
    }

    @Test
    @DisplayName("Get ID")
    void getIdDomicilio() {
        domicilioDefault.setIdDomicilio(1L);
        Assertions.assertEquals(1L, domicilioDefault.getIdDomicilio());
    }

    @Test
    @DisplayName("Set Calle")
    void setCalle() {
        domicilioDefault.setCalle(CALLE_DEFAULT);
        Assertions.assertEquals(CALLE_DEFAULT, domicilioDefault.getCalle());
    }

    @Test
    @DisplayName("Set Numero")
    void setNumero() {
        domicilioDefault.setNumero(NUMERO_DEFAULT);
        Assertions.assertEquals(NUMERO_DEFAULT, domicilioDefault.getNumero());
    }

    @Test
    @DisplayName("Set Localidad")
    void setLocalidad() {
        domicilioDefault.setLocalidad(LOCALIDAD_DEFAULT);
        Assertions.assertEquals(LOCALIDAD_DEFAULT, domicilioDefault.getLocalidad());
    }

    @Test
    @DisplayName("Set Provincia")
    void setProvincia() {
        domicilioDefault.setProvincia(PROVINCIA_DEFAULT);
        Assertions.assertEquals(PROVINCIA_DEFAULT, domicilioDefault.getProvincia());
    }

    @Test
    @DisplayName("Set ID")
    void setIdDomicilio() {
        domicilioDefault.setIdDomicilio(1L);
        Assertions.assertEquals(1L, domicilioDefault.getIdDomicilio());
    }

    /*@Test
    void builder() {
 */

}