package com.example.CRUD.repositorios;
import com.example.CRUD.entidades.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnterpriseRepositorio extends JpaRepository<Enterprise, UUID> {
}

