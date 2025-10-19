package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;


public class AdressIpTest {
    @Test
    public void testAdresseValide() {
        AdressIp ip = new AdressIp("192.168.0.1");
        assertEquals("192.168.0.1", ip.getAdresse());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdresseInvalide() {
        new AdressIp("999.300.0.1");
    }

    @Test
    public void testEqualsEtHashCode() {
        AdressIp ip1 = new AdressIp("10.0.0.1");
        AdressIp ip2 = new AdressIp("10.0.0.1");
        assertTrue(ip1.equals(ip2));
        assertEquals(ip1.hashCode(), ip2.hashCode());
    }
}
