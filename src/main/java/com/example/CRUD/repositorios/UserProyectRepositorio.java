package com.example.CRUD.repositorios;

import com.example.CRUD.entidades.UserProyect;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserProyectRepositorio extends JpaRepository<UserProyect, UUID> {
}
