/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
