package com.gachasiberiaapi.service;


import com.gachasiberiaapi.entity.Artefacto;
import com.gachasiberiaapi.repository.ArtefactoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtefactoServiceImpl implements ArtefactoService{

    private final ArtefactoRepository repository;

    public ArtefactoServiceImpl(ArtefactoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artefacto> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Artefacto> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public Artefacto save(Artefacto artefacto) {
        this.repository.save(artefacto);
        return artefacto;
    }

    @Override
    public int deleteByNombre(String nombre) {
        Artefacto encuentro = this.repository.findByNombre(nombre).get(0);
        if (!encuentro.getNombre().isBlank()) {
            this.repository.delete(encuentro);
            return 0;
        }else{
            return -1;
        }
    }
}
