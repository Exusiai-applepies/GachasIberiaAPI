package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.Evento;

import java.util.List;

public interface EventoService {
    // RETRIEVE
    List<Evento> findAll();
    List<Evento> findByNombre(String nombre);

    // CREATE / UPDATE
    Evento save(Evento evento);

    // DELETE
    int deleteByNombre(String nombre);
}
