package com.example.clinica.controller;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.TurnoDTO;
import com.example.clinica.service.ITurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/turno")
public class TurnoController {

    private static final Logger logger = Logger.getLogger(TurnoController.class);
    @Autowired
    private ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<HttpStatus> agregar(@RequestBody TurnoDTO turnoDTO)throws ResourceNotFoundException{
        turnoService.agregar(turnoDTO);
        logger.info("Se creo un paciente");
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> modificar(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException{
        turnoService.modificar(turnoDTO);
        logger.info("Se modifico el paciente con id " + turnoDTO.getIdTurno());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> listarTodos(){
        logger.info("Se lista todos los pacientes");
        return turnoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Se muestra el paciente con id " + id);
        return ResponseEntity.ok(turnoService.buscarPorId(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable Long id)throws ResourceNotFoundException{
        turnoService.eliminarPorId(id);
        logger.info("Se borro el paciente con id " + id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
