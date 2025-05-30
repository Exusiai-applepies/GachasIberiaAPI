package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.StarrailPersonaje;
import java.util.List;

public interface PersonajeService {
    // RETRIEVE
    List<StarrailPersonaje> findAll();
    List<StarrailPersonaje> findByNombre(String nombre);

    // CREATE / UPDATE
    StarrailPersonaje save(StarrailPersonaje starrailPersonaje);

    // DELETE
    int deleteByNombre(String nombre);
}
