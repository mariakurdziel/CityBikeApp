package controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("contact")
@RequestScoped
public class ContactBean {

    private String type_of_problem;
    private String topic;
    private String msg;
    private String sign;

    public String getType_of_problem() {
        return type_of_problem;
    }

    public void setType_of_problem(String type_of_problem) {
        this.type_of_problem = type_of_problem;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String sendMessage() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Wysłano!","Wiadomość wysłana");
        facesContext.addMessage("contact", facesMessage);
        return "panel";
    }

}
