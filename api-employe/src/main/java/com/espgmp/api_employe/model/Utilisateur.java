package com.espgmp.api_employe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "utilisateurs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false)
	    private String nom;
	    
	    @Column(nullable = false)
	    private String prenom;
	    
	    @Column(nullable = false, unique = true)
	    private String username;
	    
	    @Column(nullable = false)
	    private String password;
	    
	    @Column(unique = true)
	    private String email;
	    
	    @Column(nullable = false, unique = true)
	    private String telephone;
	    
	    @ManyToOne
	    @JoinColumn(name = "role_id" ) 
	    private Role role;

}
