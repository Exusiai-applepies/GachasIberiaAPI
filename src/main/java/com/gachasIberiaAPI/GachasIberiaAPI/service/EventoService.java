package com.gachasIberiaAPI.GachasIberiaAPI.service;

import com.gachasIberiaAPI.GachasIberiaAPI.entity.Evento;

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
