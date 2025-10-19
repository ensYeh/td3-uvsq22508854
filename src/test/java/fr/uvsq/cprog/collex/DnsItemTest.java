package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;

public class DnsItemTest {
    @Test
    public void testCreationItem() {
        AdressIp ip = new AdressIp("8.8.8.8");
        NomMachine nm = new NomMachine("dns.google");
        DnsItem item = new DnsItem(ip, nm);

        assertEquals(ip, item.getAdresse());
        assertEquals(nm, item.getNom());
    }

    @Test
    public void testToString() {
        DnsItem item = new DnsItem(new AdressIp("8.8.8.8"), new NomMachine("dns.google"));
        assertEquals("8.8.8.8 dns.google", item.toString());
    }
}
