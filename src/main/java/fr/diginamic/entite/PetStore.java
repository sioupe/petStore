package fr.diginamic.entite;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "pet_store")
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "possede",
            joinColumns = @JoinColumn(name = "ID_PET_STORE",referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn (name = "ID_PRODUIT",referencedColumnName = "ID")
    )
    private Set<Produit> produits;

    @OneToMany(mappedBy = "petStore",cascade = CascadeType.PERSIST)
    private Set<Animale>animaux;

    {
        produits=new HashSet<Produit>();
        animaux=new HashSet<Animale>();

    }
    public PetStore() {
    }

    public PetStore(String nom, String nomManager, Adresse adresse) {
        this.nom = nom;
        this.nomManager = nomManager;
        this.adresse = adresse;
    }

    /**
     * Setter
     *
     * @param animale animale
     */


    public void setAnimaux(Animale animale) {
        animale.setPetstore(this);
    }

    /**
     * Getter
     *
     * @return produits
     */

    public Set<Produit> getProduits() {
        return produits;
    }

    /**
     * Getter
     *
     * @return animaux
     */

    public Set<Animale> getAnimaux() {
        return animaux;
    }

    public void addProduit(Produit produit){
        produits.add(produit);
        if (!produit.getPetStores().contains(this)) {
            produit.addPetStore(this);
        }
    }
    public void removeProduit(Produit produit){
        produits.remove(produit);
        if (!produit.getPetStores().contains(this)) {
            produit.removePetStore(this);
        }
    }
}
