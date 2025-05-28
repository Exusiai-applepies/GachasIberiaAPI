package com.gachasIberiaAPI.GachasIberiaAPI.repository;


import com.gachasIberiaAPI.GachasIberiaAPI.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByNombre(String nombre);
}
