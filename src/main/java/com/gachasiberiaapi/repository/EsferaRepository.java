package com.gachasiberiaapi.repository;

import com.gachasiberiaapi.entity.Esfera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsferaRepository extends JpaRepository<Esfera, Long> {
    List<Esfera> findByNombre(String nombre);
}
