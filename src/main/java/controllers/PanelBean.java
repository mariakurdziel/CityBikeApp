package controllers;

import dao.UserDAO;
import models.User;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("panel")
@SessionScoped
public class PanelBean implements Serializable {

    private static int user_id;
    private static User user;
    private static boolean is_abonament;
    private static boolean not_abonament;
    private static boolean showOptions;
    private static boolean abonament;

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

    public boolean isAbonament() {
        return abonament;
    }

    public void setAbonament(boolean abonament) {
        PanelBean.abonament = abonament;
    }

    public String buyAbonament() {
        is_abonament=true;
        not_abonament=false;
        showOptions=false;
        return "checkout";
    }
}