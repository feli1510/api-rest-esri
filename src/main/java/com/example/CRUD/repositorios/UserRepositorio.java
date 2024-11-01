package com.example.CRUD.repositorios;

import com.example.CRUD.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepositorio extends JpaRepository<User, UUID> {
}
