package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.RastrosStarrail;
import com.gachasiberiaapi.repository.RastrosRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RastrosServiceImpl implements RastrosService{

    @PersistenceContext
    private EntityManager entityManager;

    private final RastrosRepository repository;


    public RastrosServiceImpl(RastrosRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RastrosStarrail> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<RastrosStarrail> findByNombre(String nombre) {
        return this.repository.findByNombrePersonaje(nombre);
    }

    @Override
    public RastrosStarrail save(RastrosStarrail rastrosStarrail) {
        this.repository.save(rastrosStarrail);
        return rastrosStarrail;
    }

    @Override
    @Transactional
    public int deleteByNombre(String nombre) {
        int deletedCount = repository.deleteByNombrePersonaje(nombre);
        System.out.println("Registros borrados: " + deletedCount);
        return deletedCount > 0 ? 1 : -1;
    }
}
