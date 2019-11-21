package controllers;

import models.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name="database")
@RequestScoped
public class DatabaseBean {

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

            em.merge(u1);
            em.merge(u2);
            em.merge(u3);
            em.merge(u4);
            em.merge(u5);

            em.getTransaction().commit();
            System.out.println("Zapisano w bazie: " + u1);
            System.out.println("Zapisano w bazie: " + u2);

        }
        catch(Exception e) {
            System.err.println("Blad przy dodawaniu rekordu: " + e);
        }
    }
}
