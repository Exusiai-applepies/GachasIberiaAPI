package com.gachasIberiaAPI.GachasIberiaAPI.service;

import com.gachasIberiaAPI.GachasIberiaAPI.entity.Eidolon;

import java.util.List;
import java.util.Optional;

public interface EidolonService {
    // RETRIEVE
    List<Eidolon> findAll();
    List<Eidolon> findByNombre(String nombre);

    // CREATE / UPDATE
    Eidolon save(Eidolon eidolon);

    // DELETE
    int deleteByNombre(String nombre);
}
