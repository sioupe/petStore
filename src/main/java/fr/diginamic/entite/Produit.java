package fr.diginamic.entite;

import fr.diginamic.enumeration.ProdType;
import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Produit  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="CODE")
    private String code;
    @Column(name ="LABEL")
    private String label;
    @Column(name ="PROD_TYPE")
    private ProdType type;
    @Column(name ="PRIX")
    private double prix;


    @ManyToMany(mappedBy = "produits")
    private Set<PetStore> petStores;


    {
        petStores=new HashSet<PetStore>();

    }

    public Produit() {
    }

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

    public void addPetStore(PetStore petStore){
        petStores.add(petStore);
        if (!petStore.getProduits().contains(this)) {
            petStore.addProduit(this);
        }
    }

    public void removePetStore(PetStore petStore){
        petStores.remove(petStore);
        if (!petStore.getProduits().contains(this)) {
            petStore.removeProduit(this);
        }
    }
}
