package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="user_id",nullable=false)
    private int id;

    @Column(name="email",nullable=false)
    private String email;

    @Column(name="username",nullable=false)
    private String username;

    @Column(name="password",nullable=false)
    private String password;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name="surname",nullable=false)
    private String surname;

    @Column(name="is_paid",nullable=false)
    private boolean is_paid;

    @Column(name="abonament",nullable=false)
    private String abonament;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isIs_paid() { return is_paid; }

    public void setIs_paid(boolean is_paid) { this.is_paid = is_paid; }

    public String getAbonament() { return abonament; }

    public void setAbonament(String abonament) { this.abonament = abonament; }

    public User(int id, String email, String username, String password, String name, String surname) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name  = name;
        this.surname = surname;
        this.is_paid = false;
        this.abonament = "0";
    }

    public User(){}

}
