package com.espgmp.api_employe.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.espgmp.api_employe.model.Utilisateur;

@RestController

@RequiredArgsConstructor
@RequestMapping("/employe-api/auth")
public class AuthController { 

    private final AuthenticationManager authManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(request.getUsername());
        Utilisateur utilisateur = userDetails.getUtilisateur();

        String token = jwtUtil.generateToken(utilisateur.getUsername(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getRole());
        
        return new AuthResponse(token);
    }
}
