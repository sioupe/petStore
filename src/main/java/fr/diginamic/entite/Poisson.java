package fr.diginamic.entite;

import fr.diginamic.enumeration.FishLivEnv;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "poisson")
public class Poisson extends Animale{
    /**lieu de vie du poisson*/
    @Enumerated(EnumType.STRING)
    @Column(name ="FISH_LIVING_ENV")
    private FishLivEnv livingEnv;

    /**
     * contructeur vide
     */
    public Poisson() {
        super();
    }

    /**
     * constructeur parametre
     * @param naissance
     * @param couleur
     * @param petstore
     * @param livingEnv
     */
    public Poisson(LocalDate naissance, String couleur, PetStore petstore, FishLivEnv livingEnv) {
        super(naissance, couleur, petstore);
        this.livingEnv = livingEnv;
    }
}
