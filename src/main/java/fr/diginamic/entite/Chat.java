package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat")
public class Chat extends Animale{

    @Column(name ="CHIP_ID")
    private String chipId;

    public Chat() {
        super();
    }
}
