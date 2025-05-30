package com.gachasiberiaapi.repository;


import com.gachasiberiaapi.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {
    List<Juego> findByNombre(String nombre);
}
