/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kamh1
 */
@Controller
@RequestMapping("/api/v1")
public class PersonaController {
    
  private PersonaRepository personaRepository;
  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping(path = "/personas")
  public @ResponseBody Iterable<Persona> getAllPersonas() {
    return personaRepository.findAll();
  }
  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   
  @GetMapping("/personas/{id}")
  public ResponseEntity<Persona> getPersonaById(@PathVariable(value = "id") Long personaId{
    throws ResourceNotFoundException {
    Persona persona =
        personaRepository
            .findById(personaId)
            .orElseThrow(() -> new ResourceNotFoundException("Persona not found on :: " + personaId));
    return ResponseEntity.ok().body(persona);
    }
  }
  */
  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/personas")
  public @ResponseBody String createPersona(@RequestParam String Nombres, @RequestParam String ApellidoPaterno,@RequestParam String ApellidoMaterno,@RequestParam String Direccion) {
    Persona n = new Persona();
    n.setNombres(Nombres);
    n.setApellidoPaterno(ApellidoPaterno);
    n.setApellidoMaterno(ApellidoMaterno);
    n.setDireccion(Direccion);
    personaRepository.save(n);
    return "Usuario guardado ";
  }
  /**
  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   
  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
      throws ResourceNotFoundException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    user.setUpdatedAt(new Date());
    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }
  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   
  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;  
    */
}