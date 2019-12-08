package controllers;

import dao.BikeDAO;
import dao.UserDAO;
import models.Bike;
import models.User;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named("panel")
@SessionScoped
public class PanelBean implements Serializable {

    private static int user_id;
    private static User user;
    private static boolean is_abonament;
    private static boolean not_abonament;
    private static boolean is_bike;
    private static boolean not_bike;
    private static boolean showOptions;
    private static String abonament;
    private static String type;
    private static Bike bike;
    private static int sec;
    private static int min=60;
    private static String time;
    private static double debt=0;

    public static int getUser_id() {
        return user_id;
    }

    public static void setUser_id(int user_id) {
        PanelBean.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIs_abonament() {
        return is_abonament;
    }

    public void setIs_abonament(boolean is_abonament) {
        this.is_abonament = is_abonament;
    }

    public boolean isNot_abonament() {
        return not_abonament;
    }

    public void setNot_abonament(boolean not_abonament) {
        this.not_abonament = not_abonament;
    }

    public boolean isShowOptions() {
        return showOptions;
    }

    public void setShowOptions(boolean showOptions) {
        PanelBean.showOptions = showOptions;
    }

    public static void viewOptions() {
        showOptions = true;
    }

    public String getAbonament() {
        return abonament;
    }

    public void setAbonament(String abonament) {
        PanelBean.abonament = abonament;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        PanelBean.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        PanelBean.min = min;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        PanelBean.debt = debt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        PanelBean.time = time;
    }

    public boolean isIs_bike() {
        return is_bike;
    }

    public void setIs_bike(boolean is_bike) {
        PanelBean.is_bike = is_bike;
    }

    public boolean isNot_bike() {
        return not_bike;
    }

    public void setNot_bike(boolean not_bike) {
        PanelBean.not_bike = not_bike;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        PanelBean.bike = bike;
    }

    public String getType() {
        if(abonament.equals("50")) {
            return "Podstawowy 50 zl";
        } else if(abonament.equals("70")) {
            return "Miesieczny 70 zl";
        } else if(abonament.equals("200")) {
            return "Semestralny 200 zl";
        } else {
            return "Roczny 350 zl";
        }
    }

    public void setType(String type) {
            PanelBean.type=type;
    }

    public void returnBike() {
        bike.setIs_free(true);
        BikeDAO.updateBike(bike);
        debt = min*0.1;

        if(min>60) {
            debt+=(min-60)*0.5;
        }
        Double old_abonament=Double.parseDouble(user.getAbonament());
        String abonament = new Double(old_abonament-debt).toString();
        user.setAbonament(abonament);
        UserDAO.updateUser(user);
        is_bike = false;
        not_bike = true;
        min=0;
        sec=0;
        time="";
    }

    public void increment() {

        sec++;

       if(sec%60==0 && sec!=0) {

           if(min>60) {
               FacesContext facesContext = FacesContext.getCurrentInstance();
               FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Uwaga!","Przekroczono czas użytkowania");
               facesContext.addMessage("warning", facesMessage);
           }
            sec=0;
            min++;
        }


        time = new Integer(min).toString()+" min "+new Integer(sec).toString()+ " sec";
    }

    public void buyAbonament() {
        new RentBikeBean().setShowBikes(false);
        is_abonament=true;
        not_abonament=false;
        showOptions=false;
        new RentBikeBean().setShowBikes(false);
        user.setAbonament(abonament);
        user.setIs_paid(is_abonament);
        UserDAO.updateUser(user);
    }
}