/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author kamh1
 */
@Entity
@Table(name = "Persona")
@EntityListeners(AuditingEntityListener.class)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPersona;

    @Column(name = "Nombres", nullable = false)
    private String Nombres;

    @Column(name = "ApellidoPaterno", nullable = false)
    private String ApellidoPaterno;

    @Column(name = "ApellidoMaterno", nullable = false)
    private String ApellidoMaterno;

    @Column(name = "Direccion", nullable = false)
    private String Direccion;

    public Persona( String Nombres, String ApellidoPaterno, String ApellidoMaterno, String Direccion) {
        this.Nombres = Nombres;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Direccion = Direccion;
    }
    
    public long getId() {
        return idPersona;
    }

    public void setId(long id) {
        this.idPersona = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
}
