package com.gachasIberiaAPI.GachasIberiaAPI.service;

import com.gachasIberiaAPI.GachasIberiaAPI.entity.HabilidadStarrail;
import com.gachasIberiaAPI.GachasIberiaAPI.repository.HabilidadRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadServiceImpl implements HabilidadService{

    @PersistenceContext
    private EntityManager entityManager;

    private final HabilidadRepository repository;


    public HabilidadServiceImpl(HabilidadRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HabilidadStarrail> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<HabilidadStarrail> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public HabilidadStarrail save(HabilidadStarrail habilidadStarrail) {
        this.repository.save(habilidadStarrail);
        return habilidadStarrail;
    }

    @Override
    @Transactional
    public int deleteByNombre(String nombre) {
        int deletedCount = repository.deleteByNombre(nombre);
        System.out.println("Registros borrados: " + deletedCount);
        return deletedCount > 0 ? 1 : -1;
    }
}
