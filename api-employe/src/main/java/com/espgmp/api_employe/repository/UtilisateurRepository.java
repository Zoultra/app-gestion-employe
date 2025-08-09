package com.espgmp.api_employe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.espgmp.api_employe.model.Utilisateur;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	    Optional<Utilisateur> findByUsername(String username);
	    Optional<Utilisateur> findByEmail(String email);

}
