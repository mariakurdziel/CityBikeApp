package controllers;

import dao.BikeDAO;
import dao.TransactionDAO;
import javafx.scene.layout.Pane;
import models.Bike;
import models.Transaction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named("bike")
@RequestScoped
public class RentBikeBean {
    private static String street;
    private static List <Bike> street_bikes = new ArrayList<Bike>();
    private static boolean showBikes;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        RentBikeBean.street = street;
    }

    public List<Bike> getStreet_bikes() {
        return street_bikes;
    }

    public void setStreet_bikes(List<Bike> street_bikes) {
        RentBikeBean.street_bikes = street_bikes;
    }

    public boolean isShowBikes() {
        return showBikes;
    }

    public void setShowBikes(boolean showBikes) {
        RentBikeBean.showBikes = showBikes;
    }

    public void getBikes() {
        List<Bike> bikes = new BikeDAO().getBikes();
        showBikes=true;
        for (Bike b: bikes) {
            if(b.getStreet_name().equals(street) && b.isIs_free() == true) {
                street_bikes.add(b);
            }
        }
    }

    public void rentBike(Bike bike) {

        bike.setIs_free(false);
        BikeDAO.updateBike(bike);
        PanelBean pb = new PanelBean();
        pb.setNot_bike(false);
        pb.setIs_bike(true);
        pb.setBike(bike);
        int user_id = new PanelBean().getUser().getId();
        Transaction t = new Transaction(user_id, bike.getBake_id(), new Date());
        new TransactionDAO().addTransaction(t);

    }
}
