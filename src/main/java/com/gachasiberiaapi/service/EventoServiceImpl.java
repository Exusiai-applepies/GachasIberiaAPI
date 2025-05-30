package com.gachasiberiaapi.service;


import com.gachasiberiaapi.entity.Evento;
import com.gachasiberiaapi.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService{

    private final EventoRepository repository;

    public EventoServiceImpl(EventoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Evento> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Evento> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public Evento save(Evento evento) {
        this.repository.save(evento);
        return evento;
    }

    @Override
    public int deleteByNombre(String nombre) {
        Evento encuentro = this.repository.findByNombre(nombre).get(0);
        if (!encuentro.getNombre().isBlank()) {
            this.repository.delete(encuentro);
            return 0;
        }else{
            return -1;
        }
    }
}
