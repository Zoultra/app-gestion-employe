package com.espgmp.api_employe.service;

import com.espgmp.api_employe.exceptions.ResourceNotFoundException;
import com.espgmp.api_employe.model.Employe;
import com.espgmp.api_employe.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    // Créer un employé
    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    // Récupérer tous les employés
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    // Récupérer un employé par ID
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employé non trouvé avec l'ID : " + id));
    }

    // Mettre à jour un employé
    public Employe updateEmploye(Long id, Employe employeDetails) {
        Employe employe = getEmployeById(id);

        employe.setNom(employeDetails.getNom());
        employe.setPrenom(employeDetails.getPrenom());
        employe.setPoste(employeDetails.getPoste());
        employe.setEmail(employeDetails.getEmail());
        employe.setDateEmbauche(employeDetails.getDateEmbauche());

        return employeRepository.save(employe);
    }

    // Supprimer un employé
    public void deleteEmploye(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employé non trouvé avec l'ID : " + id);
        }
        employeRepository.deleteById(id);
    }
}
