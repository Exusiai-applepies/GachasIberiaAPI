package com.gachasiberiaapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "starrail_personajes")
public class StarrailPersonaje {

    @Id
    @Column(name = "nombre")
    private String nombre;

    private int vida;
    private String escaladoVida;
    private int ataque;
    private String escaladoAtaque;
    private int defensa;
    private String escaladoDefensa;
    private String via;
    private int rareza;
    private int velocidad;
    private String elemento;
    private String imagen;
    private String descripcion;
    private int provocacion;
    private String historia;
    private String galeria;

    @OneToOne(mappedBy = "personaje", cascade = CascadeType.ALL)
    private Eidolon eidolon;

    public StarrailPersonaje() {
    }

    public StarrailPersonaje(String nombre, int vida, String escaladoVida, int ataque, String escaladoAtaque, int defensa, String escaladoDefensa, String via, int velocidad, int rareza, String elemento, String imagen, String descripcion, int provocacion, String historia, String galeria) {
        this.nombre = nombre;
        this.vida = vida;
        this.escaladoVida = escaladoVida;
        this.ataque = ataque;
        this.escaladoAtaque = escaladoAtaque;
        this.defensa = defensa;
        this.escaladoDefensa = escaladoDefensa;
        this.via = via;
        this.velocidad = velocidad;
        this.rareza = rareza;
        this.elemento = elemento;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.provocacion = provocacion;
        this.historia = historia;
        this.galeria = galeria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getEscaladoVida() {
        return escaladoVida;
    }

    public void setEscaladoVida(String escaladoVida) {
        this.escaladoVida = escaladoVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public String getEscaladoAtaque() {
        return escaladoAtaque;
    }

    public void setEscaladoAtaque(String escaladoAtaque) {
        this.escaladoAtaque = escaladoAtaque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getEscaladoDefensa() {
        return escaladoDefensa;
    }

    public void setEscaladoDefensa(String escaladoDefensa) {
        this.escaladoDefensa = escaladoDefensa;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getRareza() {
        return rareza;
    }

    public void setRareza(int rareza) {
        this.rareza = rareza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getProvocacion() {
        return provocacion;
    }

    public void setProvocacion(int provocacion) {
        this.provocacion = provocacion;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getGaleria() {
        return galeria;
    }

    public void setGaleria(String galeria) {
        this.galeria = galeria;
    }
}
