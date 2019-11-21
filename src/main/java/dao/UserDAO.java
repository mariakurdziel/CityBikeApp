package dao;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
    EntityManagerFactory factory;
    static EntityManager em;
    private List<User> users =new LinkedList<User>();

    public UserDAO() {
        factory = Persistence.createEntityManagerFactory("CityBikesApp");
        em = factory.createEntityManager();
        getAllUsers();
    }

    public void getAllUsers() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CityBikesApp");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM User", User.class);
            users = q.getResultList();
            for (User u : users)
                System.out.println(u);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }

    }

    public static void deleteUser(Long id){

        try {
            User foundUser = em.find(User.class, id);
            DAO.delete(foundUser,em);
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public void addUser(User u) {
        try {
            DAO.add(u,em);
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
        }
    }
    public static void updateUser(User user) {
        try {
            User foundUser = em.find(User.class, user.getId());

            em.getTransaction().begin();
            foundUser.setId(user.getId());
            foundUser.setEmail(user.getEmail());
            foundUser.setUsername(user.getUsername());
            foundUser.setPassword(user.getPassword());
            foundUser.setName(user.getName());
            foundUser.setSurname(user.getSurname());
            em.getTransaction().commit();
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
        }
    }

    public static User getUserById(Long id){
        System.out.println( em.find(User.class,id));
        return em.find(User.class,id);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
