package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.Artefacto;

import java.util.List;

public interface ArtefactoService {
    // RETRIEVE
    List<Artefacto> findAll();
    List<Artefacto> findByNombre(String nombre);

    // CREATE / UPDATE
    Artefacto save(Artefacto artefacto);

    // DELETE
    int deleteByNombre(String nombre);
}
