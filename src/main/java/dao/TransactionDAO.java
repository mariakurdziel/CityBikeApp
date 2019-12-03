package dao;

import models.Transaction;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class TransactionDAO {

    EntityManagerFactory factory;
    static EntityManager em;
    private List<Transaction> transactions = new LinkedList<Transaction>();

    public TransactionDAO() {
        factory = Persistence.createEntityManagerFactory("CityBikesApp");
        em = factory.createEntityManager();
        getAllTransactions();
    }

    public void getAllTransactions() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CityBikesApp");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM Transaction ", Transaction.class);
            transactions = q.getResultList();
            for (Transaction t : transactions)
                System.out.println(t);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }

    }

    public static void deleteTransaction(Long id){

        try {
            Transaction foundTransaction = em.find(Transaction.class, id);
            DAO.delete(foundTransaction,em);
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public void addTransaction(Transaction t) {
        try {
            DAO.add(t,em);
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
        }
    }
    public static void updateTransaction(Transaction transaction) {
        try {
            Transaction foundTransaction = em.find(Transaction.class, transaction.getId());

            em.getTransaction().begin();
            foundTransaction.setUser_id(transaction.getUser_id());
            foundTransaction.setBike_id(transaction.getBike_id());
            foundTransaction.setNumber_of_hours(transaction.getNumber_of_hours());
            foundTransaction.setPrice(transaction.getPrice());
            em.getTransaction().commit();
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
        }
    }

    public static Transaction getTransactionById(Long id){
        System.out.println( em.find(Transaction.class,id));
        return em.find(Transaction.class,id);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
