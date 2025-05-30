package com.gachasiberiaapi.service;

import com.gachasiberiaapi.entity.Eidolon;
import com.gachasiberiaapi.repository.EidolonRepository;
import com.gachasiberiaapi.repository.PersonajeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EidolonServiceImpl implements EidolonService{

    @PersistenceContext
    private EntityManager entityManager;

    private final EidolonRepository repository;
    private final PersonajeRepository prepository;


    public EidolonServiceImpl(EidolonRepository repository, PersonajeRepository prepository) {
        this.repository = repository;
        this.prepository = prepository;
    }

    @Override
    public List<Eidolon> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Eidolon> findByNombre(String nombre) {
        return this.repository.findByNombrePersonaje(nombre);
    }

    @Override
    public Eidolon save(Eidolon eidolon) {
        this.repository.save(eidolon);
        return eidolon;
    }

    /*@Override
    public int deleteByNombre(String nombre) {
        List<Eidolon> resultados = this.repository.findByNombrePersonaje(nombre);
        if (!resultados.isEmpty()) {
            this.repository.delete(resultados.get(0));
            return 1;
        } else {
            return 0;
        }
    }*/

    @Override
    @Transactional
    public int deleteByNombre(String nombre) {
        int deletedCount = repository.deleteByNombrePersonaje(nombre);
        System.out.println("Registros borrados: " + deletedCount);
        return deletedCount > 0 ? 1 : -1;
    }
}
