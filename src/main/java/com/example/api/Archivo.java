/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author kamh1
 */
@Entity
@Table(name = "Archivo")
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_archivo;
    
    @Column(name = "Nombre", nullable = false)
    private String Nombre;
    
    @Column(name = "FechaCarga", nullable = false)
    private String FechaCarga;
    
    @Column(name = "FechaInicio", nullable = false)
    private String FechaInicio;
    
    @Column(name = "FechaFin", nullable = false)
    private String FechaFin;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona")
    private Persona persona;

    public Archivo(long id_archivo, String Nombre, String FechaCarga, String FechaInicio, String FechaFin, Persona persona) {
        this.id_archivo = id_archivo;
        this.Nombre = Nombre;
        this.FechaCarga = FechaCarga;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.persona = persona;
    }

    public long getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(long id_archivo) {
        this.id_archivo = id_archivo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFechaCarga() {
        return FechaCarga;
    }

    public void setFechaCarga(String FechaCarga) {
        this.FechaCarga = FechaCarga;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }
    
}
