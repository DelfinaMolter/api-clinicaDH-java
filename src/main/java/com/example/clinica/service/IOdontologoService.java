package com.example.clinica.service;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.OdontologoDTO;
import com.example.clinica.modelo.entity.Odontologo;

import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {

    Optional<Odontologo> agregar(OdontologoDTO odontologoDTO);
    Optional<Odontologo> modificar(OdontologoDTO odontologoDTO) throws ResourceNotFoundException;
    Set<OdontologoDTO> listarTodos();
    OdontologoDTO buscarPorId(Long id)throws ResourceNotFoundException;
    OdontologoDTO buscarPorNombre(String nombre);
    void eliminarPorId(Long id) throws ResourceNotFoundException;


}
