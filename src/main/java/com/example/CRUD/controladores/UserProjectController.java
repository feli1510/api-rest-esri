package com.example.CRUD.controladores;

import com.example.CRUD.entidades.UserProyect;
import com.example.CRUD.repositorios.UserProyectRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/userprojects")
public class UserProjectController {

    @Autowired
    private UserProyectRepositorio userProjectRepository;

    // Obtener todos los user-projects
    @GetMapping
    public List<UserProyect> getAllUserProjects() {
        return userProjectRepository.findAll();
    }

    // Obtener un user-project por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProyect> getUserProjectById(@PathVariable UUID id) {
        Optional<UserProyect> userProject = userProjectRepository.findById(id);
        return userProject.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Crear un nuevo user-project
    @PostMapping
    public UserProyect createUserProject(@RequestBody UserProyect userProject) {
        return userProjectRepository.save(userProject);
    }

    // Actualizar un user-project existente
    @PutMapping("/{id}")
    public ResponseEntity<UserProyect> updateUserProject(@PathVariable UUID id, @RequestBody UserProyect userProjectDetails) {
        Optional<UserProyect> userProjectOptional = userProjectRepository.findById(id);
        if (userProjectOptional.isPresent()) {
            UserProyect userProject = userProjectOptional.get();
            userProject.setUser(userProjectDetails.getUser());
            UserProyect updatedUserProject = userProjectRepository.save(userProject);
            return ResponseEntity.ok(updatedUserProject);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Eliminar un user-project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProject(@PathVariable UUID id) {
        Optional<UserProyect> userProject = userProjectRepository.findById(id);
        if (userProject.isPresent()) {
            userProjectRepository.delete(userProject.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
