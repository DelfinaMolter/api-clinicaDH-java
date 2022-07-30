package com.example.clinica.service;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.TurnoDTO;
import com.example.clinica.modelo.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    Optional<Turno> agregar(TurnoDTO turnoDTO)throws ResourceNotFoundException;
    Optional<Turno> modificar(TurnoDTO turnoDTO) throws ResourceNotFoundException;
    List<TurnoDTO> listarTodos();
    TurnoDTO buscarPorId(Long id) throws ResourceNotFoundException;
    void eliminarPorId(Long id)throws ResourceNotFoundException;
}
