package com.gachasIberiaAPI.GachasIberiaAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "artefactos")
public class Artefacto {

    @Id
    private String nombre;

    @Column(name = "set_2")
    private String set2;

    @Lob
    @Column(name = "set_4", columnDefinition = "TEXT")
    private String set4;

    private String cabeza;
    private String brazos;
    private String cuerpo;
    private String botas;

    public Artefacto() {
    }

    public Artefacto(String nombre, String set4, String set2, String cabeza, String brazos, String cuerpo, String botas) {
        this.nombre = nombre;
        this.set4 = set4;
        this.set2 = set2;
        this.cabeza = cabeza;
        this.brazos = brazos;
        this.cuerpo = cuerpo;
        this.botas = botas;
    }

    public String getSet2() {
        return set2;
    }

    public void setSet2(String set2) {
        this.set2 = set2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSet4() {
        return set4;
    }

    public void setSet4(String set4) {
        this.set4 = set4;
    }

    public String getCabeza() {
        return cabeza;
    }

    public void setCabeza(String cabeza) {
        this.cabeza = cabeza;
    }

    public String getBrazos() {
        return brazos;
    }

    public void setBrazos(String brazos) {
        this.brazos = brazos;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getBotas() {
        return botas;
    }

    public void setBotas(String botas) {
        this.botas = botas;
    }
}

