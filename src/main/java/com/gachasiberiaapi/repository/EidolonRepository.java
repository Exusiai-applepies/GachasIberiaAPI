package com.gachasiberiaapi.repository;

import com.gachasiberiaapi.entity.Eidolon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EidolonRepository extends JpaRepository<Eidolon, String> {
    List<Eidolon> findByNombrePersonaje(String nombre);
    @Transactional
    @Modifying
    @Query("DELETE FROM Eidolon e WHERE e.nombrePersonaje = :nombre")
    int deleteByNombrePersonaje(@Param("nombre") String nombre);
}
