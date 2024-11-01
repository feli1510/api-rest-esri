package com.example.CRUD.entidades;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class UserProyect {
    @Id
    @GeneratedValue
    private UUID userProjectId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public UUID getUserProjectId() {
        return userProjectId;
    }

    public void setUserProjectId(UUID userProjectId) {
        this.userProjectId = userProjectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
