package com.example.clinica.controller;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.PacienteDTO;
import com.example.clinica.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/paciente")
public class PacienteController {
    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<HttpStatus> agregar(@RequestBody PacienteDTO pacienteDTO){
        ResponseEntity<HttpStatus> respuesta;
        if(pacienteService.agregar(pacienteDTO).isPresent()){
            respuesta = ResponseEntity.ok(HttpStatus.CREATED);
            logger.info("Se creo un paciente");
        }else{
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            logger.error("No se pudo crear el paciente");
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<HttpStatus> modificar(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException{
        pacienteService.modificar(pacienteDTO);
        logger.info("Se modifico el paciente con id " + pacienteDTO.getIdPaciente());
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping
    public Collection<PacienteDTO> listarTodos(){
        logger.info("Se lista todos los pacientes");
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id)throws ResourceNotFoundException{
        logger.info("Se muestra el paciente con id " + id);
        return ResponseEntity.ok(pacienteService.buscarPorId(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPorId(id);
        logger.info("Se borro el paciente con id " + id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
