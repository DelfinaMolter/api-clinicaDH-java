package com.example.clinica.service;

import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.modelo.dto.OdontologoDTO;
import com.example.clinica.modelo.entity.Odontologo;
import com.example.clinica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Autowired
    ObjectMapper mapper;

    private Optional<Odontologo> guardar(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return Optional.of(odontologoRepository.save(odontologo));
    }

    @Override
    public Optional<Odontologo> agregar(OdontologoDTO odontologoDTO){
        return guardar(odontologoDTO);
    }

    @Override
    public Optional<Odontologo> modificar(OdontologoDTO odontologoDTO)throws ResourceNotFoundException{
        buscarPorId(odontologoDTO.getIdOdontologo());
        return guardar(odontologoDTO);
    }

    @Override
    public Set<OdontologoDTO> listarTodos(){
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOs = new HashSet<>();

        for  (Odontologo odontologo: odontologos){
            odontologoDTOs.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTOs;
    }

    @Override
    public OdontologoDTO buscarPorId(Long id) throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if (odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }else {
            throw new ResourceNotFoundException("No existe un Odontologo con el id: " + id);
        }
        return  odontologoDTO;

    }

    @Override
    public void eliminarPorId(Long id) throws ResourceNotFoundException{
        buscarPorId(id);
        odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDTO buscarPorNombre(String nombre){
        Optional<Odontologo> odontologo = odontologoRepository.buscarPorNombre(nombre);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }



}
