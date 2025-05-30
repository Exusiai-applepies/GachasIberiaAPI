package com.gachasiberiaapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "habilidades_starrail")
public class HabilidadStarrail {

    @Id
    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "nombre", insertable = false, updatable = false)
    private StarrailPersonaje personaje;

    private String nombreAtaqueBasico;
    private String descripcionAtaqueBasico;
    private String nombreHabilidadBasica;
    private String descripcionHabilidadBasico;
    private String nombreDefinitiva;
    private String descripcionDefinitiva;
    private String nombreTalento;
    private String descripcionTalento;
    private String nombreTecnica;
    private String descripcionTecnica;
    private String rupturaBasico;
    private String rupturaHabilidad;
    private String rupturaDefinitiva;
    private String tipoTalento;
    private String rupturaTecnica;

    @Version
    private Long version;

    public HabilidadStarrail() {
    }

    public HabilidadStarrail(StarrailPersonaje personaje, String nombre, String nombreAtaqueBasico, String descripcionAtaqueBasico, String nombreHabilidadBasica, String descripcionHabilidadBasico, String nombreDefinitiva, String descripcionDefinitiva, String nombreTalento, String descripcionTalento, String nombreTecnica, String descripcionTecnica, String rupturaBasico, String rupturaHabilidad, String rupturaDefinitiva, String tipoTalento, String rupturaTecnica) {
        this.personaje = personaje;
        this.nombre = nombre;
        this.nombreAtaqueBasico = nombreAtaqueBasico;
        this.descripcionAtaqueBasico = descripcionAtaqueBasico;
        this.nombreHabilidadBasica = nombreHabilidadBasica;
        this.descripcionHabilidadBasico = descripcionHabilidadBasico;
        this.nombreDefinitiva = nombreDefinitiva;
        this.descripcionDefinitiva = descripcionDefinitiva;
        this.nombreTalento = nombreTalento;
        this.descripcionTalento = descripcionTalento;
        this.nombreTecnica = nombreTecnica;
        this.descripcionTecnica = descripcionTecnica;
        this.rupturaBasico = rupturaBasico;
        this.rupturaHabilidad = rupturaHabilidad;
        this.rupturaDefinitiva = rupturaDefinitiva;
        this.tipoTalento = tipoTalento;
        this.rupturaTecnica = rupturaTecnica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public StarrailPersonaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(StarrailPersonaje personaje) {
        this.personaje = personaje;
    }

    public String getNombreAtaqueBasico() {
        return nombreAtaqueBasico;
    }

    public void setNombreAtaqueBasico(String nombreAtaqueBasico) {
        this.nombreAtaqueBasico = nombreAtaqueBasico;
    }

    public String getDescripcionAtaqueBasico() {
        return descripcionAtaqueBasico;
    }

    public void setDescripcionAtaqueBasico(String descripcionAtaqueBasico) {
        this.descripcionAtaqueBasico = descripcionAtaqueBasico;
    }

    public String getdescripcionHabilidadBasico() {
        return descripcionHabilidadBasico;
    }

    public void setdescripcionHabilidadBasico(String descripcionHabilidadBasico) {
        this.descripcionHabilidadBasico = descripcionHabilidadBasico;
    }

    public String getNombreHabilidadBasica() {
        return nombreHabilidadBasica;
    }

    public void setNombreHabilidadBasica(String nombreHabilidadBasica) {
        this.nombreHabilidadBasica = nombreHabilidadBasica;
    }

    public String getNombreDefinitiva() {
        return nombreDefinitiva;
    }

    public void setNombreDefinitiva(String nombreDefinitiva) {
        this.nombreDefinitiva = nombreDefinitiva;
    }

    public String getDescripcionDefinitiva() {
        return descripcionDefinitiva;
    }

    public void setDescripcionDefinitiva(String descripcionDefinitiva) {
        this.descripcionDefinitiva = descripcionDefinitiva;
    }

    public String getNombreTalento() {
        return nombreTalento;
    }

    public void setNombreTalento(String nombreTalento) {
        this.nombreTalento = nombreTalento;
    }

    public String getDescripcionTalento() {
        return descripcionTalento;
    }

    public void setDescripcionTalento(String descripcionTalento) {
        this.descripcionTalento = descripcionTalento;
    }

    public String getNombreTecnica() {
        return nombreTecnica;
    }

    public void setNombreTecnica(String nombreTecnica) {
        this.nombreTecnica = nombreTecnica;
    }

    public String getDescripcionTecnica() {
        return descripcionTecnica;
    }

    public void setDescripcionTecnica(String descripcionTecnica) {
        this.descripcionTecnica = descripcionTecnica;
    }

    public String getRupturaBasico() {
        return rupturaBasico;
    }

    public void setRupturaBasico(String rupturaBasico) {
        this.rupturaBasico = rupturaBasico;
    }

    public String getRupturaHabilidad() {
        return rupturaHabilidad;
    }

    public void setRupturaHabilidad(String rupturaHabilidad) {
        this.rupturaHabilidad = rupturaHabilidad;
    }

    public String getRupturaDefinitiva() {
        return rupturaDefinitiva;
    }

    public void setRupturaDefinitiva(String rupturaDefinitiva) {
        this.rupturaDefinitiva = rupturaDefinitiva;
    }

    public String getTipoTalento() {
        return tipoTalento;
    }

    public void setTipoTalento(String tipoTalento) {
        this.tipoTalento = tipoTalento;
    }

    public String getRupturaTecnica() {
        return rupturaTecnica;
    }

    public void setRupturaTecnica(String rupturaTecnica) {
        this.rupturaTecnica = rupturaTecnica;
    }
}

