package com.example.clinica.runner;

import com.example.clinica.modelo.entity.Domicilio;
import com.example.clinica.modelo.entity.Odontologo;
import com.example.clinica.modelo.entity.Paciente;
import com.example.clinica.modelo.entity.Turno;
import com.example.clinica.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(CommandLineRunnerImpl.class);

    private final OdontologoRepository odontologoRepository;
    private final PacienteRepository pacienteRepository;
    private final DomicilioRepository domicilioRepository;
    private final TurnoRepository turnoRepository;


    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    LocalDateTime date = LocalDateTime.parse("2022-10-10T11:25:00");

    @Autowired
    public CommandLineRunnerImpl(OdontologoRepository odontologoRepository, PacienteRepository pacienteRepository, DomicilioRepository domicilioRepository, TurnoRepository turnoRepository) {
        this.odontologoRepository = odontologoRepository;
        this.pacienteRepository = pacienteRepository;
        this.domicilioRepository = domicilioRepository;
        this.turnoRepository = turnoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("*** Iniciando el proceso **** ");


        Odontologo o1 = Odontologo.builder()
                .nombre("Andres")
                .apellido("Lopez")
                .matricula("FKW12K")
                .build();

        odontologoRepository.save(o1);

        Domicilio d1 = Domicilio.builder()
                .calle("Manuel Ugarte")
                .numero(12365)
                .localidad("Belgrano")
                .provincia("Buenos Aires")
                .build();

        Paciente p1 = Paciente.builder()
                .nombre("Delfina")
                .apellido("Molter")
                .dni("32654789")
                .domicilio(d1)
                .fechaDeAlta(timestamp)
                .build();
        pacienteRepository.save(p1);

        Turno t1 = Turno.builder()
                .fechaYHora(date)
                .odontologo(o1)
                .paciente(p1)
                .build();

        turnoRepository.save(t1);

        logger.info("*** Fin del proceso **** ");
    }
}
