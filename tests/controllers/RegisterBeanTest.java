package controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterBeanTest {

    @Test
    public void getEmail() {
        RegisterBean rb = new RegisterBean();
        rb.setEmail("maria@wp.pl");
        assertEquals(rb.getEmail(), "maria@wp.pl");
    }

    @Test
    public void getPassword() {
        RegisterBean rb = new RegisterBean();
        rb.setPassword("kasia");
        assertEquals(rb.getPassword(), "kasia");
    }

    @Test
    public void getUsername() {
        RegisterBean rb = new RegisterBean();
        rb.setUsername("kasia2");
        assertEquals(rb.getUsername(), "kasia2");
    }

    @Test
    public void getSecondUsername() {
        RegisterBean rb = new RegisterBean();
        rb.setUsername("kasia255");
        assertEquals(rb.getUsername(), "kasia255");
    }

    @Test
    public void getSurname() {
        RegisterBean rb = new RegisterBean();
        rb.setSurname("Wolska");
        assertEquals(rb.getSurname(), "Wolska");
    }
}