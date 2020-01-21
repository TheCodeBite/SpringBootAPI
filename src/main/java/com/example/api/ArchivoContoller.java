/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kamh1
 */
@Controller
@RequestMapping("/api/v1")
public class ArchivoContoller {
    private ArchivoRepository archivoRepository;
    
    @GetMapping(path = "/Archivos")
    public @ResponseBody Iterable<Archivo> getAllFiles() {
        return archivoRepository.findAll();
    }
    @PostMapping(path = "/Archivos")
    public @ResponseBody String crearAcrhivo(@RequestParam String Nombre, @RequestParam String FechaCarga, @RequestParam String FechaInicio, @RequestParam String FechaFin){
        Date date = new Date();
        String formatDate = "hh:mm:ss: a";
        DateFormat dateFormat = new SimpleDateFormat(formatDate);
        String today = dateFormat.format(date);
        
        Archivo file = new Archivo(Nombre, FechaCarga, FechaInicio, FechaFin);
        
        
        return "Archivo agregado!";
    }
}
