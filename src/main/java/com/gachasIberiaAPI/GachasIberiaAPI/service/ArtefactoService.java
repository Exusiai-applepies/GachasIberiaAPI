package com.gachasIberiaAPI.GachasIberiaAPI.service;

import com.gachasIberiaAPI.GachasIberiaAPI.entity.Artefacto;

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
