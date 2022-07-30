package com.example.clinica.service;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.PacienteDTO;
import com.example.clinica.modelo.entity.Paciente;
import com.example.clinica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    private final PacienteRepository pacienteRepository;
    private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Autowired
    ObjectMapper mapper;


    @Override
    public Optional<Paciente> agregar(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        paciente.setFechaDeAlta(timestamp);
        return Optional.of(pacienteRepository.save(paciente));
    }

    @Override
    public Optional<Paciente> modificar(PacienteDTO pacienteDTO) throws ResourceNotFoundException{
        PacienteDTO pacienteDTOoriginal = buscarPorId(pacienteDTO.getIdPaciente());
        Paciente pacienteOriginal = mapper.convertValue(pacienteDTOoriginal, Paciente.class);
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        paciente.setFechaDeAlta(pacienteOriginal.getFechaDeAlta());
        return Optional.of(pacienteRepository.save(paciente));
    }

    @Override
    public Set<PacienteDTO> listarTodos(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOs = new HashSet<>();

        for  (Paciente paciente: pacientes){
            PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            String fecha = sdf3.format(paciente.getFechaDeAlta());
            pacienteDTO.setFechaDeAlta(fecha);
            pacienteDTOs.add(pacienteDTO);
        }
        return pacienteDTOs;
    }

    @Override
    public PacienteDTO buscarPorId(Long id) throws ResourceNotFoundException{
        PacienteDTO pacienteDTO = null;
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }else {
            throw new ResourceNotFoundException("No existe un Paciente con el id: " + id);
        }
        return pacienteDTO;

    }

    @Override
    public void eliminarPorId(Long id) throws ResourceNotFoundException{
        if(buscarPorId(id)!=null)
            pacienteRepository.deleteById(id);
    }


}
