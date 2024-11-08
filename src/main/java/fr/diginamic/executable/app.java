package fr.diginamic.executable;


import fr.diginamic.entite.*;
import fr.diginamic.enumeration.FishLivEnv;
import fr.diginamic.enumeration.ProdType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em);

        Produit produit1 = new Produit("1","corde",ProdType.ACCESSOIRE,8.52);
        Produit produit2 = new Produit("2","paquet croquette 7kg",ProdType.NOURRITURE,50);
        Produit produit3 = new Produit("3","pelle a litiere",ProdType.NETTOYAGE,5);
        PetStore shop1 = new PetStore("Maxizoo","Bochaton",new Adresse(200,"avenue des tamaris",34130,"St aunes"));
        PetStore shop2 = new PetStore("animaux Cool","Pirhana",new Adresse(46,"rue du maine coon",34170,"Castelnau-le-lez"));
        PetStore shop3 = new PetStore("Canigou","Lupin",new Adresse(47,"avenue du levrier",34740,"Vendargues"));
        Chat chat1 = new Chat(LocalDate.of(2024,6,23),"noir",shop3,"Allemagne");
        Chat chat2 = new Chat(LocalDate.of(2024,4,15),"bleu",shop3,"France");
        Chat chat3 = new Chat(LocalDate.of(2024,5,10),"calico",shop2,"France");
        Poisson poisson1 = new Poisson(LocalDate.of(2024,1,1),"violet",shop2, FishLivEnv.EAU_SALE);
        Poisson poisson2 = new Poisson(LocalDate.of(2023,8,4),"argente",shop1,FishLivEnv.EAU_DOUCE);
        Poisson poisson3 = new Poisson(LocalDate.of(2024,9,2),"raye rouge et blanc",shop1,FishLivEnv.EAU_SALE);

        produit1.addPetStore(shop1);
        produit2.addPetStore(shop2);
        produit3.addPetStore(shop3);

        em.persist(chat1);
        em.persist(chat2);
        em.persist(chat3);
        em.persist(poisson1);
        em.persist(poisson2);
        em.persist(poisson3);
        Scanner scanner =new Scanner(System.in);
        String choix ="";
        while (choix.isEmpty()) {
            System.out.println("choisi entre :\n\t 1."+shop1.getNom()+" \n\t 2."+shop2.getNom()+"\n\t 3."+shop3.getNom());
            switch (scanner.nextInt()) {
                case 1:
                    choix = shop1.getNom();
                case 2:
                    choix = shop2.getNom();
                case 3:
                    choix = shop3.getNom();
                default:
                    System.out.println("choisie parmis les trois proposition avec le numero ecrit au debut du choix");
            }
        }
        TypedQuery<Animale> query= em.createQuery("select a From Animale a where a.petStore.nom= :choix", Animale.class);//requete pour trouver les animaux du magasin maxizoo
        query.setParameter("choix",choix);//requete pour modifier le parametre : choix et permettre le choix par l'utilisateur
        List<Animale> animales= query.getResultList();


        em.getTransaction().commit();
        System.out.println(animales);





        em.close();
        emf.close();
    }
}
