package com.example.clinica.controller;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.OdontologoDTO;
import com.example.clinica.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/odontologo")
public class OdontologoController {

    private static final Logger logger = Logger.getLogger(OdontologoController.class);
    @Autowired
    private IOdontologoService odontologoService;


    @PostMapping
    public ResponseEntity<HttpStatus> agregar(@RequestBody OdontologoDTO odontologoDTO){
        ResponseEntity<HttpStatus> respuesta;
        if(odontologoService.agregar(odontologoDTO).isPresent()){
            respuesta = ResponseEntity.ok(HttpStatus.CREATED);
            logger.info("Se creo un odontologo");
        }else{
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            logger.error("No se pudo crear el odontologo");
        }
        return respuesta;
    }


    @PutMapping
    public ResponseEntity<HttpStatus> modificar(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        odontologoService.modificar(odontologoDTO);
        logger.info("Se modifico el odontologo con id " + odontologoDTO.getIdOdontologo());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> listarTodos(){
        logger.info("Se lista todos los odontologos");
        return odontologoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Se muestra el odontologo con id " + id);
        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarPorId(id);
        logger.info("Se eliminó el odontologo con id " + id);
        return ResponseEntity.ok("Eliminado");
    }

    @GetMapping("/name={nombre}")
    public ResponseEntity<OdontologoDTO> buscarPorNombre(@PathVariable String nombre){
        logger.info("Se muestra el odontologo con nombre " + nombre);
        return ResponseEntity.ok(odontologoService.buscarPorNombre(nombre));
    }
}
