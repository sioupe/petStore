package fr.diginamic.entite;

import fr.diginamic.enumeration.ProdType;
import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * representation des different produit existant
 */
@Entity
@Table(name = "produit")
public class Produit  implements Serializable {
    /**identifiant du produit*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;
    /**code barre du produit*/
    @Column(name ="CODE")
    private String code;
    /**nom du produit*/
    @Column(name ="LABEL")
    private String label;
    /**type du produit*/
    @Enumerated(EnumType.STRING)
    @Column(name ="PROD_TYPE")
    private ProdType type;
    /** prix du produit*/
    @Column(name ="PRIX")
    private double prix;

    /** listes contenants tout les magasins qui possee ce produit     */
    @ManyToMany(mappedBy = "produits")
    private Set<PetStore> petStores;

    /**
     * variable presente dans tous les constructeurs
     */
    {
        petStores=new HashSet<PetStore>();

    }

    /**
     * constructeur vide
     */
    public Produit() {
    }

    /**
     * constructeur parametre
     * @param code
     * @param label
     * @param type
     * @param prix
     */
    public Produit(String code, String label, ProdType type, double prix) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.prix = prix;
    }

    /**
     * Getter
     *
     * @return petStores
     */

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * rajout d'un petStore dans produit
     * @param petStore
     */
    public void addPetStore(PetStore petStore){
        petStores.add(petStore);
        if (!petStore.getProduits().contains(this)) {
            petStore.addProduit(this);
        }
    }

    /**
     * suppression d'un petstore dans produit
     * @param petStore
     */
    public void removePetStore(PetStore petStore){
        petStores.remove(petStore);
        if (!petStore.getProduits().contains(this)) {
            petStore.removeProduit(this);
        }
    }
}
