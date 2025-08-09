package com.espgmp.api_employe.auth;

import com.espgmp.api_employe.model.Utilisateur;
import com.espgmp.api_employe.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

  
    
    public Utilisateur loadUtilisateurByUsername(String username) {
        return utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé, verifier si la session n'est pas fermée"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Utilisateur utilisateur = loadUtilisateurByUsername(username);
        return new CustomUserDetails(utilisateur);
    }
}
