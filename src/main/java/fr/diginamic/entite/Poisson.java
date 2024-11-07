package fr.diginamic.entite;

import fr.diginamic.enumeration.FishLivEnv;
import jakarta.persistence.*;

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
}
