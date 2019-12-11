package controllers;

import org.junit.Test;
import static org.junit.Assert.*;

public class PanelBeanTest {

    @Test
    public void basicIncrement() {
        PanelBean pb = new PanelBean();
        int old_sec = pb.getSec();
        pb.increment();
        assertEquals(pb.getSec(), old_sec+1);
    }

    @Test
    public void minutesIncrement() {
        PanelBean pb = new PanelBean();
        pb.setSec(59);
        int old_min = pb.getMin();
        pb.increment();
        assertEquals(pb.getMin(), old_min+1);
        assertEquals(pb.getSec(),0);
    }

    @Test
    public void timeMessage() {
        PanelBean pb = new PanelBean();
        pb.setMin(0);
        pb.setSec(59);
        pb.increment();
        assertEquals(pb.getTime(), "1 min 0 sec");
    }

    @Test
    public void getType() {
        PanelBean pb = new PanelBean();
        pb.setAbonament("70");
        assertEquals(pb.getType(), "Miesieczny 70 zl");
        pb.setAbonament("50");
        assertEquals(pb.getType(), "Podstawowy 50 zl");
    }

    @Test
    public void getAbonament() {
        PanelBean pb = new PanelBean();
        pb.setAbonament("50");
        assertEquals(pb.getAbonament(), "50");
        pb.setAbonament("70");
        assertEquals(pb.getAbonament(), "70");
    }

}