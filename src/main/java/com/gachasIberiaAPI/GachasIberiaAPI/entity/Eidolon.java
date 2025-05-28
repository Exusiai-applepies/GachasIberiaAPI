package com.gachasIberiaAPI.GachasIberiaAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "eidolon")
public class Eidolon {

    @Id
    @Column(name = "nombre_personaje")
    private String nombrePersonaje;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "nombre_personaje")
    private StarrailPersonaje personaje;

    private String e1;
    private String e2;
    private String e3;
    private String e4;
    private String e5;
    private String e6;

    @Version
    private Long version;

    public Eidolon() {
    }

    public Eidolon(String nombrePersonaje, StarrailPersonaje personaje, String e1, String e2, String e3, String e4, String e5, String e6) {
        this.nombrePersonaje = nombrePersonaje;
        this.personaje = personaje;
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.e4 = e4;
        this.e5 = e5;
        this.e6 = e6;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getE1() {
        return e1;
    }

    public void setE1(String e1) {
        this.e1 = e1;
    }

    public StarrailPersonaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(StarrailPersonaje personaje) {
        this.personaje = personaje;
    }

    public String getE2() {
        return e2;
    }

    public void setE2(String e2) {
        this.e2 = e2;
    }

    public String getE3() {
        return e3;
    }

    public void setE3(String e3) {
        this.e3 = e3;
    }

    public String getE4() {
        return e4;
    }

    public void setE4(String e4) {
        this.e4 = e4;
    }

    public String getE5() {
        return e5;
    }

    public void setE5(String e5) {
        this.e5 = e5;
    }

    public String getE6() {
        return e6;
    }

    public void setE6(String e6) {
        this.e6 = e6;
    }
}

