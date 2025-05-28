package com.gachasIberiaAPI.GachasIberiaAPI.service;


import com.gachasIberiaAPI.GachasIberiaAPI.entity.Esfera;
import com.gachasIberiaAPI.GachasIberiaAPI.repository.EsferaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsferaServiceImpl implements EsferaService{

    private final EsferaRepository repository;

    public EsferaServiceImpl(EsferaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Esfera> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Esfera> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public Esfera save(Esfera esfera) {
        this.repository.save(esfera);
        return esfera;
    }

    @Override
    public int deleteByNombre(String nombre) {
        Esfera encuentro = this.repository.findByNombre(nombre).get(0);
        if (!encuentro.getNombre().isBlank()) {
            this.repository.delete(encuentro);
            return 0;
        }else{
            return -1;
        }
    }
}
