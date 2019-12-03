package controllers;

import models.Transaction;
import models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

@Named("database")
@RequestScoped
public class DatabaseBean implements Serializable {

    public void createTable() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CityBikesApp");
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();

           User u1 = new User(221, "mariak@wp.pl", "mariak", "lalala", "Maria", "Kurdziel");
           User u2 = new User(222, "alan@wp.pl", "alan", "lololo", "Ala", "Nowak");
           User u3 = new User(223, "arturk@o2.pl", "arturk", "hohoho", "Artur", "Kowalski");
           User u4 = new User(224, "szymond@o2.pl","szymond", "tralala", "Szymon", "Drwal");
           User u5 = new User(225, "gabrielac@o2.pl", "gabrielac", "wiktor", "Gabriela", "Ciołek");

           //Transaction t1 = new Transaction(220, 320, "0", "5.0");

            em.merge(u1);
            em.merge(u2);
            em.merge(u3);
            em.merge(u4);
            em.merge(u5);
            //em.merge(t1);

            em.getTransaction().commit();
            System.out.println("Zapisano w bazie: " + u1);
            System.out.println("Zapisano w bazie: " + u2);
            //System.out.println("Zapisano w bazie: " + t1);
        }
        catch(Exception e) {
            System.err.println("Blad przy dodawaniu rekordu: " + e);
        }
    }
}
