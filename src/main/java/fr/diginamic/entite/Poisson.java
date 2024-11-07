package fr.diginamic.entite;

import fr.diginamic.enumeration.FishLivEnv;
import jakarta.persistence.*;

@Entity
@Table(name = "poisson")
public class Poisson extends Animale{
    @Enumerated(EnumType.STRING)
    @Column(name ="FISH_LIVING_ENV")
    private FishLivEnv livingEnv;

    public Poisson() {
        super();
    }
}