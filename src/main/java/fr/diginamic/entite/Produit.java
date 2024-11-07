package fr.diginamic.entite;

import fr.diginamic.enumeration.ProdType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;

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
}
