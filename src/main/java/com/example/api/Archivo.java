/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
