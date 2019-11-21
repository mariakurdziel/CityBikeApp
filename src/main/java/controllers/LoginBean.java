package controllers;

import dao.UserDAO;
import models.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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

    public String authenticate(){

        UserDAO userDAO = new UserDAO();
        List <User> users = userDAO.getUsers();
        boolean found = false;

        for(User u: users) {
            if(u.getEmail().equals(this.email) && u.getPassword().equals(this.password)) {
                found = true;
                break;
            }
        }
        if(found) {
            return "panel.xhtml";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!","No user with given credentials");
            facesContext.addMessage("login", facesMessage);
        }
        return "";
    }
}