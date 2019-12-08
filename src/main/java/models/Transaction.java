package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id",nullable=false)
    private int id;

    @Column(name="user_id",nullable=false)
    private int user_id;

    @Column(name="bike_id",nullable=false)
    private int bike_id;

    @Column(name="date",nullable=false)
    private Date date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction(int user_id, int bike_id, Date date) {
        this.user_id = user_id;
        this.bike_id = bike_id;
        this.date = date;
    }

    public Transaction() {
    }
}
