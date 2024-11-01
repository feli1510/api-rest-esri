package com.example.CRUD.controladores;

import com.example.CRUD.entidades.Enterprise;
import com.example.CRUD.repositorios.EnterpriseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseRepositorio enterpriseRepository;

    @GetMapping
    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> getEnterprise(@PathVariable UUID id) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        return enterprise.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enterprise> updateEnterprise(@PathVariable UUID id, @RequestBody Enterprise enterpriseDetails) {
        Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(id);
        if (enterpriseOptional.isPresent()) {
            Enterprise enterprise = enterpriseOptional.get();
            enterprise.setName(enterpriseDetails.getName());
            enterprise.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            Enterprise updatedEnterprise = enterpriseRepository.save(enterprise);
            return ResponseEntity.ok(updatedEnterprise);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnterprise(@PathVariable UUID id) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        if (enterprise.isPresent()) {
            enterpriseRepository.delete(enterprise.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

