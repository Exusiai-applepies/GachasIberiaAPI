package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.Eidolon;

import java.util.List;

public interface EidolonService {
    // RETRIEVE
    List<Eidolon> findAll();
    List<Eidolon> findByNombre(String nombre);

    // CREATE / UPDATE
    Eidolon save(Eidolon eidolon);

    // DELETE
    int deleteByNombre(String nombre);
}
