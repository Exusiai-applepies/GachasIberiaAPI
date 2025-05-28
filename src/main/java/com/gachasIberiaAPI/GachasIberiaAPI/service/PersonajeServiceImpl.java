package com.gachasIberiaAPI.GachasIberiaAPI.service;


import com.gachasIberiaAPI.GachasIberiaAPI.entity.StarrailPersonaje;
import com.gachasIberiaAPI.GachasIberiaAPI.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    private final PersonajeRepository repository;

    public PersonajeServiceImpl(PersonajeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StarrailPersonaje> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<StarrailPersonaje> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public StarrailPersonaje save(StarrailPersonaje starrailPersonaje) {
        this.repository.save(starrailPersonaje);
        return starrailPersonaje;
    }

    @Override
    public int deleteByNombre(String nombre) {
        StarrailPersonaje encuentro = this.repository.findByNombre(nombre).get(0);
        if (encuentro.getVida()!=0) {
            this.repository.delete(encuentro);
            return 0;
        }else{
            return -1;
        }
    }
}
