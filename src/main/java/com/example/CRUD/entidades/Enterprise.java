package com.example.CRUD.entidades;

import jakarta.persistence.*;


import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Enterprise {
    @Id
    @GeneratedValue
    private UUID enterpriseId;


        private String name;
        private Timestamp createdAt;
        private Timestamp updatedAt;

        @PrePersist
        protected void onCreate() {
            createdAt = new Timestamp(System.currentTimeMillis());
        }

        @PreUpdate
        protected void onUpdate() {
            updatedAt = new Timestamp(System.currentTimeMillis());
        }


    public UUID getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(UUID enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}




