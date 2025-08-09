package com.espgmp.api_employe.controller;

import com.espgmp.api_employe.model.Employe;
import com.espgmp.api_employe.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employe-api/employes")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        Employe created = employeService.createEmploye(employe);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> list = employeService.getAllEmployes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        Employe employe = employeService.getEmployeById(id);
        return ResponseEntity.ok(employe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employeDetails) {
        Employe updated = employeService.updateEmploye(id, employeDetails);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
