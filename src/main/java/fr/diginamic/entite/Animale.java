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

    @ManyToOne
    @JoinColumn(name="ID_PET_STORE")
    private PetStore petstore;

    public Animale() {
    }

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
        if(this.petstore != null){
            this.petstore.getAnimaux().remove(this);
        }
        this.petstore = petstore;
        if (this.petstore == null) {
            this.petstore.getAnimaux().add(this);
        }
    }
}
