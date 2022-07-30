package com.example.clinica.service;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.PacienteDTO;
import com.example.clinica.modelo.entity.Paciente;

import java.util.Optional;
import java.util.Set;

public interface IPacienteService {

    Optional<Paciente> agregar(PacienteDTO pacienteDTO);
    Optional<Paciente> modificar(PacienteDTO pacienteDTO) throws ResourceNotFoundException;

    Set<PacienteDTO> listarTodos();
    PacienteDTO buscarPorId(Long id)throws ResourceNotFoundException;
    void eliminarPorId(Long id) throws ResourceNotFoundException;
}
