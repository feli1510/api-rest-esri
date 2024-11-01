package com.example.CRUD.repositorios;

import com.example.CRUD.entidades.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProjectRepositorio extends JpaRepository<Project, UUID> {
}

