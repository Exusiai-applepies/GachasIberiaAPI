package com.gachasIberiaAPI.GachasIberiaAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "esfera")
public class Esfera {

    @Id
    private String nombre;

    private String bonus;

    @Column(name = "imagen_esfera")
    private String imagenEsfera;

    @Column(name = "imagen_cuerda")
    private String imagenCuerda;

    public Esfera() {
    }

    public Esfera(String nombre, String bonus, String imagenEsfera, String imagenCuerda) {
        this.nombre = nombre;
        this.bonus = bonus;
        this.imagenEsfera = imagenEsfera;
        this.imagenCuerda = imagenCuerda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getImagenEsfera() {
        return imagenEsfera;
    }

    public void setImagenEsfera(String imagenEsfera) {
        this.imagenEsfera = imagenEsfera;
    }

    public String getImagenCuerda() {
        return imagenCuerda;
    }

    public void setImagenCuerda(String imagenCuerda) {
        this.imagenCuerda = imagenCuerda;
    }
}

