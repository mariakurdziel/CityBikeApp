package controllers;

import dao.UserDAO;
import models.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

@Named("register")
@RequestScoped
public class RegisterBean implements Serializable {

    private String email;
    private String username;
    private String password;
    private String name;
    private String surname;


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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String addUser() {
        String lUUID = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
        int id = new Integer(lUUID.substring(0,3));
        User user = new User(id, this.email, this.username, this.password, this.name, this.surname);
        new UserDAO().addUser(user);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dodano użytkownika","Użytkownik dodany");
        facesContext.addMessage("register", facesMessage);
        return "index.xhtml";
    }
}