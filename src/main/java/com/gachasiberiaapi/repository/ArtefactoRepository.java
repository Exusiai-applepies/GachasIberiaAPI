package com.gachasiberiaapi.repository;


import com.gachasiberiaapi.entity.Artefacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtefactoRepository extends JpaRepository<Artefacto, Long> {
    List<Artefacto> findByNombre(String nombre);
}
