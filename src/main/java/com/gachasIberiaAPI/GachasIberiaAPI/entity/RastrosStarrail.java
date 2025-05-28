package com.gachasIberiaAPI.GachasIberiaAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "rastros_starrail")
public class RastrosStarrail {

    @Id
    @Column(name = "nombre_personaje")
    private String nombrePersonaje;

    @OneToOne
    @JoinColumn(name = "nombre_personaje", insertable = false, updatable = false)
    private StarrailPersonaje personaje;

    @Column(name = "Rastro_1")
    private String rastro1;

    @Column(name = "Rastro_2")
    private String rastro2;

    @Column(name = "Rastro_3")
    private String rastro3;

    @Column(name = "Rastro_4")
    private String rastro4;

    @Version
    private Long version;

    public RastrosStarrail() {
    }

    public RastrosStarrail(String nombrePersonaje, StarrailPersonaje personaje, String rastro1, String rastro2, String rastro3, String rastro4) {
        this.nombrePersonaje = nombrePersonaje;
        this.personaje = personaje;
        this.rastro1 = rastro1;
        this.rastro2 = rastro2;
        this.rastro3 = rastro3;
        this.rastro4 = rastro4;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public StarrailPersonaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(StarrailPersonaje personaje) {
        this.personaje = personaje;
    }

    public String getRastro1() {
        return rastro1;
    }

    public void setRastro1(String rastro1) {
        this.rastro1 = rastro1;
    }

    public String getRastro2() {
        return rastro2;
    }

    public void setRastro2(String rastro2) {
        this.rastro2 = rastro2;
    }

    public String getRastro3() {
        return rastro3;
    }

    public void setRastro3(String rastro3) {
        this.rastro3 = rastro3;
    }

    public String getRastro4() {
        return rastro4;
    }

    public void setRastro4(String rastro4) {
        this.rastro4 = rastro4;
    }
}

