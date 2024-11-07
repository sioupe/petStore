package fr.diginamic.entite;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    private Long id;
    private int numero;
    private String rue;
    private int codePostal;
    private String ville;

    public Adresse(){

    }
    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("numero=").append(numero);
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", codePostal=").append(codePostal);
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
