package fr.diginamic.executable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class app {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em);







        em.getTransaction().commit();






        em.close();
        emf.close();
    }
}
