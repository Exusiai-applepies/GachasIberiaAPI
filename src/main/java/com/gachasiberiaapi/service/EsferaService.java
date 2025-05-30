package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.Esfera;

import java.util.List;

public interface EsferaService {
    // RETRIEVE
    List<Esfera> findAll();
    List<Esfera> findByNombre(String nombre);

    // CREATE / UPDATE
    Esfera save(Esfera esfera);

    // DELETE
    int deleteByNombre(String nombre);
}
