package fr.diginamic.entite;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "animale")
public class Animale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="NAISSANCE")
    private LocalDate naissance;
    @Column(name ="COULEUR")
    private String couleur;
}
