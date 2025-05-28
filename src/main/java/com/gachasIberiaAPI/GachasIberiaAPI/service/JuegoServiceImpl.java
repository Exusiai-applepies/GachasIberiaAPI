package com.gachasIberiaAPI.GachasIberiaAPI.service;


import com.gachasIberiaAPI.GachasIberiaAPI.entity.Juego;
import com.gachasIberiaAPI.GachasIberiaAPI.repository.JuegoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoServiceImpl implements JuegoService{

    private final JuegoRepository repository;

    public JuegoServiceImpl(JuegoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Juego> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Juego> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public Juego save(Juego juego) {
        this.repository.save(juego);
        return juego;
    }

    @Override
    public int deleteByNombre(String nombre) {
        Juego encuentro = this.repository.findByNombre(nombre).get(0);
        if (!encuentro.getNombre().isBlank()) {
            this.repository.delete(encuentro);
            return 0;
        }else{
            return -1;
        }
    }
}
