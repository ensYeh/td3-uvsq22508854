package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;



public class DnsTest {
    @Test
    public void testAjoutEtRecherche() {
        Dns dns = new Dns();
        dns.addItem("192.168.1.1", "serveur.local");

        DnsItem item = dns.getItem(new AdressIp("192.168.1.1"));
        assertNotNull(item);
        assertEquals("serveur.local", item.getNom().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjoutNomExistant() {
        Dns dns = new Dns();
        dns.addItem("192.168.1.1", "serveur.local");
        dns.addItem("192.168.1.2", "serveur.local");
    }

    @Test
    public void testGetItemsParDomaine() {
        Dns dns = new Dns();
        dns.addItem("192.168.1.1", "a.local");
        dns.addItem("192.168.1.2", "b.local");
        dns.addItem("8.8.8.8", "dns.google");

        List<DnsItem> items = dns.getItems("local");
        assertEquals(2, items.size());
        assertEquals("a.local", items.get(0).getNom().toString());
    }

    @Test
    public void testSize() {
        Dns dns = new Dns();
        dns.addItem("10.0.0.1", "test.local");
        assertEquals(1, dns.size());
    }
}
