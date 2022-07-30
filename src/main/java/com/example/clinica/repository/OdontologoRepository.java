package com.example.clinica.repository;

import com.example.clinica.modelo.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("SELECT o FROM Odontologo o where o.nombre = ?1")
    Optional<Odontologo> buscarPorNombre(String nombre);
}
