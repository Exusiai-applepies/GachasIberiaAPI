package com.gachasiberiaapi.repository;

import com.gachasiberiaapi.entity.HabilidadStarrail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadRepository extends JpaRepository<HabilidadStarrail, String> {
    List<HabilidadStarrail> findByNombre(String nombre);
    @Transactional
    @Modifying
    @Query("DELETE FROM HabilidadStarrail e WHERE e.nombre = :nombre")
    int deleteByNombre(@Param("nombre") String nombre);
}
