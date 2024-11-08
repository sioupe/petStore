package fr.diginamic.entite;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * la table des animaux achetable dans un shop
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "animale")
public class Animale {
    /**id de l'animal*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;
    /**date de naissance de l'animale*/
    @Column(name ="NAISSANCE")
    private LocalDate naissance;
    /**couleur de l'animale*/
    @Column(name ="COULEUR")
    private String couleur;

    /**shop qui possede l'animal*/
    @ManyToOne
    @JoinColumn(name="ID_PET_STORE")
    private PetStore petStore;

    /**
     * constructeur vide
     */
    public Animale() {
    }

    /**
     * constructeur parametre
     * @param naissance
     * @param couleur
     * @param petstore
     */
    public Animale(LocalDate naissance, String couleur, PetStore petstore) {
        this.naissance = naissance;
        this.couleur = couleur;
        this.setPetstore(petstore);
    }

    /**
     * Setter
     *
     * @param petstore petstore
     */


    public void setPetstore(PetStore petstore) {
        if(this.petStore != null){
            this.petStore.getAnimaux().remove(this);
        }
        this.petStore = petstore;
        if (this.petStore == null) {
            this.petStore.getAnimaux().add(this);
        }
    }
}
