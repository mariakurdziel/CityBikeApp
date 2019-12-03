package models;

import javax.persistence.*;

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

    @Column(name="hours",nullable=false)
    private String number_of_hours;

    @Column (name="price", nullable=false)
    private String price;

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

    public String getNumber_of_hours() {
        return number_of_hours;
    }

    public void setNumber_of_hours(String number_of_hours) {
        this.number_of_hours = number_of_hours;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Transaction(int user_id, int bike_id, String number_of_hours, String price) {
        this.user_id = user_id;
        this.bike_id = bike_id;
        this.number_of_hours = number_of_hours;
        this.price = price;
    }
}
