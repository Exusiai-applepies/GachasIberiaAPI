package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.HabilidadStarrail;

import java.util.List;

public interface HabilidadService {
    // RETRIEVE
    List<HabilidadStarrail> findAll();
    List<HabilidadStarrail> findByNombre(String nombre);

    // CREATE / UPDATE
    HabilidadStarrail save(HabilidadStarrail habilidadStarrail);

    // DELETE
    int deleteByNombre(String nombre);
}
