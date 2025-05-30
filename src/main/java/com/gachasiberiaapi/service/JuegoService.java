package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.Juego;

import java.util.List;

public interface JuegoService {
    // RETRIEVE
    List<Juego> findAll();
    List<Juego> findByNombre(String nombre);

    // CREATE / UPDATE
    Juego save(Juego juego);

    // DELETE
    int deleteByNombre(String nombre);
}
