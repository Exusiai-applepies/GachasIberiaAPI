package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.RastrosStarrail;

import java.util.List;

public interface RastrosService {
    // RETRIEVE
    List<RastrosStarrail> findAll();
    List<RastrosStarrail> findByNombre(String nombre);

    // CREATE / UPDATE
    RastrosStarrail save(RastrosStarrail rastrosStarrail);

    // DELETE
    int deleteByNombre(String nombre);
}
