package controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactBeanTest {

    @Test
    public void getType_of_problem() {
        ContactBean cb = new ContactBean();
        cb.setType_of_problem("Usterka roweru");
        assertEquals(cb.getType_of_problem(), "Usterka roweru");
    }

    @Test
    public void getTopic() {
        ContactBean cb = new ContactBean();
        cb.setTopic("Zepsuty rower");
        assertEquals(cb.getTopic(), "Zepsuty rower");
    }

    @Test
    public void getMsg() {
        ContactBean cb = new ContactBean();
        cb.setMsg("Blabla");
        assertEquals(cb.getMsg(), "Blabla");
    }

    @Test
    public void getSign() {
        ContactBean cb = new ContactBean();
        cb.setSign("Maria");
        assertEquals(cb.getSign(), "Maria");
    }
}