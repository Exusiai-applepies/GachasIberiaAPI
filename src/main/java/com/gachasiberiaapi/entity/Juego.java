package com.gachasiberiaapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "juegos")
public class Juego {
    @Id
    @Column(name = "Nombre", nullable = false, length = 255)
    private String nombre;

    private String Historia;

    public Juego() {
    }

    public Juego(String nombre, String historia) {
        this.nombre = nombre;
        this.Historia = historia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHistoria() {
        return Historia;
    }

    public void setHistoria(String historia) {
        Historia = historia;
    }
}
