package models;

import javax.persistence.*;

@Entity
@Table(name = "bikes")
public class Bike {
    @Id
    @Column(name="bake_id",nullable=false)
    private int bake_id;

    @Column(name="street_name",nullable=false)
    private String street_name;

    @Column(name="is_free",nullable=false)
    private boolean is_free;

    public int getBake_id() {
        return bake_id;
    }

    public void setBake_id(int bake_id) {
        this.bake_id = bake_id;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public boolean isIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    public Bike(int bake_id, String street_name, boolean is_free) {
        this.bake_id = bake_id;
        this.street_name = street_name;
        this.is_free = is_free;
    }

    public Bike() {}
}
