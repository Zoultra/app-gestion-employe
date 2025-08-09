package com.espgmp.api_employe.service;

import com.espgmp.api_employe.exceptions.ResourceNotFoundException;
import com.espgmp.api_employe.model.Role;
import com.espgmp.api_employe.model.Utilisateur;
 
import com.espgmp.api_employe.repository.UtilisateurRepository;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

   

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Créer un utilisateur (avec un objet Utilisateur complet)
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));

        return utilisateurRepository.save(utilisateur);
    }

    // Récupérer tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Récupérer un utilisateur par ID
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID: " + id));
    }

    // Mettre à jour un utilisateur
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID: " + id));

        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setPrenom(utilisateurDetails.getPrenom());
        utilisateur.setUsername(utilisateurDetails.getUsername());
        utilisateur.setTelephone(utilisateurDetails.getTelephone());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setRole(utilisateurDetails.getRole());

       

        // Si tu veux gérer la modification du mot de passe, il faut ici encoder avant setPassword

        return utilisateurRepository.save(utilisateur);
    }

    // Supprimer un utilisateur
    public void deleteUtilisateur(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new ResourceNotFoundException("Utilisateur non trouvé avec l'ID: " + id);
        }
        utilisateurRepository.deleteById(id);
    }
}
