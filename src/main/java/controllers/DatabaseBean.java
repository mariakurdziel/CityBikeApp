package controllers;

import models.Bike;
import models.Transaction;
import models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.Date;

@Named("database")
@RequestScoped
public class DatabaseBean implements Serializable {

    public void createTable() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CityBikesApp");
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();

           /*User u1 = new User(221, "mariak@wp.pl", "mariak", "lalala", "Maria", "Kurdziel");
           User u2 = new User(222, "alan@wp.pl", "alan", "lololo", "Ala", "Nowak");
           User u3 = new User(223, "arturk@o2.pl", "arturk", "hohoho", "Artur", "Kowalski");
           User u4 = new User(224, "szymond@o2.pl","szymond", "tralala", "Szymon", "Drwal");
           User u5 = new User(225, "gabrielac@o2.pl", "gabrielac", "wiktor", "Gabriela", "Ciołek");*/

           Bike b1 = new Bike(320, "Czarnowiejska 17", true);
           Bike b2 = new Bike(321, "Czarnowiejska 17", true);
           Bike b3 = new Bike(322, "Czarnowiejska 17", true);
           Bike b4 = new Bike(323, "Czarnowiejska 17", true);
           Bike b5 = new Bike(324, "Czarnowiejska 17", true);
           Bike b6 = new Bike(325, "Pawia 9", true);
           Bike b7 = new Bike(326, "Pawia 9", true);
           Bike b8 = new Bike(327, "Pawia 9", true);
           Bike b9 = new Bike(328, "Pawia 9", true);
           Bike b10 = new Bike(329, "Pawia 9", true);
           Bike b11 = new Bike(330, "Grunwaldzka 12", true);
            Bike b12 = new Bike(331, "Grunwaldzka 12", true);
            Bike b13 = new Bike(332, "Grunwaldzka 12", true);
            Bike b14 = new Bike(333, "Grunwaldzka 12", true);
            Bike b15 = new Bike(334, "Grunwaldzka 12", true);
            Bike b16 = new Bike(335, "Armii Krajowej 9", true);
            Bike b17 = new Bike(336, "Armii Krajowej 9", true);
            Bike b18 = new Bike(337, "Armii Krajowej 9", true);
            Bike b19 = new Bike(338, "Armii Krajowej 9", true);
            Bike b20 = new Bike(339, "Armii Krajowej 9", true);



            Transaction t1 = new Transaction(220, 320, new Date());

            em.getTransaction().commit();
            //System.out.println("Zapisano w bazie: " + u1);
            //System.out.println("Zapisano w bazie: " + u2);
            System.out.println("Zapisano w bazie: " + b1);
        }
        catch(Exception e) {
            System.err.println("Blad przy dodawaniu rekordu: " + e);
        }
    }
}
