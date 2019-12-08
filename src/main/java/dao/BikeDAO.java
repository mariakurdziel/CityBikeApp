package dao;

import models.Bike;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class BikeDAO {
    EntityManagerFactory factory;
    static EntityManager em;
    private List<Bike> bikes = new LinkedList<Bike>();

    public BikeDAO() {
        factory = Persistence.createEntityManagerFactory("CityBikesApp");
        em = factory.createEntityManager();
        getAllBikes();
    }

    public void getAllBikes() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CityBikesApp");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM Bike ", Bike.class);
            bikes = q.getResultList();
            for (Bike b : bikes)
                System.out.println(b);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }
    }

    public static void deleteBike(Long id){

        try {
            Bike foundBike = em.find(Bike.class, id);
            DAO.delete(foundBike,em);
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public void addBike(Bike b) {
        try {
            DAO.add(b,em);
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
        }
    }
    public static void updateBike(Bike bike) {
        try {
            Bike foundBike = em.find(Bike.class, bike.getBake_id());

            em.getTransaction().begin();
            foundBike.setBake_id(bike.getBake_id());
            foundBike.setStreet_name(bike.getStreet_name());
            foundBike.setIs_free(bike.isIs_free());
            em.getTransaction().commit();
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
        }
    }

    public static Bike getBikeById(Long id){
        System.out.println( em.find(Bike.class,id));
        return em.find(Bike.class,id);
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }
}
