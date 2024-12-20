package fr.diginamic.entite;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * la table representant un shop
 */
@Entity
@Table (name = "pet_store")
public class PetStore {
    /**id du shop*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    /**nom du shop*/
    @Column(name ="NOM")
    private String nom;
    /**nom du manager du shop*/
    @Column(name ="NOM_MANAGER")
    private String nomManager;
    /**adresse du shop*/
    @Embedded
    private Adresse adresse;

    /**listes des produits du shop*/
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "possede",
            joinColumns = @JoinColumn(name = "ID_PET_STORE",referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn (name = "ID_PRODUIT",referencedColumnName = "ID")
    )
    private Set<Produit> produits;

    /**listes des animaux du shop*/
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animale>animaux;

    {
        produits=new HashSet<Produit>();
        animaux=new HashSet<Animale>();

    }

    /**
     * constructeur vide
     */
    public PetStore() {
    }

    /**
     * construteur parametre
     * @param nom
     * @param nomManager
     * @param adresse
     */
    public PetStore(String nom, String nomManager, Adresse adresse) {
        this.nom = nom;
        this.nomManager = nomManager;
        this.adresse = adresse;
    }

    /**
     * Getter
     *
     * @return nom
     */

    public String getNom() {
        return nom;
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

    /**
     * fonction de rajout d'un produit dans petStore
     * @param produit
     */
    public void addProduit(Produit produit){
        produits.add(produit);
        if (!produit.getPetStores().contains(this)) {
            produit.addPetStore(this);
        }
    }

    /**
     * suppression d'un produit de petStore
     * @param produit
     */
    public void removeProduit(Produit produit){
        produits.remove(produit);
        if (!produit.getPetStores().contains(this)) {
            produit.removePetStore(this);
        }
    }

    /**
     * affichage des données d'un shop
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", nomManager='").append(nomManager).append('\'');
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }
}
