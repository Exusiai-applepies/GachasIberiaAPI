package com.gachasiberiaapi.repository;


import com.gachasiberiaapi.entity.StarrailPersonaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<StarrailPersonaje, Long> {
    List<StarrailPersonaje> findByNombre(String nombre);
}
