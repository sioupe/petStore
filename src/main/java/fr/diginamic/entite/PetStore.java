package fr.diginamic.entite;

import jakarta.persistence.*;

public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="NOM")
    private String nom;
    @Column(name ="NOM_MANAGER")
    private String nomManager;
    @Embedded
    private Adresse adresse;
}
