package controllers;

import dao.BikeDAO;
import dao.TransactionDAO;
import dao.UserDAO;
import models.Bike;
import models.Transaction;
import models.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Named("login")
@RequestScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkBike(User u) {
        new PanelBean().setIs_bike(false);
        new PanelBean().setNot_bike(true);
        List <Transaction> transactions = new TransactionDAO().getTransactions();
        List <Bike> bikes = new BikeDAO().getBikes();

       for(Transaction t: transactions) {
           if(t.getUser_id() == u.getId()) {
               for (Bike b: bikes) {
                   if(t.getBike_id()==b.getBake_id() && b.isIs_free()==false) {
                       System.out.println("Here");
                       new PanelBean().setIs_bike(true);
                       new PanelBean().setNot_bike(false);
                       new PanelBean().setBike(b);
                   }
               }
           }
       }
    }

    public String authenticate(){

        UserDAO userDAO = new UserDAO();
        List <User> users = userDAO.getUsers();
        boolean is_paid = false;
        boolean found = false;
        PanelBean pb = new PanelBean();
        pb.setShowOptions(false);
        for(User u: users) {
            if(u.getEmail().equals(this.email) && u.getPassword().equals(this.password)) {
                checkBike(u);
                found = true;
                is_paid = u.isIs_paid();
                pb.setUser(u);
                break;
            }
        }
        if(found) {
            pb.setIs_abonament(is_paid);
            pb.setNot_abonament(!is_paid);
            return "panel.xhtml";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!","No user with given credentials");
            facesContext.addMessage("login", facesMessage);
        }
        return "";
    }
}