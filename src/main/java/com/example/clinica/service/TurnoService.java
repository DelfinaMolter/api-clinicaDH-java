package com.example.clinica.service;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.TurnoDTO;
import com.example.clinica.modelo.entity.Turno;
import com.example.clinica.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService{
    private final TurnoRepository turnoRepository;
    private final OdontologoService odontologoService;
    private final PacienteService pacienteService;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoRepository = turnoRepository;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    @Autowired
    ObjectMapper mapper;

    private Optional<Turno> guardar(TurnoDTO turnoDTO)throws ResourceNotFoundException{
        odontologoService.buscarPorId(turnoDTO.getOdontologo().getIdOdontologo());
        pacienteService.buscarPorId(turnoDTO.getPaciente().getIdPaciente());
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        return Optional.of(turnoRepository.save(turno));
    }
    @Override
    public Optional<Turno> agregar(TurnoDTO turnoDTO)throws ResourceNotFoundException{
        return guardar(turnoDTO);
    }

    @Override
    public Optional<Turno> modificar(TurnoDTO turnoDTO) throws ResourceNotFoundException{
        buscarPorId(turnoDTO.getIdTurno());
        return guardar(turnoDTO);
    }

    @Override
    public List<TurnoDTO> listarTodos(){
        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoDTO> odontologoDTOs = new ArrayList<>();

        for  (Turno turno: turnos){
            odontologoDTOs.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return odontologoDTOs;
    }

    @Override
    public TurnoDTO buscarPorId(Long id) throws ResourceNotFoundException {
        TurnoDTO turnoDTO = null;
        Optional<Turno> turno = turnoRepository.findById(id);
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }else {
            throw new ResourceNotFoundException("No existe un Turno con el id: " + id);
        }
        return turnoDTO;
    }

    @Override
    public void eliminarPorId(Long id)throws ResourceNotFoundException {
        buscarPorId(id);
        turnoRepository.deleteById(id);
    }
}
