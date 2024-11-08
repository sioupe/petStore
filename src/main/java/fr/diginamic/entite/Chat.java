package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

/**
 * representation d'un chat
 */
@Entity
@Table(name = "chat")
public class Chat extends Animale{

    /**id du chip du chat*/
    @Column(name ="CHIP_ID")
    private String chipId;

    /**
     * constructeur vide
     */
    public Chat() {
        super();
    }

    /**
     * constructeur parametre
     * @param naissance
     * @param couleur
     * @param petstore
     * @param chipId
     */
    public Chat(LocalDate naissance, String couleur, PetStore petstore, String chipId) {
        super(naissance, couleur, petstore);
        this.chipId = chipId;
    }
}
