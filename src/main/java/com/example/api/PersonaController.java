/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author kamh1
 */
@Controller
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    private static String fileBasePath = System.getProperty("user.dir")+"/src/main/resources/xmlDocumentos/";
    
    @PostMapping("/UploadFile")
    public @ResponseBody String uploadToLocalFileSystem(@RequestParam("file") MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get(fileBasePath + fileName);
        System.out.println("Estamos dentro de esta cosa");
        try{
            Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/downloads/")
                .path(fileName)
                .toUriString();
        
        xmlLoader xml = new xmlLoader(fileBasePath + fileName);
        
        if(!xml.Validador()){
            System.out.println("SE BORRO EL FICHERO PORQUE NO CUMPLE LOS REQUERIMIENTOS NECESARIOS");
            File borraFichero = new File(fileBasePath + fileName);
            borraFichero.delete();
            
            return "No se encontraron todos los campos requeridos verifique su archivo e intentelo de nuevo!! >.<";
            
        }else{
            return "Exito!!!";
        }
    }
    
    @PostMapping("/personas")
    public @ResponseBody String createPersona(@RequestParam String Nombres, @RequestParam String ApellidoPaterno, @RequestParam String ApellidoMaterno, @RequestParam String Direccion, @RequestParam Archivo archivo ) {
        Persona persona = new Persona(Nombres, ApellidoPaterno, ApellidoMaterno, Direccion, archivo);
        System.out.println("la informacion es " + Nombres +  " " + ApellidoPaterno + " " + ApellidoMaterno + " " + Direccion);
        xmlLoader xml = new xmlLoader("hola");
        
        personaRepository.save(persona);
        return "Usuario guardado ";
    }
    
    @GetMapping(path = "/personas")
    public @ResponseBody
    Iterable<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id
     * @return the users by id
     * @throws ResourceNotFoundException the resource not found exception
     *
     * @GetMapping("/personas/{id}") public ResponseEntity<Persona>
     * getPersonaById(@PathVariable(value = "id") Long personaId{ throws
     * ResourceNotFoundException { Persona persona = personaRepository
     * .findById(personaId) .orElseThrow(() -> new
     * ResourceNotFoundException("Persona not found on :: " + personaId));
     * return ResponseEntity.ok().body(persona); } }
     */
    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    
    /**
     * /**
     * Update user response entity.
     *
     * @param userId the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     *
     * @PutMapping("/users/{id}") public ResponseEntity<User> updateUser(
     * @PathVariable(value = "id") Long userId, @Valid @RequestBody User
     * userDetails) throws ResourceNotFoundException { User user =
     * userRepository .findById(userId) .orElseThrow(() -> new
     * ResourceNotFoundException("User not found on :: " + userId));
     * user.setEmail(userDetails.getEmail());
     * user.setLastName(userDetails.getLastName());
     * user.setFirstName(userDetails.getFirstName()); user.setUpdatedAt(new
     * Date()); final User updatedUser = userRepository.save(user); return
     * ResponseEntity.ok(updatedUser); } /** Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     *
     * @DeleteMapping("/user/{id}") public Map<String, Boolean>
     * deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
     * User user = userRepository .findById(userId) .orElseThrow(() -> new
     * ResourceNotFoundException("User not found on :: " + userId));
     * userRepository.delete(user); Map<String, Boolean> response = new
     * HashMap<>(); response.put("deleted", Boolean.TRUE); return response;
     */
}
