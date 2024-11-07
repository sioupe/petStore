package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
}
